package Collections.homework.collectionChatHomework.Task2;

public class User {
    private int id;
    private String nickName;
    private int age;

    public User(int id, String nickName, int age) {
        this.id = id;
        this.nickName = nickName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return nickName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User: {" + " id: " + id + ", username: " + nickName + ", age: " + age + " }" + "\n";
    }

}
