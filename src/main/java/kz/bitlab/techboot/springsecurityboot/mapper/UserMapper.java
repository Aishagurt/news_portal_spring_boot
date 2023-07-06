package kz.bitlab.techboot.springsecurityboot.mapper;

import kz.bitlab.techboot.springsecurityboot.dto.PermissionDTO;
import kz.bitlab.techboot.springsecurityboot.dto.UserDTO;
import kz.bitlab.techboot.springsecurityboot.model.Permission;
import kz.bitlab.techboot.springsecurityboot.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = PermissionMapper.class)
public interface UserMapper {
    UserDTO toUserDTO(User user);

    @InheritInverseConfiguration
    User toUser(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> userList);
    List<User> toModelList(List<UserDTO> userDTOList);

    default List<PermissionDTO> mapPermissions(Set<Permission> permissionSet) {
        List<PermissionDTO> permissionDTOS = new ArrayList<>();
        for (Permission permission : permissionSet) {
            permissionDTOS.add(new PermissionDTO(permission.getId(), permission.getRole()));
        }
        return permissionDTOS;
    }

    default Set<Permission> mapTagDTOs(List<PermissionDTO> permissionDTOS) {
        Set<Permission> permissionSet = new HashSet<>();
        for (PermissionDTO permissionDTO : permissionDTOS) {
            permissionSet.add(new Permission(permissionDTO.getRole()));
        }
        return permissionSet;
    }
}

