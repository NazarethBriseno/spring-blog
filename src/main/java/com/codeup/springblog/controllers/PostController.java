package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postsDao;
    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }
    @GetMapping
    public String allPosts(Model model){
        Post post1 = new Post(1, "First", "This is my first post");
        List<Post> allPosts= new ArrayList<>(List.of(post1));
        model.addAttribute("allPosts", allPosts);
        return "/posts/index";
    }

//    @GetMapping
//    public String indexPost(){
//        return "/index";
//    }

    @GetMapping("/{id}")
    public String individualPost(@PathVariable int id, Model model){
        model.addAttribute("postID", id);
        return "/show";
    }

    @GetMapping("/create")
    public String createPost(){
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@RequestParam(name="title") String title, @RequestParam(name="body") String body){
        Post post = new Post(title, body);
        postsDao.save(post);
        return "redirect:/posts";
    }
}
