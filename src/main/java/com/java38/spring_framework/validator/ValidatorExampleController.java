package com.java38.spring_framework.validator;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validator")
public class ValidatorExampleController {

    @GetMapping("example/{id}")
    public String example(@NotNull @PathVariable int id) {
        return "Successfully";
    }

    private String login(@URL String url, @Email String email, String password) {
        return "Successfully";
    }
}
