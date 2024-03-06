import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TILHandlerController {

    public static void main(String[] args) throws IOException {
        String path = "/Users/seonghunjeong/til";
        //String path = "./"; ㅅ이거 쓰면된다.
        File folder = FolderExplorer.getFiles(path);

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
                GitAutoCommit.executeCommand(path, "git", "commit", "-m", "Automated commit");

                // Git push
                GitAutoCommit.executeCommand(path, "git", "push");
                System.out.println("push 성공");
                System.out.println("아무키나 누르면 프로그램이 끝납니다. 화이팅!");
                scanner.nextLine();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }else {

        }


    }

}
