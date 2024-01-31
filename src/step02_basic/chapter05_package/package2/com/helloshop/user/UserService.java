package step02_basic.chapter05_package.package2.com.helloshop.user;

public class UserService {
    public User login(String userId, String name){
        return new User(userId,name);
    }
}
