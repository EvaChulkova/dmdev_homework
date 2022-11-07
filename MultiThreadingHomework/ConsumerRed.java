package MultiThreadingHomework;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConsumerRed extends ConsumerCrystals implements Runnable {

    private final CrystalColorEnum crystalColorEnum;

    public ConsumerRed(Queue<Crystal> crystalQueue, int capacity, int counter, AtomicBoolean finish, String name, CrystalColorEnum crystalColorEnum) {
        super(crystalQueue, capacity, counter, finish, name);
        this.crystalColorEnum = crystalColorEnum;
    }



}
