import java.io.*;
import java.util.*;

public class TextEditor {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer str = null;
        Stack<StringBuilder> stack = new Stack<StringBuilder>();
        StringBuilder string = new StringBuilder("");
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            str = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(str.nextToken());
            
            switch (c) {
                case 1:
                    stack.push(new StringBuilder(string));
                    string.append(str.nextToken());
                    break;
                
                case 2:
                    int d = Integer.parseInt(str.nextToken());
                    stack.push(new StringBuilder(string));
                    for (int i = 0; i < d; i++)
                        string.deleteCharAt(string.length()-1);
                    break;
                case 3:
                    int e = Integer.parseInt(str.nextToken());
                    System.out.println(string.charAt(e-1));
                    break;
                case 4:
                    string = stack.pop();
                    break;
            }
        }

    }
}