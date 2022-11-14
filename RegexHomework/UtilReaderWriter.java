package RegexHomework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilReaderWriter {
    public static List<Problem> readProblems (File path) {
        List<Problem> problemList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Problem parsedProblem = ProblemParser.parserProblem(line);
                problemList.add(parsedProblem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return problemList;
    }

    public static List<Result> writeResult(File path, Problem problem) {
        List<Result> resultList = new ArrayList<>();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            Result result = new Result(problem.getId(), problem.getDateTime(), problem.getPhoneNumber());
            String line = result.toString();
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }





}
