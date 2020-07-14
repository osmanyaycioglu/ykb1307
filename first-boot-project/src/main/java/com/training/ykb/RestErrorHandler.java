package com.training.ykb;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public YkbErrorMessage handleIllegalArgumentException(final IllegalArgumentException exp) {

        return new YkbErrorMessage().itCrmCustomer()
                                    .errorDesc("Argument not valid. " + exp.getMessage())
                                    .errorIndex(1002);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public YkbErrorMessage handleMethodArgumentNotValidException(final MethodArgumentNotValidException exp) {

        YkbErrorMessage rootError = new YkbErrorMessage().itCrmCustomer()
                                                         .errorDesc("Validation error")
                                                         .errorIndex(1002);
        BindingResult bindingResultLoc = exp.getBindingResult();
        List<ObjectError> allErrorsLoc = bindingResultLoc.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.add(new YkbErrorMessage().itCrmCustomer()
                                               .errorDesc(objectErrorLoc.getDefaultMessage()
                                                          + " "
                                                          + objectErrorLoc.getCode())
                                               .errorIndex(3000));
        }
        return rootError;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public YkbErrorMessage handleException(final Exception exp) {
        return new YkbErrorMessage().itCrmCustomer()
                                    .errorDesc("Internal Error. " + exp.getMessage())
                                    .errorIndex(3001);
    }

}
