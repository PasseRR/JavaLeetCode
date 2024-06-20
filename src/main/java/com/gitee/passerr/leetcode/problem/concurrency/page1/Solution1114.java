package com.gitee.passerr.leetcode.problem.concurrency.page1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 我们提供了一个类：
 * public class Foo {
 *   public void one() { print("one"); }
 *   public void two() { print("two"); }
 *   public void three() { print("three"); }
 * }
 * 三个不同的线程将会共用一个 Foo 实例。
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * 示例 2:
 * 输入: [1,3,2]
 * 输出: "onetwothree"
 * 解释:
 * 输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
 * 正确的输出是 "onetwothree"。
 * @author xiehai
 * @date 2019/07/15 10:58
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution1114 {
    private Runnable one = () -> System.out.println("one");
    private Runnable two = () -> System.out.println("two");
    private Runnable three = () -> System.out.println("three");

    public void execute(int[] nums) {
        Foo foo = new Foo();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int num : nums) {
            switch (num) {
                case 1: {
                    executorService.submit(() -> {
                        try {
                            foo.first(one);
                        } catch (InterruptedException ignore) {

                        }
                    });
                    break;
                }
                case 2: {
                    executorService.submit(() -> {
                        try {
                            foo.second(two);
                        } catch (InterruptedException ignore) {

                        }
                    });
                    break;
                }
                case 3: {
                    executorService.submit(() -> {
                        try {
                            foo.third(three);
                        } catch (InterruptedException ignore) {

                        }
                    });
                    break;
                }
                default: {
                    break;
                }
            }
        }
        executorService.shutdown();
    }
}

// #region snippet
class Foo {
    // 使用信号量实现 考虑只需限制两个数字即可
    Semaphore c2 = new Semaphore(0);
    Semaphore c3 = new Semaphore(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.c2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        this.c2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.c3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        this.c3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
// #endregion snippet
