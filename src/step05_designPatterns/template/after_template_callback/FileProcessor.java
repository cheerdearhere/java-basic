package step05_designPatterns.template.after_template_callback;

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
    public int process(Operator operator){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = null;
            while((line = reader.readLine()) != null){
                result = operator.setResult(result, Integer.parseInt(line));//이부분만 하위에서 정의하도록함
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
