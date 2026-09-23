package primjer04;

public class Cylinder implements Runnable {
    float height;
    float radius;
    volatile float result;

    public Cylinder(float height, float radius) {
        this.height = height;
        this.radius = radius;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch(Exception e) {
            e.printStackTrace();
        }

        result = (float)(height * radius * radius * Math.PI);
    }
}
