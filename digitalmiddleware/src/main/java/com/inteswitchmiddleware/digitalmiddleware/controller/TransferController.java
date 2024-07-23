package com.inteswitchmiddleware.digitalmiddleware.controller;

import com.inteswitchmiddleware.digitalmiddleware.dto.request.TransferRequest;
import com.inteswitchmiddleware.digitalmiddleware.dto.response.TransferResponse;
import com.inteswitchmiddleware.digitalmiddleware.entity.Bank;
import com.inteswitchmiddleware.digitalmiddleware.entity.Transfer;
import com.inteswitchmiddleware.digitalmiddleware.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    //commented out, not yet fully implemented
//    @GetMapping("/banks")
//    public ResponseEntity<List<Bank>> getAllBanks() {
//        List<Bank> banks = transferService.getAllBanks();
//        return ResponseEntity.ok(banks);
//    }

    @PostMapping
    public ResponseEntity<TransferResponse> submitTransfer(@RequestBody TransferRequest transfer) {
        TransferResponse submittedTransfer = transferService.submitTransfer(transfer);

        /*//*/

        return ResponseEntity.ok(submittedTransfer);
    }
}
