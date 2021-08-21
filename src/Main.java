import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        run(scanner, stack);
    }

    private static void run(Scanner scanner, Stack<Character> stack) {
        System.out.println("----------------------");
        System.out.println("Nhập vào biểu thức : ");
        String expression = scanner.nextLine();
        boolean check = checkBracket(stack, expression);
        if (check) {
            System.out.println("Biểu thức OK");
        } else {
            System.out.println("Biểu thức không OK");
        }
        run(scanner, stack);
    }

    private static boolean checkBracket(Stack<Character> stack, String expression) {
        if (expression.length() <= 3) {
            return false;
        } else {
            for (int i = 0; i < expression.length(); i++) {
                char left = '(';
                char right = ')';
                char c = expression.charAt(i);
                if (c == left) {
                    stack.push(c);
                } else if (c == right) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}