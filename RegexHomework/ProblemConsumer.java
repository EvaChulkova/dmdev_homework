package RegexHomework;

import java.io.File;
import java.util.List;
import java.util.Queue;

public class ProblemConsumer implements Runnable{
    //File result = Path.of("RegexHomework", "Variant2", "Result.txt").toFile();

    private final Queue<Problem> problemQueue;
    private final List<Problem> problemList;
    private File inputFile;
    private String name;

    public ProblemConsumer(Queue<Problem> problemQueue, List<Problem> problemList, File inputFile, String name) {
        this.problemQueue = problemQueue;
        this.problemList = problemList;
        this.inputFile = inputFile;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": Начал работу с обращениями");
        while (true) {
            synchronized (problemQueue) {
            if (!(problemQueue.isEmpty())) {
                    System.out.println(getName() + ": Обрабатываем обращение и записываем в файл");
                    UtilReaderWriter.writeResult(inputFile, problemList.get(0));
                    problemQueue.poll();
                    System.out.println(getName() + ": Обращение обработано - ответ предоставлен");
                    problemList.remove(0);
                try {
                    problemQueue.wait(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(getName() + ": Обращения в очереди отсутствуют :)");
                break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ProblemConsumer{" +
                "problemQueue=" + problemQueue +
                ", problemList=" + problemList +
                ", inputFile=" + inputFile +
                ", name='" + name + '\'' +
                '}';
    }

    public Queue<Problem> getProblemQueue() {
        return problemQueue;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public List<Problem> getProblemList() {
        return problemList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
