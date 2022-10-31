package InputOutputStream.HomeworkIOStream;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class CSVRunner {
    public static void main(String[] args) {
        File itemPriceCSV = Path.of("InputOutputStream", "HomeworkIOStream", "AllCSVFiles", "items-price.csv").toFile();
        File itemNameCSV = Path.of("InputOutputStream", "HomeworkIOStream", "AllCSVFiles", "items-name.csv").toFile();
        File resultCSV = Path.of("InputOutputStream", "HomeworkIOStream", "AllCSVFiles", "result.csv").toFile();


        ReadPricesFromCSV readPricesFromCSV = new ReadPricesFromCSV();
        Map<Integer, Price> prices = readPricesFromCSV.readPricesFromCSV(itemPriceCSV);
        System.out.println(prices);


        ReadItemsFromCSV readItemsFromCSV = new ReadItemsFromCSV();
        Map<Integer, Item> items = readItemsFromCSV.readItemsFromCSV(itemNameCSV);
        System.out.println(items);


        GenerateListWithFullInformation genList = new GenerateListWithFullInformation();
        List<ItemFullInfo> fullInfo = genList.generateListWithItemsAndPrices(prices, items);
        System.out.println(fullInfo);


        WriteItemFullInfoToCSV writeFullInfoToCSV = new WriteItemFullInfoToCSV();
        writeFullInfoToCSV.writeItemFullInfoToCSV(resultCSV, fullInfo);

    }
}
