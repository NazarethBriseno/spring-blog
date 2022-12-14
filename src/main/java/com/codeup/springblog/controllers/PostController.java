package com.codeup.springblog.controllers;
import com.codeup.springblog.models.User;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostRepository postsDao;
    private final UserRepository usersDao;
    public PostController(PostRepository postsDao, UserRepository usersDao){
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }
    @GetMapping
    public String allPosts(Model model){
        List<Post> allPosts= postsDao.findAll();
        model.addAttribute("allPosts", allPosts);
        return "/posts/index";
    }


    @GetMapping("/{id}")
    public String individualPost(@PathVariable int id, Model model){
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/create")
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/create")
    public String submitPost(@ModelAttribute Post post){
        User user = usersDao.findById(1L);
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }
}
