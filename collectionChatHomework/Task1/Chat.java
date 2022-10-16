package Collections.homework.collectionChatHomework.Task1;

public class Chat implements Comparable<Chat>{
    private String name;
    private int amountOfUsers;

    public Chat(String name, int amountOfUsers) {
        this.name = name;
        this.amountOfUsers = amountOfUsers;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfUsers() {
        return amountOfUsers;
    }

    public String toString() {
        return "Info about chat: " + "{ Chat name: " + name + ", amount of users: " + amountOfUsers + "}";
    }


    @Override
    public int compareTo(Chat chat) {
        return this.amountOfUsers - chat.amountOfUsers;
    }
}
