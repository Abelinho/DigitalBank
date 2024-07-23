package com.inteswitchmiddleware.digitalmiddleware.dto.request;


import com.inteswitchmiddleware.digitalmiddleware.entity.Bank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {

    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
    private String bankname;//necessary?
}
