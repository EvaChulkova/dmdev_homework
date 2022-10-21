package Collections.homework.collectionChatHomework.Task1.comparators;

import Collections.homework.collectionChatHomework.Task1.Chat;

import java.util.Comparator;

public class ChatSortDefault implements Comparator<Chat> {

    @Override
    public int compare(Chat chat1, Chat chat2) {
        return chat1.getName().compareTo(chat2.getName());
    }
}
