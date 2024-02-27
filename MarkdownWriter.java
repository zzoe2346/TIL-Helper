import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MarkdownWriter {
    public static final String HEADER_CONTENT =
            """
                    # TIL(Today I Learned)
                    > 기껏 공부해놓고 계속 까먹어서 기록하려함
                                
                    ## Category
                    """;

    public void write(HashMap<String, ArrayList<String>> map, HashMap<String, String> titleMap) throws IOException {
        // 목표 폴더 경로
        String folderPath = "/Users/seonghunjeong/til";

        // 폴더를 나타내는 File 객체 생성
        File file = new File(folderPath, "README.md");
        //만약 이미 README.md가 있을 경우 삭제
        file.delete();
        //파일 생성
        if (file.createNewFile()) {
            System.out.println("성공");
            //내용 쓰기
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(HEADER_CONTENT);

            for (Map.Entry<String, ArrayList<String>> stringArrayListEntry : map.entrySet()) {
                String key = stringArrayListEntry.getKey();
                fileWriter.write("### " + key + "\n");
                for (String s : stringArrayListEntry.getValue()) {
                    fileWriter.write(String.format("- [%s](./%s/%s)\n", titleMap.get(s), key, s));
                }
                fileWriter.write("\n");
            }
            fileWriter.flush();
        } else {
            System.out.println("fail");
        }
    }
}
