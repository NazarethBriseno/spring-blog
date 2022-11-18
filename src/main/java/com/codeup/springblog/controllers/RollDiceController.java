package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/roll-dice")
public class RollDiceController {

    @GetMapping
    public String intro(){
    return "roll-dice";
}


@GetMapping("/{number}")
    public String userNumber(@PathVariable int number, Model model){
    int diceNumber = (int) (Math.random() * 6) + 1;
    model.addAttribute("diceNumber", diceNumber);
    model.addAttribute("number", number);
    return "roll-dice";

}


}
