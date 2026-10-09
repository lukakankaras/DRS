public class Lock1 implements Lock {
    volatile boolean unlocked = true;

    @Override
    public void enter(int id) { // enter
        while(!unlocked); // pokusamo da udjemo, ali cekamo dok neko ne otkljuca

        unlocked = false; // cim smo uspijeli, zakljucamo za sobom
    }

    @Override
    public void exit(int id) { // exit
        unlocked = true;
    }
}
