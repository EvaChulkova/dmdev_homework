package MultiThreadingHomework;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConsumerCrystals implements Runnable{
    private final Queue<Crystal> crystalQueue;
    private final int capacity;
    private int counter = 0;
    private final AtomicBoolean finish;
    private String name;

    public ConsumerCrystals(Queue<Crystal> crystalQueue, int capacity, int counter, AtomicBoolean finish, String name) {
        this.crystalQueue = crystalQueue;
        this.capacity = capacity;
        this.counter = counter;
        this.finish = finish;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Crystals consumer: start collecting crystals.");
        while (counter < capacity && finish.get()) {
            synchronized (crystalQueue) {
                if (!(crystalQueue.isEmpty())) {
                    Crystal crystal = crystalQueue.poll();
                    switch (crystal.getCrystalColorEnum()) {
                        case RED -> {
                            crystalQueue.poll();
                            counter++;
                            System.out.println(getName() + " crystal consumer: found red crystal: " + counter);
                        }
                        case WHITE -> {
                            crystalQueue.poll();
                            counter++;
                            System.out.println(getName() + " crystal consumer: found white crystal: " + counter);
                        }
                    }
                }
                try {
                    crystalQueue.wait(700);
                    if (counter >= capacity) {
                        finish.getAndSet(false);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /*try {
                Thread.sleep(100);
                if (counter >= capacity) {
                    finish.getAndSet(false);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("Crystal consumer: full.");

    }

    public String getName() {
        return name;
    }
}
