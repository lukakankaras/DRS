import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*
    Greska sa vjezbi je bila ta da je uslov u stvari
    numbers[id].get() > numbers[i].get()
    a ne
    numbers[id].get() < numbers[i].get()

    Ideja nije da se svi trkaju za najveci broj pa ko ima najveci da ide prvi,
    vec kao u banci kada ceka se red, svi dobijaju redni broj i prvi je onaj sa
    najmanjim brojem. A kada se udje u red gleda se broj svih ostalih i doda se +1
    (tako se dobija redni broj svakog threada koji ulazi u red cekanja)

 */
public class LamportLock implements Lock {
    final int n;
    AtomicBoolean[] choosing;
    AtomicInteger[] numbers;

    public LamportLock(int n) {
        this.n = n;
        choosing = new AtomicBoolean[n];
        numbers = new AtomicInteger[n];

        for(int i = 0; i < n; i++) {
            choosing[i] = new AtomicBoolean(false);
            numbers[i] = new AtomicInteger(0);
        }
    }

    @Override
    public void enter(int id) {
        choosing[id].set(true);
        for(int i = 0; i < n; i++) {
            if(numbers[i].get() > numbers[id].get()) {
                numbers[id].set(numbers[i].get());
            }
        }
        numbers[id].set(numbers[id].get() + 1);
        choosing[id].set(false);

        for(int i = 0; i < n; i++) {
            while(choosing[i].get());
            while(
                    numbers[i].get() != 0 &&
                            (numbers[id].get() > numbers[i].get() ||
                                    (numbers[id].get() == numbers[i].get() && id < i))
            );
        }
    }

    @Override
    public void exit(int id) {
        numbers[id].set(0);
    }
}
