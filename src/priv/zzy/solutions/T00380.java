package priv.zzy.solutions;

import priv.zzy.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T00380 extends Solution {

    static class RandomizedSet {

        private List<Integer> list;
        private Map<Integer, Integer> hashTable;

        public RandomizedSet() {
            list = new ArrayList<>();
            hashTable = new HashMap<>();
        }

        public boolean insert(int val) {
            if (hashTable.containsKey(val)) {
                return false;
            }
            hashTable.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!hashTable.containsKey(val)) {
                return false;
            }
            hashTable.remove(val);
            return true;
        }

        public int getRandom() {
            List<Integer> list1 = hashTable.values().stream().toList();
            int index = list1.get((int) (Math.random() * list1.size()));
            return list.get(index);
        }
    }

    @Override
    public void run() {
        RandomizedSet obj = new RandomizedSet();
        System.out.println(obj.insert(0));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(0));
        System.out.println(obj.insert(2));
        System.out.println(obj.remove(1));
        System.out.println(obj.getRandom());
    }
}
