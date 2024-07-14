package modificationConcurrent;

import java.util.ArrayList;
import java.util.Iterator;;

public class Concurrentmodificationexception {
    public static void main(String args[]) {
        ArrayList<String> arr = new ArrayList<String>();

        arr.add("One");
        arr.add("Two");
        arr.add("Three");

        Iterator<String> iter = arr.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
            arr.add("Two");
        }

    }
}
