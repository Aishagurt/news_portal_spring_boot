package kz.bitlab.techboot.springsecurityboot.api;

import kz.bitlab.techboot.springsecurityboot.dto.UserDTO;
import kz.bitlab.techboot.springsecurityboot.model.User;
import kz.bitlab.techboot.springsecurityboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/user")
public class UserRestController {
    private final UserService userService;

    @PutMapping
    public UserDTO updateUser(@RequestBody UserDTO user) { return userService.updateUser(user); }
}
