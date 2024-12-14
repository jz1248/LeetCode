package priv.zzy.solutions;

import priv.zzy.Solution;

public class T00134 extends Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int fuel;
        for (int i = 0; i < n; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }
            fuel = gas[i];
            int j = i;
            int cnt = 0;
            while (true) {
                if (fuel >= cost[j]) {
                    fuel -= cost[j];
                    j = (j + 1) % n;
                    fuel += gas[j];
                    if (i == j) {
                        return i;
                    }
                    cnt++;
                } else {
                    break;
                }
            }
            i += cnt;
        }
        return -1;
    }

    @Override
    public void run() {
        int[] gas, cost;
        gas = new int[]{1, 2, 3, 4, 5};
        cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static void main(String[] args) {
        T00134 solution = new T00134();
        solution.run();
    }
}
