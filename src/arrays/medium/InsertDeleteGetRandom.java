package arrays.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandom {
    static Map<Integer,Integer> map;
    static List<Integer> list;
    static java.util.Random rand = new java.util.Random();

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public static boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public static boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int loc = map.get(val);
        if(loc != list.size()-1) {
            int temp = list.get(list.size()-1);
            list.set(loc, temp);
            map.put(temp, loc);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public static int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

class TestInsertDeleteGetRandom {

}
