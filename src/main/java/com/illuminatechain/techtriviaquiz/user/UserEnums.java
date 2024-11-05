package com.illuminatechain.techtriviaquiz.user;



import com.illuminatechain.techtriviaquiz.common.IntEnum;
import lombok.Getter;

/**
 * UserEnums 클래스는 사용자의 성별, 상태 및 역할과 같은 다양한 열거형 타입을 정의합니다.
 * 각 열거형 타입은 IntEnum 인터페이스를 구현하며, 이를 통해 정수 값으로 변환될 수 있습니다.
 */
@Getter
public class UserEnums {


    public enum Gender implements IntEnum {
        MALE(0),           // 0
        FEMALE(1),         // 1
        OTHER(2),          // 2
        APACHEHELICOPTER(3);// 3
        //
        private final int intEnum;

        Gender(int value) {
            this.intEnum = value;
        }

        @Override
        public int getValue() {
            return intEnum;
        }
    }


    public enum Status implements IntEnum {

        INACTIVE(0),
        ACTIVE(1),
        SUSPENDED(3);

        private final int value;

        Status(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }


    }

    public enum Role implements IntEnum {
        NEWBIE(0),
        LISTENER(1),
        SPEAKER(2),
        MANAGER(3),
        ADMIN(4);

        private final int value;

        Role(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }


    }
//


}
