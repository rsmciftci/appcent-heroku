package appcentheroku.appcenttodo.service;

import appcentheroku.appcenttodo.converter.UserMapper;
import appcentheroku.appcenttodo.dao.UserDao;
import appcentheroku.appcenttodo.dto.UserRequestDto;
import appcentheroku.appcenttodo.dto.UserSavingDto;
import appcentheroku.appcenttodo.entity.Users;
import appcentheroku.appcenttodo.jwt.security.EnumJwtConstant;
import appcentheroku.appcenttodo.jwt.security.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    public String login(UserRequestDto userRequestDto){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
                (userRequestDto.getUsername(),userRequestDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        return EnumJwtConstant.BEARER.getConstant() + token;

    }

    public Users register(UserSavingDto userSavingDto){

        String password = userSavingDto.getPassword();
        Users users = UserMapper.INSTANCE.convertUserSavingDtoToUser(userSavingDto);
        password = passwordEncoder.encode(password);
        users.setPassword(password);
        users = userDao.save(users);
        return users;
    }

    public void validateUserRequest(String email) {
        Optional<Users> optionalUser = userDao.findByEmail(email);
        if(optionalUser.isPresent()){
            throw new RuntimeException("Email is already taken.");
        }
    }
}
