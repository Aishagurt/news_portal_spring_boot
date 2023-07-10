package kz.bitlab.techboot.springsecurityboot.controller;


import kz.bitlab.techboot.springsecurityboot.dto.CategoryDTO;
import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.dto.UserDTO;
import kz.bitlab.techboot.springsecurityboot.model.Category;
import kz.bitlab.techboot.springsecurityboot.service.CategoryService;
import kz.bitlab.techboot.springsecurityboot.service.PostService;
import kz.bitlab.techboot.springsecurityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private CategoryService categoryService;
    private final int POSTS_PER_PAGE = 7;

    @GetMapping(value = "/")
    public String indexPage() {
        return "signin";
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

    @GetMapping("/log-out")
    public RedirectView  logOut() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return new RedirectView("/posts");
    }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        if (password.equals(repeatPassword)) {
            UserDTO user = new UserDTO();
            user.setEmail(email);
            user.setFullName(fullName);
            user.setPassword(password);
            UserDTO newUser = userService.addUser(user);
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

            UserDTO user = userService.updatePassword(newPassword, oldPassword);
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

        List<CategoryDTO> categoryDTOS = categoryService.getCategories();
        model.addAttribute("categories", categoryDTOS);

        return "/posts";
    }

    @GetMapping("/load-more")
    public ResponseEntity<List<PostDTO>> loadMorePosts(@RequestParam("page") int page) {
        int startIndex = page * POSTS_PER_PAGE;
        List<PostDTO> morePosts = postService.getPosts(startIndex, POSTS_PER_PAGE - 1);

        return ResponseEntity.ok(morePosts);
    }
    @GetMapping(value = "/postInfo/{id}")
    public String postInfoPage(@PathVariable(name = "id") Long id, Model model){
        PostDTO postDTO = postService.getPost(id);
        model.addAttribute("post", postDTO);
        return "/postInfo";
    }

}