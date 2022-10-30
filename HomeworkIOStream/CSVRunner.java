package InputOutputStream.HomeworkIOStream;

/**/

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class CSVRunner {
    public static void main(String[] args) {
        File itemPriceCSVWithoutHeaders = Path.of("InputOutputStream", "HomeworkIOStream", "item-price_without_headers.csv").toFile();
        File itemNameCSVWithoutHeaders = Path.of("InputOutputStream", "HomeworkIOStream", "items-name_without_headers.csv").toFile();

        File resultCSV = Path.of("InputOutputStream", "HomeworkIOStream", "result.csv").toFile();
        File errorCSV = Path.of("InputOutputStream", "HomeworkIOStream", "errors.csv").toFile();


        Map<Integer, Price> pricesObject = new HashMap<>();
        try (CSVParser priceParser = new CSVParser(new FileReader(itemPriceCSVWithoutHeaders), CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : priceParser) {
                pricesObject.put(Integer.parseInt(csvRecord.get(0)), new Price(Integer.parseInt(csvRecord.get(0)), Double.parseDouble(csvRecord.get(1))));
            }
            System.out.println(pricesObject);

        } catch (IOException e) {
            e.printStackTrace();
        }


        Map<Integer, Item> namesObject = new HashMap<>();
        try (CSVParser namesParser = new CSVParser(new FileReader(itemNameCSVWithoutHeaders), CSVFormat.DEFAULT)) {
            for (CSVRecord record : namesParser) {
                namesObject.put(Integer.parseInt(record.get(0)), new Item(Integer.parseInt(record.get(0)), record.get(1), record.get(2)));
            }
            System.out.println(namesObject);

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<ItemFullInfo> itemsFullInfo = new ArrayList<>();
        for (Item item : namesObject.values()) {
            Price price = pricesObject.get(item.getId());
            if (price != null) {
                itemsFullInfo.add(new ItemFullInfo(item.getId(), item.getName(), price.getPrice()));
            }
        }
        System.out.println(itemsFullInfo);


        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(resultCSV), CSVFormat.DEFAULT)) {
            for (ItemFullInfo itemFullInfo : itemsFullInfo) {
                csvPrinter.printRecord(itemFullInfo.getId(), itemFullInfo.getName(), itemFullInfo.getPrice());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
