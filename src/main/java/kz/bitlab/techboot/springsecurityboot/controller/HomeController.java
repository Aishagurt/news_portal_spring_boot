package kz.bitlab.techboot.springsecurityboot.controller;

import kz.bitlab.techboot.springsecurityboot.dto.CategoryDTO;
import kz.bitlab.techboot.springsecurityboot.dto.PostDTO;
import kz.bitlab.techboot.springsecurityboot.dto.UserDTO;
import kz.bitlab.techboot.springsecurityboot.service.CategoryService;
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
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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

    @PostMapping(value = "/to-update-password")
    public String toUpdatePassword(
            @RequestParam(name = "user_old_password") String oldPassword,
            @RequestParam(name = "user_new_password") String newPassword,
            @RequestParam(name = "user_repeat_new_password") String repeatNewPassword) {

        if (newPassword.equals(repeatNewPassword)) {
            String passwordValidationMsg = userService.isPasswordValid(newPassword);
            if (passwordValidationMsg != null)
                return "redirect:/update-password-page?error=" + URLEncoder.encode(passwordValidationMsg, StandardCharsets.UTF_8);

            UserDTO user = userService.updatePassword(newPassword, oldPassword);
            if (user != null)
                return "redirect:/update-password-page?success";
            else
                return "redirect:/update-password-page?oldpassworderror";


        } else
            return "redirect:/update-password-page?passwordmismatch";

    }

    @GetMapping("/log-out")
    public RedirectView logOut() {
        userService.logout();
        return new RedirectView("posts");
    }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String fullName) {
        return userService.signUpUser(email, password, repeatPassword, fullName);
    }

    @GetMapping(value = "/posts")
    public String postsPage(Model model) {
        List<PostDTO> initialPosts = postService.getInitialPosts();
        model.addAttribute("posts", initialPosts);

        List<PostDTO> totalPosts = postService.getPosts();
        int totalPostsSize = initialPosts.size();
        model.addAttribute("totalPosts", totalPostsSize);

        List<CategoryDTO> categoryDTOS = categoryService.getCategories();
        model.addAttribute("categories", categoryDTOS);

        return "posts";
    }

    @GetMapping("/load-more")
    public ResponseEntity<List<PostDTO>> loadMorePosts(@RequestParam("page") int page, @RequestParam(value = "catId", required = false) Long catId) {
        List<PostDTO> morePosts = postService.getMorePosts(page, POSTS_PER_PAGE, catId);
        return ResponseEntity.ok(morePosts);
    }

    @GetMapping(value = "/postInfo/{id}")
    public String postInfoPage(@PathVariable(name = "id") Long id, Model model){
        PostDTO postDTO = postService.getPost(id);
        model.addAttribute("post", postDTO);

        List<CategoryDTO> categoryDTOS = categoryService.getCategories();
        model.addAttribute("categories", categoryDTOS);

        return "postInfo";
    }

    @GetMapping(value = "/category/{catId}")
    public String CategoryPosts(@PathVariable(name="catId") Long id, Model model){
        CategoryDTO category = categoryService.getCategory(id);
        model.addAttribute("category", category);

        List<CategoryDTO> categoryDTOS = categoryService.getCategories();
        model.addAttribute("categories", categoryDTOS);

        List<PostDTO> postDTOS = postService.getInitialPostsByCategoryId(id);
        model.addAttribute("posts", postDTOS);
        return "posts";
    }

}