package com.java38.spring_framework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExceptionController {

    @GetMapping("get-sda-exception")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void showSdaException() {
        throw new SdaException("SDA Exception");
    }

    @GetMapping("get-specific-sda-exception")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void showSpecificSdaException() {
        throw new SpecificSdaException("Specific SDA Exception");
    }
}
