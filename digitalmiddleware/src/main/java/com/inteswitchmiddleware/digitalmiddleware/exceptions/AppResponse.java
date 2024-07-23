package com.inteswitchmiddleware.digitalmiddleware.exceptions;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AppResponse<T> implements Serializable {

    private String status;

    private String message;

    private T data;
    private double execTime = 0;
    @Builder.Default
    private Object error = new ArrayList<>();
}
