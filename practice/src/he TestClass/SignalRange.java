import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class SignalRange{
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);

        while (T-- > 0) {
            line = br.readLine();
            int numbers = Integer.parseInt(line);
            line = br.readLine();
            String[] strings = line.split(" ");
            int[] array = new int[numbers];
            for (int i = 0; i < numbers; i++)
                array[i] = Integer.parseInt(strings[i]);
            int[] result = solve(array, numbers);
            for (int i = 0; i < numbers; i++)
                System.out.print(result[i] + " ");
        }
    }
    
    public static int[] solve(int array[], int N) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[N];
        stack.push(0);
        result[0] = 1;
        
        for (int i = 1; i < N; i++) {
            // pop all the elements smaller than the current element
            while (!stack.empty() &&  array[stack.peek()] <= array[i])
                stack.pop();
            // if no elements are smaller than current element, it is the largest
            // so, result[i] will be 1 + index
            if (stack.empty())
                result[i] = i + 1;
            else  // else result[i] = current index - index of previous larger element
                result[i] = i - stack.peek();
                
            stack.push(i);
        }
        return result;
    }
}
