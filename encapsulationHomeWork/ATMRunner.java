package OOP.homework.encapsulationHomeWork;

public class ATMRunner {
    public static void main(String[] args) {
        ATM atm = new ATM(115, 70, 154);
        atm.addMoney("hundreds", 15);
        System.out.println(atm.getMoney(130));
    }
}
