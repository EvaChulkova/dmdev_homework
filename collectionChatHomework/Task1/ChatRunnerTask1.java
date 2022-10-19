package Collections.homework.collectionChatHomework.Task1;

/*
* Задание 1
Дан список чатов.
Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
Задача:
- Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
- Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
   а если это количество совпадает, то по названию в алфавитном порядке.
- Также предоставить сортировку чатов по названию по умолчанию.
*
*
*/

import Collections.homework.collectionChatHomework.Task1.comparators.AmountOfUsersComparator;
import Collections.homework.collectionChatHomework.Task1.comparators.ChatNameComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class ChatRunnerTask1 {
    public static void main(String[] args) {
        List<Chat> chatList = new ArrayList<>(List.of(
                new Chat("Private", 2),
                new Chat("YouTubeUsers", 3207),
                new Chat("Friends", 34),
                new Chat("VKUsers", 1569),
                new Chat("TelegramUsers", 5217)
        ));

        System.out.println(chatList);

        Collections.sort(chatList);
        System.out.println("Сортировка (default): ");
        System.out.println(chatList);

        deleteVoidChatLessThanThousandUsers(chatList);
        System.out.println(chatList);

        chatList.sort(new AmountOfUsersComparator().thenComparing(new ChatNameComparator()));
        System.out.println("Чаты по убыванию количества пользователей (если количества пользователей равны, то в алфавитном порядке по названию):");
        System.out.println(chatList);
    }


    public static void deleteVoidChatLessThanThousandUsers(List<Chat> list) {
        ListIterator<Chat> iterator = list.listIterator();
        while(iterator.hasNext()) {
            int currentValue = iterator.next().getAmountOfUsers();
            if(currentValue < 1000) {
                iterator.remove();
            }
        }
    }
}
