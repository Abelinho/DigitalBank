package com.inteswitchmiddleware.digitalmiddleware.dto.request;

import com.inteswitchmiddleware.digitalmiddleware.entity.Account;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String firstName;
    private String lastName;
    @NotEmpty(message="email must be provided")
    private String email;
    @NotEmpty(message="bvn must be provided")
    private String bvn;
    @NotEmpty(message="nin must be provided")
    private String nin;
    //private Set<Account> accounts;
}
