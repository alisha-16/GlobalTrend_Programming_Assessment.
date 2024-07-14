package validparentheses;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string of parentheses: ");
        String s = scanner.nextLine();

        boolean isValid = isValidParentheses(s);

        if (isValid) {
            System.out.println("The string of parentheses is valid.");
        } else {
            System.out.println("The string of parentheses is not valid.");
        }
    }

    public static boolean isValidParentheses(String s) {
        // Mapping of opening brackets to their corresponding closing brackets
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put('(', ')');
        bracketMap.put('{', '}');
        bracketMap.put('[', ']');

        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse through each character in the string
        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                // If the character is an opening bracket, push it onto the stack
                stack.push(c);
            } else if (bracketMap.containsValue(c)) {
                // If the character is a closing bracket
                if (stack.isEmpty() || bracketMap.get(stack.pop()) != c) {
                    // If stack is empty or the top of stack does not match current closing bracket
                    return false;
                }
            }
        }

        // After iterating through all characters, stack should be empty for valid
        // string
        return stack.isEmpty();
    }
}
