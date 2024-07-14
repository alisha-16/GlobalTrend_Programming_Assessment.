package trie;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    // Search if the word is in the trie
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndOfWord;
    }

    // Check if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }

    // Helper method to search a node in the trie
    private TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return null;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of words to insert: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.println("Enter the words to insert:");
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            trie.insert(word);
        }

        System.out.print("Enter a word to search: ");
        String searchWord = scanner.nextLine();
        boolean isFound = trie.search(searchWord);
        if (isFound) {
            System.out.println("Word '" + searchWord + "' is found in the trie.");
        } else {
            System.out.println("Word '" + searchWord + "' is not found in the trie.");
        }

        System.out.print("Enter a prefix to check: ");
        String prefix = scanner.nextLine();
        boolean startsWithPrefix = trie.startsWith(prefix);
        if (startsWithPrefix) {
            System.out.println("There is at least one word in the trie that starts with prefix '" + prefix + "'.");
        } else {
            System.out.println("No word in the trie starts with prefix '" + prefix + "'.");
        }

        scanner.close();
    }
}
