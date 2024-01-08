package com.example.aula6.dto;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrorDTO {
    @Getter
    private List<String> errors;
    public ApiErrorDTO(String mensagem){
        this.errors = Arrays.asList(mensagem);
    }
    public ApiErrorDTO(List<String> errors){
        this.errors = errors;
    }
}
