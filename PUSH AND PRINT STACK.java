// 1. PUSH AND PRINT STACK

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();

        s1.push(10);
        s1.push(20);
        s1.push(30);

        System.out.println(s1);
    }
}
// 2. PEEK AND POP

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();

        s1.push(10);
        s1.push(20);
        s1.push(30);

        System.out.println("Original: " + s1);
        System.out.println("Peek: " + s1.peek());
        System.out.println("Pop: " + s1.pop());
        System.out.println("After Pop: " + s1);
    }
}

// 3. GENERICS

class Box<T> {
    private T item;

    public void set(T item) {
        this.item = item;
    }

    public T get() {
        return item;
    }
}

public class Main {
    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(25);

        Box<String> box2 = new Box<>();
        box2.set("Ali");

        System.out.println(box1.get());
        System.out.println(box2.get());
    }
}
// 4. BANK UNDO DEPOSIT

import java.util.Stack;

class BankAccount {
    private double balance;
    private Stack<Double> history = new Stack<>();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        history.push(amount);
    }

    public void undoLastDeposit() {
        if (!history.isEmpty()) {
            balance -= history.pop();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100);

        acc.deposit(50);
        acc.deposit(20);
        acc.deposit(30);

        acc.undoLastDeposit();
        acc.undoLastDeposit();
    }
}
// 5. STUDENT UNDO COURSE

import java.util.Stack;

class Registration {
    private Stack<String> courses = new Stack<>();

    public void addCourse(String code) {
        courses.push(code);
    }

    public void undoLastCourse() {
        if (!courses.isEmpty()) {
            courses.pop();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Registration reg = new Registration();

        reg.addCourse("CA314");
        reg.addCourse("CA301");
        reg.addCourse("MA210");

        reg.undoLastCourse();
    }
}
// 6. REVERSE STRING

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String input = "JAVA";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        System.out.println(reversed);
    }
}
// 7. ARRAY STACK

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 2;
    private int top;
    private T[] stack;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        top = 0;
        stack = (T[]) new Object[capacity];
    }

    public void push(T element) {
        if (size() == stack.length) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
        stack[top++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T result = stack[--top];
        stack[top] = null;
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }
}
// 8. ARRAY STACK TRACE

public class Main {
    public static void main(String[] args) {
        ArrayStack<String> s = new ArrayStack<>();

        s.push("A");
        s.push("B");
        s.push("C");

        System.out.println("Size: " + s.size());
        System.out.println("Peek: " + s.peek());

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
// 9. CUSTOM EXCEPTION

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }
}
// 10. LINKED LIST TRAVERSE

public class Main {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(17);
        Node<Integer> n2 = new Node<>(92);
        Node<Integer> n3 = new Node<>(63);
        Node<Integer> n4 = new Node<>(45);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        Node<Integer> current = head;

        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }
}

// 11. INSERT AT FRONT

public class Main {
    public static void main(String[] args) {
        Node<String> head = new Node<>("B");
        Node<String> newNode = new Node<>("A");

        newNode.setNext(head);
        head = newNode;

        Node<String> current = head;

        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }
}

// 12. NODE CLASS

public class Node<T> {
    private T element;
    private Node<T> next;

    public Node() {
        element = null;
        next = null;
    }

    public Node(T element) {
        this.element = element;
        next = null;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}

// 13. LINKED STACK CLASS

public class LinkedStack<T> {
    private int count;
    private Node<T> top;

    public LinkedStack() {
        count = 0;
        top = null;
    }

    public void push(T element) {
        Node<T> temp = new Node<>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }

        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return top.getElement();
    }

    public boolean isEmpty() {
        return count == 0;
    }

// 14. LINKED STACK TRACE

public class Main {
    public static void main(String[] args) {
        LinkedStack<String> s = new LinkedStack<>();

        s.push("A");
        s.push("B");
        s.push("C");

        System.out.println("Size: " + s.size());
        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Size: " + s.size());
        System.out.println("Peek: " + s.peek());
    }
}

// 15. BANK USING LINKED STACK

class BankAccount {
    private double balance;
    private LinkedStack<Double> history = new LinkedStack<>();

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        history.push(amount);
    }

    public void undoLastDeposit() {
        if (!history.isEmpty()) {
            balance -= history.pop();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(100);

        acc.deposit(50);
        acc.deposit(20);
        acc.deposit(30);

        acc.undoLastDeposit();
        acc.undoLastDeposit();
    }
}

    public int size() {
        return count;
    }
}

// 16. STUDENT USING LINKED STACK

class Registration {
    private LinkedStack<String> courses = new LinkedStack<>();

    public void addCourse(String code) {
        courses.push(code);
        System.out.println("Added: " + code);
    }

    public void undoLastCourse() {
        if (!courses.isEmpty()) {
            System.out.println("Removed: " + courses.pop());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Registration reg = new Registration();

        reg.addCourse("CA314");
        reg.addCourse("CA301");
        reg.addCourse("MA210");

        reg.undoLastCourse();
        reg.undoLastCourse();
    }
}
