package Collections.homework.collectionChatHomework.Task2;

/*
* Задание 2
Дан список чатов с предыдущего задания, только вместо поля “количество пользователей” будет список объектов
типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
Задача:
- Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
- С помощью итератора посчитать средний возраст всех оставшихся пользователей.
* */

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ChatRunnerTask2 {
    public static void main(String[] args) {
        List<User> usersListForPrivate = new ArrayList<>(List.of(
                new User(13, "ivan", 21),
                new User(2, "nik17", 17)
        ));

        List<User> usersListForYouTube = new ArrayList<>(List.of(
                new User(31, "coolUserName", 16),
                new User(14, "oxana", 34)
        ));

        List<User> usersListForFriends = new ArrayList<>(List.of(
                new User(5, "alex", 30),
                new User(16, "jane", 15)
        ));

        List<User> usersListForVK = new ArrayList<>(List.of(
                new User(17, "batman376", 39),
                new User(81, "nik17", 14)
        ));

        List<User> usersListForTelegram = new ArrayList<>(List.of(
                new User(54, "lev", 60),
                new User(7, "john", 24)
        ));


        List<ChatWithUsers> chatListWithUsers = new ArrayList<>(List.of(
                new ChatWithUsers("Private", usersListForPrivate),
                new ChatWithUsers("YouTubeUsers", usersListForYouTube),
                new ChatWithUsers("Friends", usersListForFriends),
                new ChatWithUsers("VKUsers", usersListForVK),
                new ChatWithUsers("TelegramUsers", usersListForTelegram)
        ));

        List<User> usersOlder18 = makeUsersListOlder18(chatListWithUsers);
        System.out.println(usersOlder18);

        double averageAgeOfUsers = findAverageAge(usersOlder18);
        System.out.println("Средний возраст пользователей (пользователи старше 18): " + averageAgeOfUsers);
    }

    private static List<User> makeUsersListOlder18(List<ChatWithUsers> chatListWithUsers) {
        ListIterator<ChatWithUsers> chatWithUsersListIterator = chatListWithUsers.listIterator();
        List<User> listWithUsers = new ArrayList<>();
        while(chatWithUsersListIterator.hasNext()) {
            List<User> firstVersion =  chatWithUsersListIterator.next().getUsers();
            listWithUsers.addAll(firstVersion);
        }

        ListIterator<User> listWithUsersIterator = listWithUsers.listIterator();
        while (listWithUsersIterator.hasNext()) {
            if(listWithUsersIterator.next().getAge() < 18) {
                listWithUsersIterator.remove();
            }
        }
        return listWithUsers;
    }

    /*
    private static List<User> getUsersListOlder18(List<ChatWithUsers> chatListWithUsers) {
        //List<User> list = new ArrayList<>();

        ListIterator<ChatWithUsers> chatWithUsersListIterator = chatListWithUsers.listIterator();
        ArrayList<User> listWithUsers = new ArrayList<>();
        while(chatWithUsersListIterator.hasNext()) {
            List firstVersion =  chatWithUsersListIterator.next().getUsers();
            listWithUsers.addAll(firstVersion);
        }

        for (User user : listWithUsers) {
            if(user.getAge() < 18) {
                listWithUsers.trimToSize();
            }
        }
        return listWithUsers;
    }
     */

    public static double findAverageAge(List<User> list) {
        double averageAge = 0;
        ListIterator<User> averageAgeList = list.listIterator();
        while (averageAgeList.hasNext()){
            averageAge = averageAge + averageAgeList.next().getAge();
        }
        return averageAge/list.size();
    }
}
