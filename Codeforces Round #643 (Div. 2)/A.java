import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A{
    static class Task {
        private long[] get(long num){
            long mini=10,maxi=0;
            while(num>0){
                mini=Math.min(mini,num%10);
                maxi=Math.max(maxi,num%10);
                num/=10;
            }
            return new long[]{mini,maxi};
        }
        public void solve(int testNumber,InputReader in,PrintWriter out){
            int t=in.nextInt();
            while((t--)>0){
                long a=in.nextLong(),k=in.nextLong();
                long prev=a;
                for(int i=1;i<k;i++){
                    long [] minmax=get(prev);
                    if(minmax[0]==0) break;
                    prev+=minmax[0]*minmax[1];
                }
                out.println(prev);
            }
        }
    }
    private static void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }
    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }


}


