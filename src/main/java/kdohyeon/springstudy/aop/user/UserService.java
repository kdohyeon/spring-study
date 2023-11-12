package kdohyeon.springstudy.aop.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("사용자를 찾을 수 없습니다. userName=%s", name)));
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException(String.format("사용자를 찾을 수 없습니다. phoneNumber=%s", phoneNumber)));
    }
}
