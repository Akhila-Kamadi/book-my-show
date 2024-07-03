package akidev.me.bookmyshow.controllers;

import akidev.me.bookmyshow.dtos.CreateUserRequestDto;
import akidev.me.bookmyshow.dtos.CreateUserResponseDto;
import akidev.me.bookmyshow.models.User;
import akidev.me.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto request){
        User savedUser = userService.createUser(request.getEmail());
        CreateUserResponseDto response = new CreateUserResponseDto();
        response.setUser(savedUser);
        return response;
    }
}
