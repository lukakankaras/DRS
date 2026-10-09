import java.util.concurrent.atomic.AtomicBoolean;

public class PetersonLock implements Lock {
    AtomicBoolean[] wantsCS;
    volatile int turn = 0;

    public PetersonLock() {
        wantsCS = new AtomicBoolean[2];
        wantsCS[0] = new AtomicBoolean(false);
        wantsCS[1] = new AtomicBoolean(false);
    }

    @Override
    public void enter(int id) {
        int otherId = 1 - id;
        wantsCS[id].set(true);
        turn = otherId;
        while(wantsCS[otherId].get() && turn == otherId);
    }

    @Override
    public void exit(int id) {
        wantsCS[id].set(false);
    }
}
