//package kz.bitlab.techboot.springsecurityboot.mapper;
//
//import kz.bitlab.techboot.springsecurityboot.dto.ProfileDTO;
//import kz.bitlab.techboot.springsecurityboot.dto.UserDTO;
//import kz.bitlab.techboot.springsecurityboot.model.Permission;
//import kz.bitlab.techboot.springsecurityboot.model.Profile;
//import kz.bitlab.techboot.springsecurityboot.model.User;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import java.util.Base64;
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface ProfileMapper {
//    UserDTO toDto(User user);
//
//    List<String> mapToString(List<Permission> permissions);
//
//
//    List<Permission> mapToPermission(List<String> permissions);
//
//    String map(Permission permission);
//
//    Permission map(String value);
//
//    User toModel(UserDTO userDTO);
//
//    ProfileDTO map(Profile profile);
//
//    default String mapToString(byte[] value) {
//        return Base64.getEncoder().encodeToString(value);
//    }
//    default byte[] mapToByte(String value) {
//        return Base64.getDecoder().decode(value);
//    }
//
//
//    Profile map(ProfileDTO profileDTO);
//}
