package kdohyeon.springstudy.aop.user;

import kdohyeon.springstudy.aop.aspect.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name) {
        return userRepository.findByUserName(name)
                .orElse(new User("-", "test", "010-1234-5668"));
    }

    @Timer
    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElse(new User("-", "test", "010-1234-5668"));
    }
}
