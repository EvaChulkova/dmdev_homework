package InputOutputStream.HomeworkIOStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateListWithFullInformation {

    public List<ItemFullInfo> generateListWithItemsAndPrices(Map<Integer, Price> prices, Map<Integer, Item> items) {
        List<ItemFullInfo> itemsFullInfo = new ArrayList<>();
        for (Item item : items.values()) {
            Price price = prices.get(item.getId());
            if (price != null) {
                itemsFullInfo.add(new ItemFullInfo(item.getId(), item.getName(), price.getPrice()));
            }
        }
        return itemsFullInfo;
    }
}
