package OOP.homework.encapsulationHomeWork;

public class ATM {
    private int hundreds;
    private int fifties;
    private int twenties;

    private static final int HUNDREDS_AMOUNT = 300;
    private static final int FIFTIES_AMOUNT = 300;
    private static final int TWENTIES_AMOUNT = 300;

    private static final int NOMINAL_HUNDREDS = 100;
    private static final int NOMINAL_FIFTIES = 50;
    private static final int NOMINAL_TWENTIES = 20;

    public static final String HUNDREDS = "hundreds";
    public static final String FIFTIES = "fifties";
    public static final String TWENTIES = "twenties";

    public ATM(int hundreds, int fifties, int twenties) {
        this.hundreds = hundreds;
        this.fifties = fifties;
        this.twenties = twenties;
    }

    @Override
    public String toString() {
        return "hundreds: " + hundreds +
                ", fifties:  " + fifties +
                ", twenties: " + twenties;
    }

    public void addMoney(String banknoteType, int amount) {
        if (getHundreds() + amount < HUNDREDS_AMOUNT || getFifties() + amount < FIFTIES_AMOUNT || getTwenties() + amount < TWENTIES_AMOUNT) {
            switch (banknoteType) {
                case(HUNDREDS):
                    hundreds = getHundreds() + amount;
                    System.out.println("Внесено " + amount + " купюр номиналом 100");
                    break;
                case(FIFTIES):
                    fifties = getFifties() + amount;
                    System.out.println("Внесено " + amount + " купюр номиналом 50");
                    break;
                case(TWENTIES):
                    twenties = getTwenties() + amount;
                    System.out.println("Внесено " + amount + " купюр номиналом 20");
                    break;
            }
        } else {
            System.out.println("Невозможно внести купюры - превышен лимит хранилища в 300 купюр каждого номинала");
        }
    }

    public boolean getMoney(int sum) {
        int allMoneyInATM = getHundreds() * NOMINAL_HUNDREDS + getFifties() * NOMINAL_FIFTIES + getTwenties() * NOMINAL_TWENTIES;
        if (allMoneyInATM < sum) {
            System.out.println("В банкомате недостаточно средств для выдачи запрашиваемой суммы");
            return false;
        } else {
            if (sum % 10 != 0 || sum == 10 || sum == 30) {
                System.out.println("Запрашиваемая сумма не может быть выдана, выдаются купюры номиналом 100, 50 и 20");
                return false;
            } else {
                int amountHundreds = sum / NOMINAL_HUNDREDS;
                int balanceAfterOperationWithHundreds = sum - amountHundreds * NOMINAL_HUNDREDS;

                if (balanceAfterOperationWithHundreds > 0) {
                    if (balanceAfterOperationWithHundreds == 10 || balanceAfterOperationWithHundreds == 30) {
                        int amountHundredsToGet110Or130 = amountHundreds - 1;
                        balanceAfterOperationWithHundreds = sum - amountHundredsToGet110Or130 * NOMINAL_HUNDREDS;

                        int amountFiftiesToGet110Or130 = ((sum - amountHundredsToGet110Or130 * NOMINAL_HUNDREDS) / NOMINAL_FIFTIES) - 1;
                        int balanceAfterOperationWithFifties = balanceAfterOperationWithHundreds - amountFiftiesToGet110Or130 * NOMINAL_FIFTIES;

                        if (balanceAfterOperationWithFifties > 0) {
                            int amountTwenties = (sum - amountHundredsToGet110Or130 * NOMINAL_HUNDREDS - amountFiftiesToGet110Or130 * NOMINAL_FIFTIES) / NOMINAL_TWENTIES;
                            System.out.println("Выдано по 100: " + amountHundredsToGet110Or130 + ", выдано по 50: " + amountFiftiesToGet110Or130 + ", выдано по 20: " + amountTwenties);
                            return true;
                        } else {
                            System.out.println("Выдано по 100: " + amountHundredsToGet110Or130 + ", выдано по 50: " + amountFiftiesToGet110Or130);
                            return true;
                        }
                    }

                    else if (balanceAfterOperationWithHundreds == 50 || balanceAfterOperationWithHundreds == 70 || balanceAfterOperationWithHundreds == 90) {
                        int amountFifties = (sum - amountHundreds * NOMINAL_HUNDREDS) / NOMINAL_FIFTIES;
                        int balanceAfterOperationWithFifties = balanceAfterOperationWithHundreds - amountFifties * NOMINAL_FIFTIES;

                            if (balanceAfterOperationWithFifties > 0) {
                                int amountTwenties = (sum - amountHundreds * NOMINAL_HUNDREDS - amountFifties * NOMINAL_FIFTIES) / NOMINAL_TWENTIES;
                                System.out.println("Выдано по 100: " + amountHundreds + ", выдано по 50: " + amountFifties + ", выдано по 20: " + amountTwenties);
                                return true;
                            } else {
                                System.out.println("Выдано по 100: " + amountHundreds + ", выдано по 50: " + amountFifties);
                                return true;
                            }

                    }

                    else if (balanceAfterOperationWithHundreds == 20 || balanceAfterOperationWithHundreds == 40 || balanceAfterOperationWithHundreds == 60 || balanceAfterOperationWithHundreds == 80) {
                        int amountTwenties = (sum - amountHundreds * NOMINAL_HUNDREDS) / NOMINAL_TWENTIES;
                        System.out.println("Выдано по 100: " + amountHundreds + ", выдано по 20: " + amountTwenties);
                        return true;
                    }

                    else {
                        System.out.println("Невозможно выдать запрашиваемую сумму - используется номинал 100, 50 и 20");
                        return false;
                    }
                }
                else {
                    System.out.println("Выдано по 100: " + amountHundreds);
                    return true;
                }
            }
        }
    }

    public int getHundreds() {
        return hundreds;
    }
    public int getFifties() {
        return fifties;
    }
    public int getTwenties() {
        return twenties;
    }
}


