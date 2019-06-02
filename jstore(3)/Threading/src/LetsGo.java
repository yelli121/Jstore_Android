import java.util.Random;

public class LetsGo {
    public static int random(int min, int max){
        Random rand = new Random();

        return rand.nextInt((max-min)+1)+min;
    }
    public static void main(String[] args){
        RunForYourLife R1 = new RunForYourLife("Lionel", random(368,500));
        R1.start();

        RunForYourLife R2 = new RunForYourLife("Andres", random(234,367));
        R2.start();

        RunForYourLife R3 = new RunForYourLife("Messi", random(100,233));
        R3.start();
    }
}
