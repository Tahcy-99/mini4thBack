package org.com.mini4thback.user;

import lombok.RequiredArgsConstructor;
import org.com.mini4thback.user.model.User;
import org.com.mini4thback.user.model.UserDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    public final UserRepository userRepository;

    public void signin(UserDto.Signin dto){
        User user = dto.toEntity();
        userRepository.save(user);
    }
}
