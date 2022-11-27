package RegexHomework;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class HelperRunner {
    public static void main(String[] args) {
        File issues = Path.of("RegexHomework", "Issues.txt").toFile();
        File result = Path.of("RegexHomework", "Result.txt").toFile();

        List<Problem> problemList = UtilReaderWriter.readProblems(issues);
        Queue<Problem> problemQueue = new LinkedBlockingQueue<>();

        Thread problemProducer = new Thread(new ProblemProducer(problemQueue, problemList, issues));
        Thread dispatcher1 = new Thread(new DispatcherFirst(problemQueue, problemList, result, "Disp_1"));
        Thread dispatcher2 = new Thread(new DispatcherSecond(problemQueue, problemList, result, "Disp_2"));


        problemProducer.start();
        dispatcher1.start();
        dispatcher2.start();




    }
}
