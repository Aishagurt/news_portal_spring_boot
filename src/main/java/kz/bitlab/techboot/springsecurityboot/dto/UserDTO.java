package kz.bitlab.techboot.springsecurityboot.dto;

import kz.bitlab.techboot.springsecurityboot.model.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private List<Permission> permissions;
//    private ProfileDTO profile;
}
