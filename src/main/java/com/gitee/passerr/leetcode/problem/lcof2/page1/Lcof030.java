package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 设计一个支持在平均时间复杂度 O(1)下，执行以下操作的数据结构：
 * <p>
 * insert(val)：当元素 val 不存在时返回 true，并向集合中插入该项，否则返回 false 。
 * remove(val)：当元素 val 存在时返回 true，并从集合中移除该项，否则返回 false。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * <p>
 * 示例 :
 * 输入: inputs = ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * 输出: [null, true, false, true, 2, true, false, 2]
 * 解释:
 * RandomizedSet randomSet = new RandomizedSet();  // 初始化一个空的集合
 * randomSet.insert(1); // 向集合中插入 1 ， 返回 true 表示 1 被成功地插入
 * randomSet.remove(2); // 返回 false，表示集合中不存在 2
 * randomSet.insert(2); // 向集合中插入 2 返回 true ，集合现在包含 [1,2]
 * randomSet.getRandom(); // getRandom 应随机返回 1 或 2
 * randomSet.remove(1); // 从集合中移除 1 返回 true 。集合现在包含 [2]
 * randomSet.insert(2); // 2 已在集合中，所以返回 false
 * randomSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2
 * <p>
 * 提示：
 * -2<sup>31</sup><= val <= 2<sup>31</sup>- 1
 * 最多进行 2 * 10<sup>5</sup> 次insert ， remove 和 getRandom 方法调用
 * 当调用getRandom 方法时，集合中至少有一个元素
 * <p>
 * 注意：本题与主站 380题相同：https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * @author xiehai
 * @date 2022/01/07 16:31
 */
public class Lcof030 {
}

// #region snippet
class RandomizedSet {
    /**
     * 缓存数组及对应数组下标
     */
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * 随机访问数组
     */
    List<Integer> values = new ArrayList<>();
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
            return false;
        }
        // 记录val存放的索引
        this.map.put(val, this.values.size());
        // 记录值到数组尾部
        this.values.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (this.map.containsKey(val)) {
            // 当前数组容量
            int size = this.values.size();
            // 当前数组尾部值
            Integer lastValue = this.values.get(size - 1);
            // 删除值所在索引
            Integer index = this.map.remove(val);
            // 若删除的不是最后一个元素
            if (index != size - 1) {
                // 最后一个元素与删除元素交换位置
                this.map.put(lastValue, index);
                this.values.set(index, lastValue);
            }
            
            // 删除最后一个元素 即val
            this.values.remove(size - 1);
            
            return true;
        }

        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return this.values.get(this.random.nextInt(this.values.size()));
    }
}
// #endregion snippet
