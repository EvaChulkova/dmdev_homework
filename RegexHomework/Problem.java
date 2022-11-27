package RegexHomework;
/**
 * - Порядковый номер клиента
 * - Дата и время звонка в ISO формате
 * - Фамилия и Имя клиента
 * - Телефон клиента
 * - Текст жалобы
 * */

public class Problem {
    private int id;
    private String dateTime;
    private String fullName;
    private String phoneNumber;
    private String issue;

    public Problem() {}

    public Problem(int id, String dateTime, String fullName, String phoneNumber, String issue) {
        this.id = id;
        this.dateTime = dateTime;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.issue = issue;
    }


    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", dateTime='" + dateTime + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", issue='" + issue + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
