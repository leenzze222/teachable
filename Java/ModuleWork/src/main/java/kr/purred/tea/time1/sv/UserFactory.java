package kr.purred.tea.time1.sv;

import kr.purred.tea.time1.model.MyUser;
import kr.purred.tea.time1.type.UserType;

public class UserFactory {

    public UserSv getSv(UserType type) {
        switch (type) {
            case USER:
                return new MyUserSv();
            case FRIEND:
                return new MyFriendSv();
            default:
                return null;
        }
    }
}
