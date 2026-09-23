package primjer04;

public class Main {
    public static void main(String[] args) {
        Cylinder c = new Cylinder(10, 20);
        Thread t = new Thread(c);

        t.start();

        for(int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        try {
            t.join();
            System.out.println("Resultat je " + c.result);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
