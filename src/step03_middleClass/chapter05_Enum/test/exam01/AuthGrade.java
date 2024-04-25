package step03_middleClass.chapter05_Enum.test.exam01;

public enum AuthGrade {
    GUEST(1,"손님"),
    LOGIN(2, "로그인 회원"),
    ADMIN(3,"관리자");

    private final int level;
    private final String description;
    AuthGrade(int level, String description){
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }
    public String getDescription() {
        return description;
    }
    public String getAuthInfo(){
        return "level:"+level+" description:"+description;
    }
    public String getMenu(){
        StringBuilder builder = new StringBuilder("==메뉴 목록==\n");
        builder.append("- 메인 화면\n");
        if(level > 1){
            builder.append("- 이메일 관리 화면\n");
        }
        if(level > 2){
            builder.append("- 관리자 화면\n");
        }
        return builder.toString();
    }
    @Override
    public String toString(){
        return "당신의 등급은 "+description+"입니다.";
    }
}
