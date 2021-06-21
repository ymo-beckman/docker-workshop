package com.beckman.todobackend.controller;

import com.beckman.todobackend.service.CalculateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "计算")
@RequestMapping("/api/v1/calculate")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculateController {
    private final CalculateService calculateService;

    @GetMapping("")
    @ApiOperation("计算平方")
    ResponseEntity<Long> calculate(@RequestParam("number") long number) {
        Long result = calculateService.getCalculateResult(number);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
