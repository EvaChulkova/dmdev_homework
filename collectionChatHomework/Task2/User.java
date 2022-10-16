package Collections.homework.collectionChatHomework.Task2;

public class User {
    private int id;
    private String username;
    private int age;

    public User(int id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User: {" + " id: " + id + ", username: " + username + ", age: " + age + " }" + "\n";
    }

}
