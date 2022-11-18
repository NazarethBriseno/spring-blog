package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    public String indexPost(){
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String individualPost(@PathVariable int id, Model model){
        model.addAttribute("postID", id);
        return "posts/show";
    }

    @GetMapping("/create")
    @ResponseBody
    public String createPost(){
        return "View the form for creating a post";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createPostPost(){
        return "create a new post";
    }
}
