package kdohyeon.springstudy.aop.user;

import lombok.Getter;

@Getter
public record User(String id, String name, String phoneNumber) {
}
