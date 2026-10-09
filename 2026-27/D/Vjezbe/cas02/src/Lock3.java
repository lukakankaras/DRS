public class Lock3 implements Lock {
    volatile int turn;

    @Override
    public void enter(int id) {
        while(turn == 1 - id);
    }

    @Override
    public void exit(int id) {
        turn = 1 - id;
    }
}
