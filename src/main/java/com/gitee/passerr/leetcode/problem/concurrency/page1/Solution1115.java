package com.gitee.passerr.leetcode.problem.concurrency.page1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 我们提供一个类：
 * class FooBar {
 * public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 * }
 * <p>
 * public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 * }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 * 示例 1:
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * <p>
 * 示例 2:
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 * @author xiehai
 * @date 2019/07/30 10:57
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution1115 {
    public void execute(int n) throws InterruptedException {
        FooBar fooBar = new FooBar(n);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (Exception ignore) {

            }
        });
        executorService.execute(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (Exception ignore) {

            }
        });
    }
}

class FooBar {
    private int n;
    private volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag) { ; }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag) { ; }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = true;
        }
    }
}
