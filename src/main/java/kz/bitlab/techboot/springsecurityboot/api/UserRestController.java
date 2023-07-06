package kz.bitlab.techboot.springsecurityboot.api;

import kz.bitlab.techboot.springsecurityboot.model.User;
import kz.bitlab.techboot.springsecurityboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/user")
public class UserRestController {
    private final UserService userService;

    @PutMapping
    public User updateUser(@RequestBody User user) { return userService.updateUser(user); }
}
