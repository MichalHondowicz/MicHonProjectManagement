package com.michonsoftware.pmapp.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface ValidationErrorService {

    ResponseEntity<?> validationErrorService(BindingResult result);
}
