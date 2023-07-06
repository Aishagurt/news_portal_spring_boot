package kz.bitlab.techboot.springsecurityboot.controller;


import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.model.Post;
import kz.bitlab.techboot.springsecurityboot.model.User;
import kz.bitlab.techboot.springsecurityboot.service.PostService;
import kz.bitlab.techboot.springsecurityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    private final int POSTS_PER_PAGE = 7;

    @GetMapping(value = "/")
    public String indexPage() {
        return "home";
    }

    @GetMapping(value = "/sign-in-page")
    public String signinPage() {
        return "signin";
    }

    @GetMapping(value = "/sign-up-page")
    public String signupPage() {
        return "signup";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage() {
        return "profile";
    }

    @GetMapping(value = "/update-password-page")
    public String updatePasswordPage() {
        return "update-password";
    }

    @GetMapping(value = "/log-out")
    public String logOut(){ return "log-out"; };

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        if (password.equals(repeatPassword)) {
            User user = new User();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            User newUser = userService.addUser(user);
            if (newUser != null) {
                return "redirect:/sign-up-page?success";
            } else {
                return "redirect:/sign-up-page?emailerror";
            }
        } else {
            return "redirect:/sign-up-page?passworderror";
        }
    }

    @PostMapping(value = "/to-update-password")
    public String toUpdatePassword(
            @RequestParam(name = "user_old_password") String oldPassword,
            @RequestParam(name = "user_new_password") String newPassword,
            @RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {

        if (newPassword.equals(repeatNewPassword)) {

            User user = userService.updatePassword(newPassword, oldPassword);
            if (user != null) {
                return "redirect:/update-password-page?success";
            } else {
                return "redirect:/update-password-page?oldpassworderror";
            }

        } else {
            return "redirect:/update-password-page?passwordmismatch";
        }
    }

    @GetMapping(value = "/posts")
    public String postsPage(Model model) {
        List<PostDTO> allPosts = postService.getPosts();
        List<PostDTO> initialPosts = new ArrayList<>();
        for(int i = 0; i < POSTS_PER_PAGE; i++){
            initialPosts.add(allPosts.get(i));
        }
        model.addAttribute("posts", initialPosts);

        int totalPosts = allPosts.size();
        model.addAttribute("totalPosts", totalPosts);
        return "/posts";
    }

    @GetMapping("/load-more")
    public ResponseEntity<List<PostDTO>> loadMorePosts(@RequestParam("page") int page) {
        int startIndex = page * POSTS_PER_PAGE;
        List<PostDTO> morePosts = postService.getPosts(startIndex, POSTS_PER_PAGE - 1);

        return ResponseEntity.ok(morePosts);
    }

    @GetMapping(value = "/add-post")
    public String addPostPage(){
        return "/add-post";
    }

    @GetMapping(value = "/postInfo/{id}")
    public String postInfoPage(@PathVariable(name = "id") Long id, Model model){
        PostDTO postDTO = postService.getPost(id);
        model.addAttribute("post", postDTO);
        return "/postInfo";
    }

}