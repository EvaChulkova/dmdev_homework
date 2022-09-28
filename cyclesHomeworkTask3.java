package cycles;

/*
* Задание 3
Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
300$ в месяц Ваня тратит на еду и развлечения.
10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.

Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.

Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
* */

public class cyclesHomeworkTask3 {
    public static void main(String[] args) {

        double zp = 600;
        double forFood = 300;
        double monthOfHigh = 7;
        double allMoney = 0;
        double howOnBroker = 0;


        for (int i = 1; i < 39; i++) {
            if (i == monthOfHigh) {
                zp = zp + 400;
                monthOfHigh = monthOfHigh + 6;
            }
            //System.out.println("Зарплата в " + i + " месяце($): " + zp);

            double moneyToBroker = (double) zp * 0.1;
            howOnBroker = howOnBroker + howOnBroker * 0.02 + moneyToBroker;
            //System.out.println("В " + i + " месяце на счету у брокера: " + howOnBroker);

            double zpAfterAll = zp - moneyToBroker - forFood;

            allMoney = allMoney + zpAfterAll;
            //System.out.println("В " + i + " месяце на счету: " + allMoney);
        }

        System.out.println("Всего на счету($): " + allMoney);
        System.out.println("Всего на брокерском счету($): " + howOnBroker);
    }




}
