package appcentheroku.appcenttodo.converter;

import appcentheroku.appcenttodo.dto.UserDto;
import appcentheroku.appcenttodo.dto.UserSavingDto;
import appcentheroku.appcenttodo.entity.Users;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-21T09:04:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public Users convertUserSavingDtoToUser(UserSavingDto userSavingDto) {
        if ( userSavingDto == null ) {
            return null;
        }

        Users users = new Users();

        users.setEmail( userSavingDto.getEmail() );
        users.setUsername( userSavingDto.getEmail() );
        users.setName( userSavingDto.getName() );
        users.setMiddleName( userSavingDto.getMiddleName() );
        users.setSurname( userSavingDto.getSurname() );
        users.setPassword( userSavingDto.getPassword() );

        return users;
    }

    @Override
    public UserSavingDto convertUserToUserSavingDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UserSavingDto userSavingDto = new UserSavingDto();

        userSavingDto.setName( users.getName() );
        userSavingDto.setMiddleName( users.getMiddleName() );
        userSavingDto.setSurname( users.getSurname() );
        userSavingDto.setEmail( users.getEmail() );
        userSavingDto.setPassword( users.getPassword() );

        return userSavingDto;
    }

    @Override
    public UserDto convertUserToUserDto(Users users) {
        if ( users == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( users.getId() );
        userDto.setName( users.getName() );
        userDto.setMiddleName( users.getMiddleName() );
        userDto.setSurname( users.getSurname() );
        userDto.setUsername( users.getUsername() );
        userDto.setEmail( users.getEmail() );
        userDto.setPassword( users.getPassword() );

        return userDto;
    }
}
