package modificationConcurrent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FixConcurrentmodificationexception {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (String item : list) {
            if ("Two".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println("Modified list: " + list);
    }
}
