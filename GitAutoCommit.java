import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GitAutoCommit {

    public static void executeCommand(String workingDir, String... command) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(new File(workingDir));
        Process process = processBuilder.start();

        // 프로세스의 출력을 콘솔에 출력
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // 프로세스가 종료될 때까지 대기
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            // 프로세스가 오류 코드로 종료된 경우 예외 던지기
            throw new RuntimeException("Command execution failed with error code: " + exitCode);
        }
    }

}
