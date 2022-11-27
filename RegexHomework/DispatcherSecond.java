package RegexHomework;

import java.io.File;
import java.util.List;
import java.util.Queue;

public class DispatcherSecond extends ProblemConsumer implements Runnable{

    public DispatcherSecond(Queue<Problem> problemQueue, List<Problem> problemList, File inputFile, String name) {
        super(problemQueue, problemList, inputFile, name);
    }

}
