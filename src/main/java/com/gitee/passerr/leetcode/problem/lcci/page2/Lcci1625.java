package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，
 * 并在初始化时指定最大容量。 当缓存被填满时，它应该删除最近最少使用的项目。
 * <p>
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，
 * 它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 示例:
 * LRUCache cache = new LRUCache(2);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * @author xiehai
 * @date 2021/04/19 09:34
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */

public class Lcci1625 {

}

// #region snippet
class LRUCache {
    /**
     * 容量
     */
    private final int capacity;
    /**
     * lru缓存双链表
     */
    private final LinkedList<Node> cache = new LinkedList<>();
    /**
     * 哈希数据存储
     */
    private final Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = this.map.get(key);
        // key存在
        if (Objects.nonNull(node)) {
            // 更新缓存
            this.cache.remove(node);
            this.cache.addFirst(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        // 根据key获取
        Node node = this.map.get(key);
        // 新值
        Node newNode = new Node(key, value);
        // key覆盖
        if (Objects.nonNull(node)) {
            this.cache.remove(node);
        } else if (this.map.size() >= this.capacity) {
            // 到达容量上限
            Node remove = this.cache.removeLast();
            this.map.remove(remove.key);
        }

        // 更新key值
        this.map.put(key, newNode);
        // 更新缓存为最近访问
        this.cache.addFirst(newNode);
    }


    /**
     * 数据节点
     */
    static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
// #endregion snippet
