package com.github.rbaul.actuator.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/random-data")
@RequiredArgsConstructor
@Slf4j
public class RandomDataController {

    @GetMapping("/echo/{word}")
    public String echo(@PathVariable String word) {
        return word;
    }

}
