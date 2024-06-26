package net.javaguides.userservice.service;

import net.javaguides.userservice.dto.ResponseDto;
import net.javaguides.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}
