public class Lock2 implements Lock {
    volatile boolean[] wantsEnter = { false, false };

    @Override
    public void enter(int id) {
        wantsEnter[id] = true;
        while(wantsEnter[1 - id]);
    }

    @Override
    public void exit(int id) {
        wantsEnter[id] = false;
    }
}
