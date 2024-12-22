package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00012 extends Solution {

    public String intToRoman(int num) {
        final String[] ten = new String[]{"I", "X", "C", "M"};
        final String[] five = new String[]{"V", "L", "D"};
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            int base = 1;
            for (int j = 0; j < i; j++) {
                base *= 10;
            }
            int s = num / base;
            if (s == 0) {
                continue;
            }
            if (s % 5 == 4) {
                String near = s >= 5 ? ten[i + 1] : five[i];
                sb.append(ten[i]);
                sb.append(near);
            } else {
                if (s >= 5) {
                    sb.append(five[i]);
                    s = s - 5;
                }
                for (int j = s; j > 0; j--) {
                    sb.append(ten[i]);
                }
            }
            num = num % base;
        }
        return sb.toString();
    }

    @Override
    public void run() {
        System.out.println(intToRoman(3749));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(2499));
    }

    public static void main(String[] args) {
        T00012 solution = new T00012();
        solution.run();
    }
}
