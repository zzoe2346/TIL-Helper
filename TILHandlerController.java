import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class TILHandlerController {

    public static void main(String[] args) throws IOException {
        //경로
        //String path = "./";
        String path = "/Users/seonghunjeong/til";
        //파일(깃 저장소) 객체 생성
        File folder = FolderExplorer.getFiles(path);
        //깃 저장소 내 카테고리명, 문서명 추출
        FolderExplorer.extractTitles(folder);

        ReadmeWriter.write(path,FolderExplorer.getCategoryAndContentListMap(), FolderExplorer.getlocalTitleAndViewTitle());

        // Git add, commit, push 수행
        Scanner scanner = new Scanner(System.in);
        System.out.println("Auto Git Push 할거임?");
        System.out.println("할거면 '1' 안할거면 '0'");

        int answer = Integer.parseInt(scanner.nextLine());
        if(answer==1){
            try {
                // Git add
                GitAutoCommit.executeCommand(path, "git", "add", ".");

                // Git commit
                // 현재 날짜 얻기
                LocalDate currentDate = LocalDate.now();

                // 년, 월, 일 얻기
                int year = currentDate.getYear();
                int month = currentDate.getMonthValue();
                int day = currentDate.getDayOfMonth();

                String commitMessage = year+"-"+month+"-"+day+"(Automated commit)";
                GitAutoCommit.executeCommand(path, "git", "commit", "-m", commitMessage);

                // Git push
                GitAutoCommit.executeCommand(path, "git", "push");
                System.out.println("성공했습니다. 화이팅!");
                scanner.nextLine();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }else {

        }


    }

}
