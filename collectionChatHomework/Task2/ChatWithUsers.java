package Collections.homework.collectionChatHomework.Task2;

import java.util.List;

public class ChatWithUsers {
    private String chatName;
    private List users;

    public ChatWithUsers(String chatName, List users) {
        this.chatName = chatName;
        this.users = users;
    }

    public String getChatName() {
        return chatName;
    }

    public List getUsers() {
        return users;
    }
}
