package com.gitee.passerr.leetcode.problem.concurrency.page1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 假设有这么一个类：
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // 构造函数
 * public void zero(printNumber) { ... }  // 仅打印出 0
 * public void even(printNumber) { ... }  // 仅打印出 偶数
 * public void odd(printNumber) { ... }   // 仅打印出 奇数
 * }
 * <p>
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出："0102"
 * 说明：三条线程异步执行，其中一个调用 zero()，另一个线程调用 even()，最后一个线程调用odd()。正确的输出为 "0102"。
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出："0102030405"
 * @author xiehai
 * @date 2019/07/30 11:17
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution1116 {
    public void execute(int n) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (Exception ignore) {

            }
        });
        executorService.execute(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (Exception ignore) {

            }
        });
        executorService.execute(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (Exception ignore) {

            }
        });
    }
}

// #region snippet
class ZeroEvenOdd {
    private int n;
    private Semaphore zero = new Semaphore(1);
    private Semaphore odd = new Semaphore(1);
    private Semaphore even = new Semaphore(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        even.acquire();
        odd.acquire();
        for (int i = 0; i < this.n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            if ((i & 1) == 0) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= this.n; i++) {
            if ((i & 1) == 1) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }
}
// #endregion snippet
