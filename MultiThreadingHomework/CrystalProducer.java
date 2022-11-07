package MultiThreadingHomework;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

public class CrystalProducer implements Runnable{

    private final Queue<Crystal> crystalQueue;
    private final int maxAmountOfCrystals;
    private int counter = 0;
    private final AtomicBoolean finish;

    public CrystalProducer(Queue<Crystal> crystalQueue, int maxAmountOfCrystals, int counter, AtomicBoolean finish) {
        this.crystalQueue = crystalQueue;
        this.maxAmountOfCrystals = maxAmountOfCrystals;
        this.counter = counter;
        this.finish = finish;
    }

    @Override
    public void run() {
        System.out.println("Crystal producer: start creating crystals");
        while (counter < maxAmountOfCrystals && finish.get()) {
            synchronized (crystalQueue) {
                int totalCount = ThreadLocalRandom.current().nextInt(2, 5);
                int redCrystalsCount = ThreadLocalRandom.current().nextInt(0, totalCount);

                for (int i = 0; i < redCrystalsCount; i++) {
                    crystalQueue.offer(new Crystal(CrystalColorEnum.RED));
                    counter++;
                }

                for (int i = 0; i < totalCount - redCrystalsCount; i++) {
                    crystalQueue.offer(new Crystal(CrystalColorEnum.WHITE));
                    counter++;
                }
                System.out.println("Crystal producer: create " + redCrystalsCount + " red and " + (totalCount - redCrystalsCount) + " white crystals");

                try {
                    crystalQueue.wait(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Crystal producer: finish creating crystals");
    }
}
