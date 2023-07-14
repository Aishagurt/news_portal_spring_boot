package kz.bitlab.techboot.springsecurityboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Set<PermissionDTO> permissions;
}
