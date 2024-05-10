package relucky.code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import relucky.code.model.entity.User;
import relucky.code.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    List<User> getUsers(){
        return userService.getAll();
    }

    @PostMapping
    User save(){
        return userService.save();
    }

    @GetMapping("me")
    Object sayHello(){
        return userService.getMe();
    }

    @GetMapping("{id}")
    User getUserById(@PathVariable Long id){
        return userService.getById(id);
    }

}
