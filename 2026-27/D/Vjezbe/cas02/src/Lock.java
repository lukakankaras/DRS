public interface Lock {
    void enter(int id);
    void exit(int id);
}
