package InputOutputStream.HomeworkIOStream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteItemFullInfoToCSV {
    public void writeItemFullInfoToCSV(File resultCSV, List<ItemFullInfo> itemsFullInfo) {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(resultCSV), CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("ID", "NAME", "PRICE");
            for (ItemFullInfo itemFullInfo : itemsFullInfo) {
                csvPrinter.printRecord(itemFullInfo.getId(), itemFullInfo.getName(), itemFullInfo.getPrice());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
