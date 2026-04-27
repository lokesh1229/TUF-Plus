import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AutoCommitPush {

    public static void runCommand(String command) {
        try {
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide commit message");

        // if (args.length == 0) {
        //     System.out.println("Please provide commit message");
        //     return;
        // }

        String message = sc.nextLine();

        runCommand("git init");
        runCommand("git add .");
        runCommand("git commit -m \"" + message + "\"");
        runCommand("git push origin main");

        System.out.println("Code committed and pushed successfully!");
        sc.close();
    }
}