package top_interview;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: yinkai
 * Date: 2019-12-29
 * Time: 21:34
 */

//146. LRU缓存机制

public class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;


    public LRUCache(int capacity) {

        // 第三个参数accessOrder影响数据访问之后会不会移动
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return this.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }


    // 删除节点的条件
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // 返回  1

        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));     // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
