package kz.bitlab.techboot.springsecurityboot.service;

import kz.bitlab.techboot.springsecurityboot.dto.UserDTO;
import kz.bitlab.techboot.springsecurityboot.mapper.UserMapper;
import kz.bitlab.techboot.springsecurityboot.model.Permission;
import kz.bitlab.techboot.springsecurityboot.model.User;
import kz.bitlab.techboot.springsecurityboot.repository.PermissionRepository;
import kz.bitlab.techboot.springsecurityboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("User Not found");
        }
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Set<Permission> permissionSet =  new HashSet<>();
        List<Permission> permissions = permissionRepository.findAll();
        permissionSet.add(permissions.get(1));
        user.setPermissions(permissionSet);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDTO(savedUser);
    }

    public UserDTO updatePassword(String newPassword, String oldPassword) {

        User currentUser = getCurrentSessionUser();

        if(passwordEncoder.matches(oldPassword, currentUser.getPassword())){
            currentUser.setPassword(passwordEncoder.encode(newPassword));
            return userMapper.toUserDTO(userRepository.save(currentUser));
        }
        return null;
    }

    public User getCurrentSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            if (user != null) {
                return user;
            }
        }
        return null;
    }

    public UserDTO updateUser(UserDTO user) {
        User currentUser = getCurrentSessionUser();

        currentUser.setEmail(user.getEmail());
        currentUser.setFullName(user.getFullName());

        return userMapper.toUserDTO(userRepository.save(currentUser));
    }

    private Set<Permission> mapPermissionDTOs(List<Permission> permissions){
        Set<Permission> permissionSet = new HashSet<>();
        for(Permission permission: permissions){
            Permission permission1 = permissionRepository.findByRole(permission.getRole());
            if(permission1 == null){
                permission1 = new Permission(permission.getRole());
                permissionRepository.save(permission);
            }
            permissionSet.add(permission1);
        }
        return permissionSet;
    }

    public String isPasswordValid(String password) {
        if (password.length() < 8)
            return "Password must be at least 8 characters long.";
        else if (!password.matches(".*[A-Z].*"))
            return "Password must contain at least one uppercase letter.";

        else if (!password.matches(".*[a-z].*"))
            return "Password must contain at least one lowercase letter.";
        else if (!password.matches(".*\\d.*"))
            return "Password must contain at least one digit.";
        else if (!password.matches(".*[!@#$%^&*()].*"))
            return "Password must contain at least one special character.";

        return null;
    }

    public String signUpUser(String email, String password, String repeatPassword, String fullName) {
        if (!password.equals(repeatPassword)) {
            return "redirect:/sign-up-page?passworderror";
        }

        UserDTO user = new UserDTO();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(password);

        UserDTO newUser = addUser(user);
        if (newUser != null) {
            return "redirect:/sign-up-page?success";
        } else {
            return "redirect:/sign-up-page?emailerror";
        }
    }

    public void logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

}
