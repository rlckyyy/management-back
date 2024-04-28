package relucky.code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import relucky.code.model.dto.UserDto;
import relucky.code.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void save(@RequestBody UserDto userDto){
        userService.save(userDto);
    }
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello world baby";
    }

}
