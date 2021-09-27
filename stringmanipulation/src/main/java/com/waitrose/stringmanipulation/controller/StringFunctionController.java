package com.waitrose.stringmanipulation.controller;


import com.waitrose.stringmanipulation.service.StringFunctionService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RestController
public class StringFunctionController {

    @Autowired
    private StringFunctionService stringFunctionService;

    @GetMapping("/string/{inputStr}")
    public ResponseEntity getMaxInteger(
            @ApiParam(value = "Enter input String", required = true)
            @PathVariable String inputStr) throws Exception {

        Optional<BigInteger> maxInteger = Optional.ofNullable(stringFunctionService.stringFunction(inputStr));

        return new ResponseEntity<>(maxInteger, HttpStatus.OK);

    }


}
