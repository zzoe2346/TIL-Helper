import java.io.*;
import java.util.*;

public class FolderExplorer {
    static HashMap<String, ArrayList<String>> categoryAndContentListMap;
    static HashMap<String, String> localTitleAndViewTitle;

    public static File getFiles(String path) {
        // 탐색할 폴더 경로
        String folderPath = path;
        // TIL폴더에 대한 File 객체 생성
        File folder = new File(folderPath);
        // 만약 해당 경로가 폴더가 아니라면 에러발생.
        if (!folder.isDirectory()) {
            System.out.println("지정된 경로는 폴더가 아닙니다.");
            return null;
        }
        return folder;
    }
    public static void extractTitles(File folder) throws IOException {
        // 폴더 내부의 파일 및 폴더 목록 가져오기
        File[] files = folder.listFiles();

        Queue<File> queue = new LinkedList<>();
        for (File file : files) {
            if (file.getName().charAt(0) == '.' || file.getName().equals("README.md")) continue;
            //폴더명에 공백있으면 에러발생.
            if (file.getName().contains(" ")) {
                return;
            }
            //큐에 삽입.
            queue.add(file);
        }
        categoryAndContentListMap = new HashMap<>();
        localTitleAndViewTitle = new HashMap<>();

        //큐 순회.
        while (!queue.isEmpty()) {
            File categoryFolder = queue.poll();
            String categoryFolderName = categoryFolder.getName();

            //key: 카테고리 폴더 이름 value: 해당 폴더내부의 파일명들
            categoryAndContentListMap.put(categoryFolderName, new ArrayList<>());
            if (categoryFolder.isDirectory()) {
                for (File file : categoryFolder.listFiles()) {
                    categoryAndContentListMap.get(categoryFolderName).add(file.getName());
                    //마크다운파일 내부를 읽어서 제목 추출.
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    localTitleAndViewTitle.put(file.getName(), br.readLine());
                }
            }
        }


    }

public static HashMap<String, ArrayList<String>> getCategoryAndContentListMap(){
        return categoryAndContentListMap;
}
    public static HashMap<String, String> getlocalTitleAndViewTitle(){
        return localTitleAndViewTitle;
    }

}
