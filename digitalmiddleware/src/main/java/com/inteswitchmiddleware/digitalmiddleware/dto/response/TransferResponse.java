package com.inteswitchmiddleware.digitalmiddleware.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferResponse {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
