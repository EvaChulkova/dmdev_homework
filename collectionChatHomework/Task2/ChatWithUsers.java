package Collections.homework.collectionChatHomework.Task2;

import java.util.List;

public class ChatWithUsers {
    private String chatname;
    List<User> list;

    public ChatWithUsers(String chatname, List<User> list) {
        this.chatname = chatname;
        this.list = list;
    }

    public String getChatname() {
        return chatname;
    }

    public List<User> getList() {
        return list;
    }
}
