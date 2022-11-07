package InputOutputStream.HomeworkIOStream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ReadItemsFromCSV {
    File ErrorsItemCSV = Path.of("InputOutputStream", "HomeworkIOStream", "AllCSVFiles", "ErrorsItem.csv").toFile();

    public  Map<Integer, Item> readItemsFromCSV (File file) {
        Map<Integer, Item> namesMap = new HashMap<>();
        try (CSVParser namesParser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT)) {
            try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(ErrorsItemCSV), CSVFormat.DEFAULT)) {
                for (CSVRecord record : namesParser) {
                    if ((record.get(0)).equals("")) {
                        csvPrinter.printRecord(record.get(0));
                        System.err.println("You have empty ID fields!! Check: " + ErrorsItemCSV.getName());
                    } else {
                        namesMap.put(Integer.parseInt(record.get(0)), new Item(Integer.parseInt(record.get(0)), record.get(1), record.get(2)));
                    }
                }

            } catch (FileNotFoundException fileNotFoundException) {
                throw new RuntimeException(fileNotFoundException);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return namesMap;
    }
}
