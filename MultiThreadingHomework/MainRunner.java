package MultiThreadingHomework;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainRunner {
    public static void main(String[] args) {
        Queue<Crystal> crystalQueue = new LinkedBlockingQueue<>();
        AtomicBoolean isNotFull = new AtomicBoolean(true);

        Thread producerCrystals = new Thread(new CrystalProducer(crystalQueue, 500, 0, isNotFull));
        Thread consumerRed = new Thread(new ConsumerRed(crystalQueue, 100, 0, isNotFull, "Fire", CrystalColorEnum.RED));
        Thread consumerWhite = new Thread(new ConsumerWhite(crystalQueue, 100, 0, isNotFull, "Air", CrystalColorEnum.WHITE));

        consumerRed.start();
        consumerWhite.start();
        producerCrystals.start();
    }
}
