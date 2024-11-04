package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00633 extends Solution {

    public boolean judgeSquareSum(int c) {
        if (isSquareNum(c)) {
            return true;
        }

        double max = Math.sqrt(c);
        for (int i = 0; i < max; i++) {
            if (isSquareNum(c - i * i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSquareNum(int c) {
        return ((int) Math.sqrt(c)) * ((int) Math.sqrt(c)) == c;
    }

    @Override
    public void run() {
        assert judgeSquareSum(5);
        assert !judgeSquareSum(3);
    }
}
