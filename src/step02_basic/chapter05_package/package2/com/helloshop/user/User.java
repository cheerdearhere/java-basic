package step02_basic.chapter05_package.package2.com.helloshop.user;

import java.security.PublicKey;

public class User {
//    long userSeq;
    private String userId;
    private String name;
    public User(String userId, String name){
        this.name = name;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
}
