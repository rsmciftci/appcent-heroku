package appcentheroku.appcenttodo.controller;

import appcentheroku.appcenttodo.dto.UserSavingDto;
import appcentheroku.appcenttodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity create(@RequestBody UserSavingDto userSavingDto){
        UserSavingDto savedUserSavingDto = userService.save(userSavingDto);
        return ResponseEntity.ok(savedUserSavingDto);

    }

    @GetMapping("/{username}")
    public Long findUserIdByUsername(@PathVariable("username") String username){
        return userService.findIdByUsername(username);
    }

}
