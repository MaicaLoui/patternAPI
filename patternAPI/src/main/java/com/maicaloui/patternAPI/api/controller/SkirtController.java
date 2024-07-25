package com.maicaloui.patternAPI.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.maicaloui.patternAPI.api.GetSkirtPattern;
import com.maicaloui.patternAPI.api.model.SkirtPattern;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class SkirtController {

    @GetMapping("/skirtPattern")
    // http://localhost:8080/skirtPattern?hip=90&waist=78&hipHeight=20&skirtLength=40
    public HttpEntity<SkirtPattern> intent(
            // @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "hip", required = false) double hip,
            @RequestParam(value = "waist", required = false) double waist,
            @RequestParam(value = "hipHeight", required = false) double hipHeight,
            @RequestParam(value = "skirtLength", required = false) double skirtLength) {

        SkirtPattern intent = null;
        intent = GetSkirtPattern.skirtPatternResult(hip, waist, hipHeight, skirtLength);
        return new ResponseEntity<>(intent, HttpStatus.OK);
    }

}
