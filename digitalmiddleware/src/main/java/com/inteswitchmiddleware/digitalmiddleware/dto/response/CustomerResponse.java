package com.inteswitchmiddleware.digitalmiddleware.dto.response;

import com.inteswitchmiddleware.digitalmiddleware.entity.Account;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private String firstName;
    private String lastName;
    private String email;
    private String bvn;
    private String nin;
    //private Set<Account> accounts;
}
