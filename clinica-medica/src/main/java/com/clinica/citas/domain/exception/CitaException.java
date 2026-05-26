package com.clinica.citas.domain.exception;

import com.clinica.shared.domain.exception.DomainException;

public class CitaException extends DomainException {
    public CitaException(String message) {
        super(message);
    }
}
