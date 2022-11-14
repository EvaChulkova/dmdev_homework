package RegexHomework;

import java.io.File;
import java.util.List;
import java.util.Queue;

public class ProblemProducer implements Runnable{
    private final Queue<Problem> problemQueue;
    private final List<Problem> problemList;
    private File inputFile;

    public ProblemProducer(Queue<Problem> problemQueue, List<Problem> problemList, File inputFile) {
        this.problemQueue = problemQueue;
        this.problemList = problemList;
        this.inputFile = inputFile;
    }

    @Override
    public void run() {
        System.out.println("Заработал генератор обращений");
        while (problemQueue.size() != problemList.size()) {
            synchronized (problemQueue) {
                if (!(problemList.isEmpty())) {
                    for (Problem problem : problemList) {
                        problemQueue.offer(problem);
                    }
                    try {
                        problemQueue.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("Генератор обращений остановлен - необработанных обращений не осталось :)");
    }

    @Override
    public String toString() {
        return "ProblemProducer{" +
                "problemQueue=" + problemQueue +
                ", problemList=" + problemList +
                ", inputFile=" + inputFile +
                '}';
    }

    public Queue<Problem> getProblemQueue() {
        return problemQueue;
    }

    public List<Problem> getProblemList() {
        return problemList;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }
}
