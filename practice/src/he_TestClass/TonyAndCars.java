import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
class TonyAndCars {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        Map<Integer, Long> map = new HashMap<Integer, Long>();
        long nines = 9;
        for (int i = 1; i < 12; i++) {
            map.put(i, nines);
            nines *= 10;
        }
 
		StringBuilder strb = new StringBuilder();
 
		while (T-- > 0) {
 
			long k = Long.parseLong(br.readLine());
			long sum = 0;
			long dsum = 0;
			long t = 0;
			int i = 1;
			while (sum != k) {
				long temp = map.get(i);
				if ((sum + temp) > k) {
					t = k - sum;
					sum += t;
					dsum += t * i;
				} else {
					sum += temp;
					dsum += i * temp;
				}
				i++;
			}
			strb.append(dsum + "\n");
		}
		System.out.println(strb.toString());
 
        strb = null;
        map = null;
        br = null;
        System.gc();
    }
}