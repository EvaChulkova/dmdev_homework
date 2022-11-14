package RegexHomework;

public class ProblemParser {
    public static Problem parserProblem(String line) {
        String[] strings = line.split(",");
        return new Problem(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3], strings[4]);
    }
}
