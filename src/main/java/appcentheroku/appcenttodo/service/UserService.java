package appcentheroku.appcenttodo.service;

import appcentheroku.appcenttodo.converter.UserMapper;
import appcentheroku.appcenttodo.dao.UserDao;
import appcentheroku.appcenttodo.dto.UserSavingDto;
import appcentheroku.appcenttodo.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserSavingDto save(UserSavingDto userSavingDto){

        Users users = UserMapper.INSTANCE.convertUserSavingDtoToUser(userSavingDto);
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);

        users = userDao.save(users);

        UserSavingDto savedUserSavingDto = UserMapper.INSTANCE.convertUserToUserSavingDto(users);

        return savedUserSavingDto;
    }

    public Users findByEmail(String email){
        Optional<Users> optionalUser  = userDao.findByEmail(email);
        Users users = null;
        if(optionalUser.isPresent()){
            users = optionalUser.get();
        }
        return users;
    }


    public Long findIdByUsername(String username) {

        Optional<Users> optionalUser  = userDao.findByUsername(username);
        Users users = null;

        if(optionalUser.isPresent()){
            users = optionalUser.get();
        }
        return users.getId();
    }

    public Users findById(Long id) {
        Optional<Users> optionalUser  = userDao.findById(id);
        Users users = null;

        if(optionalUser.isPresent()){
            users = optionalUser.get();
        }
        return users;

    }

}
