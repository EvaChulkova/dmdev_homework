package Collections.homework.collectionChatHomework.Task1.comparators;

import Collections.homework.collectionChatHomework.Task1.Chat;

import java.util.Comparator;

public class AmountOfUsersComparator implements Comparator<Chat> {
    @Override
    public int compare(Chat chat1, Chat chat2) {
        return Integer.compare(chat2.getAmountOfUsers(), chat1.getAmountOfUsers());
    }
}
