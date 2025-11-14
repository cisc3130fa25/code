package quizzes;

import J_stack_queue_deque.A_stack.ArrayStack3130;
import J_stack_queue_deque.A_stack.Stack3130;
import J_stack_queue_deque.B_queue.Queue3130;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;

// solutions to the questions on stacks and queues in HW 10

class StackQuestion1 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        // or: Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isOpening(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char opening = stack.pop();

                if (!matches(opening, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // parallel lists
    private static final List<Character> OPENINGS = List.of('(', '[', '{');
    private static final List<Character> CLOSINGS = List.of(')', ']', '}');

    private static boolean isOpening(char ch) {
        return OPENINGS.contains(ch);
    }

    private static boolean matches(char opening, char closing) {
        return OPENINGS.indexOf(opening) == CLOSINGS.indexOf(closing);
    }
}

class StackQuestion2 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        // or: Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop(), a = stack.pop();
                stack.push(apply(token, a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static final List<String> OPERATORS = List.of("+", "-", "*", "/");

    private static boolean isOperator(String s) {
        return OPERATORS.contains(s);
    }

    private static int apply(String operator, int a, int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default  -> throw new RuntimeException();
        };
    }
}

class StackQuestion3 {
    public static <E> boolean contains(Stack3130<E> stack, Object o) {
        Stack3130<E> aux = new ArrayStack3130<>(); // or LinkedStack3130
        boolean found = false;

        while (!stack.isEmpty() && !found) {
            E element = stack.pop();
            aux.push(element);

            if (Objects.equals(element, o)) {
                found = true;
            }
        }

        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }

        return found;
    }
}

class StackQuestion4 {
    public static <E> boolean equals(Stack3130<E> stack1, Stack3130<E> stack2) {
        Stack3130<E> aux = new ArrayStack3130<>(); // or LinkedStack3130
        boolean foundMismatch = false;

        while (!stack1.isEmpty() && !stack2.isEmpty() && !foundMismatch) {
            E element1 = stack1.pop();
            E element2 = stack2.pop();

            if (!Objects.equals(element1, element2)) {
                foundMismatch = true;
            }

            aux.push(element1);
            aux.push(element2);
        }

        boolean haveSameSize = stack1.isEmpty() && stack2.isEmpty();

        while (!aux.isEmpty()) {
            stack2.push(aux.pop());
            stack1.push(aux.pop());
        }

        return haveSameSize && !foundMismatch;
    }
}

class QueueQuestion1 {
    public static <E> boolean contains(Queue3130<E> queue, Object item) {
        boolean found = false;

        for (int i = 0; i < queue.size(); i++) {
            E element = queue.dequeue();

            if (Objects.equals(element, item)) {
                found = true;
            }

            queue.enqueue(element);
        }

        return found;
    }
}

class QueueQuestion2 {
    public static <E> boolean equals(Queue3130<E> queue1, Queue3130<E> queue2) {
        if (queue1.size() != queue2.size()) {
            return false;
        }

        boolean foundMismatch = false;

        for (int i = 0; i < queue1.size(); i++) {
            E element1 = queue1.dequeue();
            E element2 = queue2.dequeue();

            if (!Objects.equals(element1, element2)) {
                foundMismatch = true;
            }

            queue1.enqueue(element1);
            queue2.enqueue(element2);
        }

        return !foundMismatch;
    }
}

class QueueQuestion3 {
    public static <E> void mirror(Queue3130<E> queue) {
        Stack3130<E> stack = new ArrayStack3130<>(); // or LinkedStack3130

        for (int i = 0; i < queue.size(); i++) {
            E element = queue.dequeue();
            stack.push(element);
            queue.enqueue(element);
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }
}

class QueueQuestion4 {
    public static <E> void twice(Queue3130<E> queue) {
        int originalSize = queue.size();

        for (int i = 0; i < originalSize; i++) {
            E element = queue.dequeue();
            queue.enqueue(element);
            queue.enqueue(element);
        }
    }
}