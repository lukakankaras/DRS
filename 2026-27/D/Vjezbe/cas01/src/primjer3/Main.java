package primjer3;

public class Main {
    public static void main(String[] args) {
        Printer p = new Printer();
        Thread thread = new Thread(p);
        thread.start();

        try {
            Thread.sleep(5000); // Spavaj 5 sekundi
            p.prekini = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
