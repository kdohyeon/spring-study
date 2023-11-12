package kdohyeon.springstudy.aop.user;

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
        long start = System.currentTimeMillis();
        User user = userRepository.findByUserName(name)
                .orElse(new User("-", "test", "010-1234-5668"));
        long end = System.currentTimeMillis();

        log.info("수행 시간={}ms", end-start);

        return user;
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        long start = System.currentTimeMillis();
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException(String.format("사용자를 찾을 수 없습니다. phoneNumber=%s", phoneNumber)));
        long end = System.currentTimeMillis();

        log.info("수행 시간={}ms", end-start);

        return user;
    }
}
