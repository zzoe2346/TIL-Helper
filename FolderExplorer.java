import java.io.*;
import java.net.URLEncoder;
import java.util.*;

public class FolderExplorer {
    public static void main(String[] args) throws IOException {

        // 탐색할 폴더 경로
        String folderPath = "/Users/seonghunjeong/til";

        // 폴더를 나타내는 File 객체 생성
        File folder = new File(folderPath);


        // 만약 해당 경로가 폴더가 아니라면 종료
        if (!folder.isDirectory()) {
            System.out.println("지정된 경로는 폴더가 아닙니다.");
            return;
        }

        // 폴더 내부의 파일 및 폴더 목록 가져오기
        File[] files = folder.listFiles();

        Queue<File> queue = new LinkedList<>();
        for (File file : files) {
            if (file.getName().charAt(0) == '.'||file.getName().equals("README.md")) continue;
            queue.add(file);
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, String> titleMap = new HashMap<>();

        while (!queue.isEmpty()) {
            File categoryDirectory = queue.poll();
            String categoryDirectoryName = categoryDirectory.getName();

            map.put(categoryDirectoryName, new ArrayList<>());
            if (categoryDirectory.isDirectory()) {
                Queue<File> markdownFileQueue = new LinkedList<>();
                for (File file : categoryDirectory.listFiles()) {
                    map.get(categoryDirectoryName).add(file.getName());
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    titleMap.put(file.getName(), br.readLine());
                }
            }
        }

        for (Map.Entry<String, ArrayList<String>> stringArrayListEntry : map.entrySet()) {
            String key = stringArrayListEntry.getKey();
            ArrayList<String> value = stringArrayListEntry.getValue();
        }

        MarkdownWriter markdownWriter = new MarkdownWriter();
        try {
            markdownWriter.write(map, titleMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
