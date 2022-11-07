package MultiThreadingHomework;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConsumerWhite extends ConsumerCrystals implements Runnable{
    private final CrystalColorEnum crystalColorEnum;

    public ConsumerWhite(Queue<Crystal> crystalQueue, int capacity, int counter, AtomicBoolean finish, String name, CrystalColorEnum crystalColorEnum) {
        super(crystalQueue, capacity, counter, finish, name);
        this.crystalColorEnum = crystalColorEnum;
    }
}
