package modificationConcurrent;

import LogAnnotation.LogExecutionTime;
import java.util.Random;

public class Main {

    @LogExecutionTime("Processing method")
    public void process() {
        Random random = new Random();
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += random.nextInt(100);
        }
        System.out.println("Sum calculated: " + sum);
    }

    public static void main(String[] args) {
        Main example = new Main();
        example.process();
    }
}
