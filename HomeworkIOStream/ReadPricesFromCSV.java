package InputOutputStream.HomeworkIOStream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ReadPricesFromCSV {
    File ErrorsPricesCSV = Path.of("InputOutputStream", "HomeworkIOStream", "AllCSVFiles", "ErrorsPrices.csv").toFile();

    public Map<Integer, Price> readPricesFromCSV(File file) {
        Map<Integer, Price> pricesMap = new HashMap<>();
        try (CSVParser priceParser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT)) {
            try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(ErrorsPricesCSV), CSVFormat.DEFAULT)) {
                for (CSVRecord csvRecord : priceParser) {
                    if ((csvRecord.get(0)).equals("")) {
                        csvPrinter.printRecord(csvRecord.get(0));
                        System.err.println("You have empty ID fields!! Check: " + ErrorsPricesCSV.getName());
                    }
                    else {
                        pricesMap.put(Integer.parseInt(csvRecord.get(0)), new Price(Integer.parseInt(csvRecord.get(0)), Double.parseDouble(csvRecord.get(1))));
                    }
                }

            } catch (FileNotFoundException fileNotFoundException) {
                throw new RuntimeException(fileNotFoundException);
            }  catch (IOException e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pricesMap;
    }
}
