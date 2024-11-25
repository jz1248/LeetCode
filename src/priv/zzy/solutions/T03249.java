package priv.zzy.solutions;

import priv.zzy.Solution;

import java.util.ArrayList;
import java.util.List;

public class T03249 extends Solution {

    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> f = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            f.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            f.get(a).add(b);
            f.get(b).add(a);
        }

        boolean[] m = new boolean[n];
        dfs(f, m, 0, -1);
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (m[j]) {
                count++;
            }
        }
        return count;
    }

    public int dfs(List<List<Integer>> f, boolean[] m, int curNode, int parentNode) {
        int lastChildNum = -1;
        boolean result = true;
        int thisNum = 1;
        List<Integer> nodes = f.get(curNode);
        for (int node : nodes) {
            if (node == parentNode) {
                continue;
            }
            int childNum = dfs(f, m, node, curNode);
            thisNum += childNum;
            if (!result) {
                continue;
            }
            if (lastChildNum < 0) {
                lastChildNum = childNum;
            } else if (lastChildNum != childNum) {
                result = false;
            }
        }
        m[curNode] = result;
        return thisNum;
    }

    @Override
    public void run() {
        System.out.println(countGoodNodes(new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}}));
        System.out.println(countGoodNodes(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}}));
        System.out.println(countGoodNodes(new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}}));
    }
}
