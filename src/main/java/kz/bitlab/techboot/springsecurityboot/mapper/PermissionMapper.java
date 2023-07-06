package kz.bitlab.techboot.springsecurityboot.mapper;

import kz.bitlab.techboot.springsecurityboot.dto.PermissionDTO;
import kz.bitlab.techboot.springsecurityboot.model.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionDTO toPermissionDTO(Permission permission);

    Permission toPermission(PermissionDTO permissionDTO);

    List<PermissionDTO> toDtoList(List<Permission> permissions);

    List<Permission> toModelList(List<PermissionDTO> permissionDTOS);
}
