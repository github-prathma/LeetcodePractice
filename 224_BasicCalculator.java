import java.util.*;
import java.io.*;

class BasicCalculator {
    public static int calculate(String s) {
        Stack<Object> st = new Stack<>();

        // int i = s.length()-1;

        // int res = 0;
        int oper = 0;
        int n=0;
        for (int i=s.length()-1; i>=0; --i) {
            char ch = s.charAt(i);
            // System.out.println("i== " + i);
            if (Character.isDigit(ch)) {
                // String num = "";
                // while(i>=0 && Character.isDigit(s.charAt(i))) {
                //     num += s.charAt(i);
                //     i--;
                // }

                // st.push(num);
                // System.out.println(st.peek());
                oper += (int)Math.pow(10, n) * (int)(ch-'0');
                n+=1;
            } else if (ch != ' ') {
                if (n!=0) {
                    st.push(oper);
                    n=0;
                    oper=0;
                } if (ch == '(') {
                    int res = 0;
                    if (!st.isEmpty()) {
                        // res = Long.parseLong(st.pop());
                        res = (int)st.pop();
                    }
                    while(!st.isEmpty() && !((char)st.peek() == ')')) {
                        // String str = st.peek();
                        char sign = (char)st.peek();
                        st.pop();
                        if (sign == '+') {
                            // res += Long.parseLong(st.pop());
                            res += (int)st.pop();
                        } else if (sign == '-') {
                            // res -= Long.parseLong(st.pop());
                            res -= (int)st.pop();
                        } 
                    }
                    st.pop();
                    st.push(res);
                } else {
                    // String sign = Character.toString(s.charAt(i));
                    // System.out.println(sign);
                    st.push(ch);
                    // System.out.println(st.peek());
                }
            }
        }

        // System.out.println(st);
        // if (!st.isEmpty()) {
        //     res = Long.parseLong(st.pop());
        //     while(!st.isEmpty()) {
        //         // System.out.println("hh");
        //         String str = st.peek();
        //         st.pop();
        //         // System.out.println(str);
        //         if (str.compareTo("+") == 0) {
        //             res += Long.parseLong(st.pop());
        //         } else if (str.compareTo("-") == 0) {
        //             res -= Long.parseLong(st.pop());
        //         } 
        //     }
        // }
        if (n != 0) {
            st.push(oper);
        }

        int res = 0;
        if (!st.isEmpty()) {
            // res = Long.parseLong(st.pop());
            res = (int)st.pop();
         }
        while(!st.isEmpty() && !((char)st.peek() == ')')) {
                        // String str = st.peek();
            char sign = (char)st.peek();
            st.pop();
            if (sign == '+') {
                            // res += Long.parseLong(st.pop());
                res += (int)st.pop();
            } else if (sign == '-') {
                            // res -= Long.parseLong(st.pop());
                res -= (int)st.pop();
            } 
        }

        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int ans = calculate(input);
        System.out.println(ans);
    }
}