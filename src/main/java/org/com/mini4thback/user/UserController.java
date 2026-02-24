package org.com.mini4thback.user;

import lombok.RequiredArgsConstructor;
import org.com.mini4thback.user.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody UserDto.Signin dto){
        userService.signin(dto);
        return ResponseEntity.ok("성공");
    }

}
