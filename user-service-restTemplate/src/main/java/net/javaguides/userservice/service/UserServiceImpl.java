package net.javaguides.userservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javaguides.userservice.dto.DepartmentDTO;
import net.javaguides.userservice.dto.ResponseDto;
import net.javaguides.userservice.dto.UserDTO;
import net.javaguides.userservice.entity.User;
import net.javaguides.userservice.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;


@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUser(Long userId) {

        ResponseDto responseDto = new ResponseDto();
        User user = userRepository.findById(userId).get();
        UserDTO userDto = mapToUser(user);

        //1. Using Rest Template
        ResponseEntity<DepartmentDTO> responseEntity = restTemplate
                .getForEntity("http://localhost:9091/api/departments/" + user.getDepartmentId(),
                        DepartmentDTO.class);

        DepartmentDTO departmentDto = responseEntity.getBody();
        System.out.println(responseEntity.getStatusCode());

        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);

        return responseDto;
    }

    private UserDTO mapToUser(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}

