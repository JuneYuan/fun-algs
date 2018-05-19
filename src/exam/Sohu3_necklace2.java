package exam;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.util.*;

// Hodor写的
public class Sohu3_necklace2 {
    public static void main(String[] args) throws IOException {
        //InputStream inputStream = new FileInputStream("in.txt");
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task slover = new Task();
        slover.solve(1,in,out);
        out.close();
    }
    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            while (true) {
                String str;
                try {
                    str = in.next();
                }
                catch (java.lang.NullPointerException e) {
                    break;
                }
                int len = (int)str.length();
                str += str;
                int [][]a = new int[str.length()][5];
                for (int i = 0; i < 5; ++i) {
                    a[0][i] = 0;
                }
                if (str.charAt(0) >= 'A' && str.charAt(0) <= 'E') {
                    a[0][str.charAt(0)-'A'] = 1;
                }
                int ans = 0;
                for (int i = 1; i < str.length(); ++i) {
                    for (int j = 0; j < 5; ++j) {
                        a[i][j] = a[i-1][j];
                    }
                    if (str.charAt(i) >= 'A' && str.charAt(i) <= 'E') {
                        a[i][str.charAt(i)-'A'] += 1;
                    }
                    int l = 0, r = i, m;
                    while (l <= r) {
                        m = (l+r)>>1;
                        //out.print(l+" "+r+" "+m+"\n");
                        boolean f = true;
                        for (int j = 0; j < 5; ++j) {
                            int t = 0;
                            if (m > 0) t = a[m][j];
                            if (a[i][j]-t == 0) {
                                f = false;
                                break;
                            }
                        }
                        if (f) {
                            if (len-i+m > ans) ans = len-i+m;
                            l = m+1;
                        }
                        else {
                            r = m-1;
                        }
                    }
                }
                out.print(ans+"\n");
            }
        }

    }

    private static class InputReader {
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

    }

}