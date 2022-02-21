package appcentheroku.appcenttodo.controller;


import appcentheroku.appcenttodo.dto.UserRequestDto;
import appcentheroku.appcenttodo.dto.UserSavingDto;
import appcentheroku.appcenttodo.entity.Users;
import appcentheroku.appcenttodo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth/")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("login")
    public String login(@RequestBody UserRequestDto userRequestDto){
        return authenticationService.login(userRequestDto);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody @Valid UserSavingDto userSavingDto){

        String email = userSavingDto.getEmail();

        try {
            authenticationService.validateUserRequest(email);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        Users users = authenticationService.register(userSavingDto);


        return new ResponseEntity<>("User registered.",HttpStatus.CREATED);


    }


}
