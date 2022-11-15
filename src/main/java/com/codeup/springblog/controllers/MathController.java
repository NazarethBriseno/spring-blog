package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    //ADDITION
    @GetMapping("/add/{number1}/and/{number2}")
    @ResponseBody
    public int addition(@PathVariable int number1, @PathVariable int number2){
        return number1 + number2;
    }
    //SUBTRACTION
    @GetMapping("/subtract/{number1}/from/{number2}")
    @ResponseBody
    public int subtraction(@PathVariable int number1, @PathVariable int number2){
        return number2 - number1;
    }
    //MULTIPLICATION
    @GetMapping("/multiply/{number1}/and/{number2}")
    @ResponseBody
    public int multiply(@PathVariable int number1, @PathVariable int number2){
        return number2 * number1;
    }
    //DIVISION
    @GetMapping("/divide/{number1}/by/{number2}")
    @ResponseBody
    public int divide(@PathVariable int number1, @PathVariable int number2){
        return number1 / number2;
    }


}
