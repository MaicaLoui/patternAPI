package com.maicaloui.patternAPI.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.maicaloui.patternAPI.api.GetSkirtPattern;
import com.maicaloui.patternAPI.api.GetTrouserPattern;
import com.maicaloui.patternAPI.api.model.SkirtPattern;
import com.maicaloui.patternAPI.api.model.TrouserPattern;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TrouserController {

    @GetMapping("/trouserPattern")
    // http://localhost:8080/trouserPattern?trouserLength=90&inseamLength=67&waist=70&hip=95&kneeCircumference=39.5&heelAnkleCircumference=29&waistWidth=21&quadWidth=55.5&calvesWidth=36&crotchLength=61&trouserType=plain
    public HttpEntity<TrouserPattern> intent2(
            // @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "trouserLength", required = false) double trouserLength,
            @RequestParam(value = "inseamLength", required = false) double inseamLength,
            @RequestParam(value = "waist", required = false) double waist,
            @RequestParam(value = "hip", required = false) double hip,
            @RequestParam(value = "kneeCircumference", required = false) double kneeCircumference,
            @RequestParam(value = "heelAnkleCircumference", required = false) double heelAnkleCircumference,
            @RequestParam(value = "waistWidth", required = false) double waistWidth,
            @RequestParam(value = "quadWidth", required = false) double quadWidth,
            @RequestParam(value = "crotchLength", required = false) double crotchLength,
            @RequestParam(value = "calvesWidth", required = false) double calvesWidth,
            @RequestParam(value = "trouserType", required = false) String trouserType) {

        TrouserPattern intent2 = null;
        intent2 = GetTrouserPattern.trouserPatternResult(trouserLength, inseamLength, hip, waist, kneeCircumference,
                heelAnkleCircumference, waistWidth, calvesWidth, quadWidth, crotchLength, trouserType);
        return new ResponseEntity<>(intent2, HttpStatus.OK);
    }

}
