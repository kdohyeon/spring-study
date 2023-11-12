package kdohyeon.springstudy.aop.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/v1/user/name/{name}")
    public User getUserByName(String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/api/v1/user/phone/{phoneNumber}")
    public User getUserByPhoneNumber(String phoneNumber) {
        return userService.getUserByPhoneNumber(phoneNumber);
    }
}
