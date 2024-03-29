package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.ArrayList;
import java.util.List;

/**
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * <p>
 * 示例1:
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 * 输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * <p>
 * 示例2:
 * 输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 * 输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * <p>
 * 说明:
 * 收纳所的最大容量为20000
 * @author xiehai
 * @date 2020/06/06 11:26
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0306 {
}

// #region snippet
class AnimalShelf {
    /**
     * 猫
     */
    List<Integer> cats = new ArrayList<>();
    /**
     * 狗
     */
    List<Integer> dogs = new ArrayList<>();

    public AnimalShelf() {
    }

    public void enqueue(int[] animal) {
        if (animal[1] == 0) {
            this.cats.add(animal[0]);
        } else {
            this.dogs.add(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if (this.dogs.isEmpty()) {
            return this.dequeueCat();
        }

        if (this.cats.isEmpty()) {
            return this.dequeueDog();
        }

        // 根据编号大小判断收容顺序
        return this.dogs.get(0) > this.cats.get(0) ? this.dequeueCat() : this.dequeueDog();
    }

    public int[] dequeueDog() {
        if (this.dogs.isEmpty()) {
            return new int[]{-1, -1};
        }

        // 小狗出队
        return new int[]{this.dogs.remove(0), 1};
    }

    public int[] dequeueCat() {
        if (this.cats.isEmpty()) {
            return new int[]{-1, -1};
        }

        // 小猫出队
        return new int[]{this.cats.remove(0), 0};
    }
}
// #endregion snippet
