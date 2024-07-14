package LRU;

public class LRU {
  public static void main(String[] args) {
    LRUclass lruCache = new LRUclass(3);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    lruCache.put(3, 3);
    System.out.println("Result: " + lruCache.get(1));
    System.out.println("Result: " + lruCache.get(2));
    lruCache.put(5, 5);
    System.out.println("Result: " + lruCache.get(3));
    System.out.println("Result: " + lruCache.get(4));
    System.out.println("Result: " + lruCache.get(5));

  }

}
