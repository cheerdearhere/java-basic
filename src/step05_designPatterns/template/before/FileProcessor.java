package step05_designPatterns.template.before;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileProcessor {
    private final String path;
    private int result = 0;
    public FileProcessor (String path){
        this.path = path;
    }
    public int process(){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = null;
            while((line = reader.readLine()) != null){
                //return int > parseInt
                //return Integer > valueOf
                result += Integer.parseInt(line);
            }
            return result;
        }catch (IOException e){
            throw new IllegalArgumentException(path + "에 해당하는 파일이 없습니다.", e);
        }
    }
    public String getResult(){
        return String.format(
                """
                경로: %s
                시간: %s
                결과: %d건 처리완료
                """,
                path,
                LocalDateTime.now(),
                result
        );
    }
}
