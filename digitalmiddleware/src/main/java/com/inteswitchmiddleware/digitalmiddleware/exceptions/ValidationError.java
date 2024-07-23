package com.inteswitchmiddleware.digitalmiddleware.exceptions;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ValidationError implements Serializable {
    private Object rejectedValue;
    private String field;
    private String objectName;
}
