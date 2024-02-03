package step02_basic.chapter08_final.final1;

public class FinalMemberVariable{
    //    직접 초기화
    //인스턴스 변수
    final int instanceVariable1=10;
    //정적 변수
    static final int STATIC_VARIABLE_1=10;
    //    생성자에서 초기화
    final int instanceVariable2;
//    static final int STATIC_VARIABLE_2;//초기화 필수
    public FinalMemberVariable(int value){
//        instanceVariable1=value;
        instanceVariable2=value;
//        STATIC_VARIABLE_1=value;
//        STATIC_VARIABLE_2=value;
    }

//    수학 상수
    public static final double PI = 3.14;
//    시간 상수
    public static final int HOURS_IN_DAY = 24;
    public static final int MINUTES_IN_HOUR = 60;
    public static final int SECONDS_IN_MINUTE = 60;
    public static final int SECONDS_IN_DAY = HOURS_IN_DAY * MINUTES_IN_HOUR * SECONDS_IN_MINUTE;
//    애플리케이션 자체 제한
    public static final int MAXIMUM_USER = 1000;
    public static final int MAXIMUM_FILE_SIZE = 20*1024*1024;
    private static void userProcess(int currentUserCount){
        System.out.println("참여자 수: "+currentUserCount);
        if(currentUserCount > MAXIMUM_USER){
            System.out.println("\n - 대기자로 등록합니다(최대 "+MAXIMUM_USER+"명).");
        }else{
            System.out.println("\n - 게임에 참여합니다.");
        }
    }
    private static void fileUpload(int fileSize){
        if(fileSize > MAXIMUM_FILE_SIZE){
            System.out.println("20MB 이하 파일만 업로드할 수 있습니다.\n  파일 용량: "+fileSize);
        }else{
            System.out.println("파일을 업로드합니다.");
        }
    }

}
