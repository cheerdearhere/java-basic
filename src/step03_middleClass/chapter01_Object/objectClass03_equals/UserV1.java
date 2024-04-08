package step03_middleClass.chapter01_Object.objectClass03_equals;

import java.util.Objects;

public class UserV1 {
    private String id;

    public UserV1(String id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof UserV1) {
//            UserV1 u = (UserV1)obj;
//            return this.id.equals(u.id);
//        }
//        else{
//            return this.equals(obj);
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserV1 userV1 = (UserV1) o;
        return Objects.equals(id, userV1.id);
    }

}
