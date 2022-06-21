package com.deb.cib.nace.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorMessage {
    String statsu;
    String message;
}
