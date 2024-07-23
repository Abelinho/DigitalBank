package com.inteswitchmiddleware.digitalmiddleware.service;

import com.inteswitchmiddleware.digitalmiddleware.dto.request.TransferRequest;
import com.inteswitchmiddleware.digitalmiddleware.dto.response.TransferResponse;
import com.inteswitchmiddleware.digitalmiddleware.entity.Account;
import com.inteswitchmiddleware.digitalmiddleware.entity.Bank;
import com.inteswitchmiddleware.digitalmiddleware.entity.Transfer;
import com.inteswitchmiddleware.digitalmiddleware.repository.AccountRepository;
import com.inteswitchmiddleware.digitalmiddleware.repository.BankRepository;
import com.inteswitchmiddleware.digitalmiddleware.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Transactional
    public TransferResponse submitTransfer(TransferRequest transferRequest) {
        // Implement transfer logic here
        Account fromAccount = accountRepository.findByAccountNumber(transferRequest.getFromAccount());
        Account toAccount = accountRepository.findByAccountNumber(transferRequest.getToAccount());

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Invalid account number(s)");
        }

        if (fromAccount.getBalance().compareTo(transferRequest.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance in fromAccount");
        }

        // Perform transfer
        fromAccount.setBalance(fromAccount.getBalance().subtract(transferRequest.getAmount()));
        toAccount.setBalance(toAccount.getBalance().add(transferRequest.getAmount()));

        // Save updated account balances
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Bank bank = new Bank(transferRequest.getBankname());
        Bank savedBank = bankRepository.save(bank);

        //build a transfer object and save
        Transfer transfer = new Transfer();
        transfer.setFromAccount(transferRequest.getFromAccount());
        transfer.setToAccount(transferRequest.getToAccount());
        transfer.setBank(savedBank);
         Transfer savedTransfer = transferRepository.save(transfer);

        return TransferResponse.builder()
        .amount(transferRequest.getAmount())
        .fromAccount(transferRequest.getFromAccount())
        .toAccount(transferRequest.getToAccount())
        .build();
    }
}
