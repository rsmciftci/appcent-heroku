package appcentheroku.appcenttodo.converter;

import appcentheroku.appcenttodo.dto.UserDto;
import appcentheroku.appcenttodo.dto.UserSavingDto;
import appcentheroku.appcenttodo.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source="email", target = "email")
    @Mapping(source="email", target = "username")
    Users convertUserSavingDtoToUser(UserSavingDto userSavingDto);

    UserSavingDto convertUserToUserSavingDto(Users users);

    UserDto convertUserToUserDto(Users users);
}
