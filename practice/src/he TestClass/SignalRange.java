// Use StringBuilder
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
 
class SignalRange {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
 
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int numbers = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] array = new int[numbers];
            for (int i = 0; i < numbers; i++)
                array[i] = Integer.parseInt(st.nextToken());
            solve(array, numbers);
        }
        br = null;
        st = null;
        System.gc();
    }
    
    public static void solve(int array[], int N) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        StringBuilder stb = new StringBuilder("1 ");
        
        for (int i = 1; i < N; i++) {
            // pop all the elements smaller than the current element
            while (!stack.empty() &&  array[stack.peek()] <= array[i])
                stack.pop();
            // if no elements are smaller than current element, it is the largest
            // so, result[i] will be 1 + index
            if (stack.empty())
                stb.append(i + 1);
            else  // else result[i] = current index - index of previous larger element
                stb.append(i - stack.peek());
                
            stack.push(i);
            if (i != N-1)
                stb.append(" ");
        }
        System.out.println(stb.toString());
        stb = null;
        stack = null;
        System.gc();
    }
}