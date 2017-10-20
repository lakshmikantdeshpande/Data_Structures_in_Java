import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
    // This program will work for manual as well as file input, and has been tested for the same
    public static void main(String[] args) throws Exception {
        // for command line input
        if (args.length == 0) {
            processManualInput();
        } else {
            processFileInput(args[0]);
        }
    }

    // Assumption: No line number is specified in the input
    private static void processFileInput(String fileName) throws Exception {
        File file = new File(fileName);
        int lineNumber = 0;

        // Print an error if the specified file does not exist
        if (file.exists()) {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                // trim will trim off any unnecessary whitespace
                String line = scanner.nextLine().trim();


                if (lineNumber++ == 0) {
                    try {
                        int number = Integer.parseInt(line);
                    } catch (NumberFormatException nfe) {
                        // ignore the first line (i.e. number of inputs, if present)

                        char[] characters = line.toCharArray();
                        boolean areStacksBalanced = findAnswer(characters);
                        // If an element remains in the stack after processing completes,
                        // we can say that there is / are 1 / more non matching brackets
                        System.out.println(areStacksBalanced ? "Yes" : "No");
                    }

                } else if (!line.isEmpty()) {
                    char[] characters = line.toCharArray();
                    boolean areStacksBalanced = findAnswer(characters);
                    // If an element remains in the stack after processing completes,
                    // we can say that there is / are 1 / more non matching brackets
                    System.out.println(areStacksBalanced ? "Yes" : "No");
                }
            }

            scanner.close();
        } else {
            throw new FileNotFoundException();
        }
    }

    private static void processManualInput() throws Exception {
        // For taking input
        Scanner scanner = new Scanner(System.in);

        // Number of items to be pushed onto the stack
        int numberOfInputs = scanner.nextInt();
        // consume an extra line, as Scanner won't automatically do that
        scanner.nextLine();

        char[] characters;
        while (numberOfInputs-- > 0) {
            // Take the input as a string, and convert it to a character array
            characters = scanner.nextLine().toCharArray();
            boolean areStacksBalanced = findAnswer(characters);
            // If an element remains in the stack after processing completes,
            // we can say that there is / are 1 / more non matching brackets
            System.out.println(areStacksBalanced ? "Yes" : "No");
        }
        scanner.close();
    }

    private static boolean findAnswer(char[] characters) throws Exception {
        Linked_List_Stack stack = new Linked_List_Stack();

        for (int i = 0; i < characters.length; i++) {
            // skip if the character is a space
            if (characters[i] == ' ') {
                continue;
            } else if (stack.isEmpty()) {
                stack.push(characters[i]);
            } else if (characters[i] == ')' && stack.peek() == '(') {
                // if matching round bracket is found, pop it
                stack.pop();
            } else if (characters[i] == ']' && stack.peek() == '[') {
                // if matching square bracket is found, pop it
                stack.pop();
            } else if (characters[i] == '}' && stack.peek() == '{') {
                // if matching curly bracket is found, pop it
                stack.pop();
            } else {
                stack.push(characters[i]);
            }
        }

        return stack.isEmpty();
    }
}


// Stack using a linked list
class Linked_List_Stack {
    private Node head;
    private int top;

    // constructor
    public Linked_List_Stack() {
        top = -1;
    }

    // pushes the data into the stack
    public void push(char data) {
        Node oldHead = head;
        head = new Node(data);
        head.next = oldHead;
        top++;
    }

    // returns the top element of the stack, and removes it from the stack
    public int pop() throws Exception {
        if (head == null)
            throw new Exception("Underflow");
        int data = head.data;
        head = head.next;
        top--;
        return data;
    }

    // returns if the stack is empty
    public boolean isEmpty() {
        return head == null;
    }

    // See the top element of the stack without removing it from the stack
    public int peek() throws Exception {
        if (head == null)
            throw new Exception("Stack is empty");
        return head.data;
    }

    // We can replace datatype of data variable to get a stack of our choice's datatype
    private class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

}

