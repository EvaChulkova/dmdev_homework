package RegexHomework;

/**
 * - Порядковый номер клиента с предыдущего лог файла
 * - Дата и время созвона
 * - Номер телефона клиента
 * */

public class Result {
    private int id;
    private String localDateTime;
    private String phoneNumber;

    public Result() {}

    public Result(int id, String localDateTime, String phoneNumber) {
        this.id = id;
        this.localDateTime = localDateTime;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", localDateTime='" + localDateTime + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
