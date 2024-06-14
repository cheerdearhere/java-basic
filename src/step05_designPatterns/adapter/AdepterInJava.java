package step05_designPatterns.adapter;

import java.io.*;
import java.util.*;

public class AdepterInJava {
    public static void main(String[] args) {
        //Arrays.asList: Array -> List
        List<String> list = Arrays.asList("a", "b", "c");
        //List -> enumeration
        Enumeration<String> enumeration = Collections.enumeration(list);
        //enumeration -> ArrayList
        ArrayList<String> arrayList = Collections.list(enumeration);

        //io
        try(
                // String -> InputStream
            InputStream is = new FileInputStream("input.txt");
                // InputStream -> InputStreamReader
            InputStreamReader isr = new InputStreamReader(is);
                // InputStreamReader -> BufferedReader
            BufferedReader reader = new BufferedReader(isr);
        ){
            System.out.println(reader.readLine());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
