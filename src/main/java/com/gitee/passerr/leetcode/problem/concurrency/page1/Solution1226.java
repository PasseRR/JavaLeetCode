package com.gitee.passerr.leetcode.problem.concurrency.page1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * Solution1226
 * @author xiehai
 * @date 2023/08/18 09:35
 */
public class Solution1226 {
    public void execute(int n) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        DiningPhilosophers philosophers = new DiningPhilosophers();
        CountDownLatch count = new CountDownLatch(5 * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                final int index = j;
                service.execute(() -> {
                    try {
                        philosophers.wantsToEat(
                            index,
                            () -> System.out.printf("[%d, 1, 1], ", index),
                            () -> System.out.printf("[%d, 2, 1], ", index),
                            () -> System.out.printf("[%d, 0, 3], ", index),
                            () -> System.out.printf("[%d, 1, 2], ", index),
                            () -> System.out.printf("[%d, 2, 2], ", index)
                        );
                    } catch (InterruptedException ignore) {
                    } finally {
                        count.countDown();
                    }
                });
            }
        }

        try {
            count.await();
        } catch (InterruptedException ignore) {
        }
    }
}

// #region snippet
class DiningPhilosophers {
    /**
     * 假设哲学家按照题目描述编号，p0、p1、p2、p3、p4
     * 叉子编号为f0、f1、f2、f3、f4
     * 叉子和哲学家位置关系 f0p0f1p1f2p2f3p3f4p4f0p0....
     */
    Semaphore[] forks = new Semaphore[5];
    /**
     * 最多同时允许4个人用餐
     */
    Semaphore philosophers;

    public DiningPhilosophers() {
        // 叉子信号量准备
        IntStream.range(0, forks.length).forEach(it -> this.forks[it] = new Semaphore(1));
        // 用餐人数信号量
        this.philosophers = new Semaphore(4);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher, Runnable pickLeftFork, Runnable pickRightFork, Runnable eat,
                           Runnable putLeftFork, Runnable putRightFork) throws InterruptedException {
        this.philosophers.acquire();
        Semaphore left = this.forks[(philosopher + 1) % 5], right = this.forks[philosopher];
        left.acquire();
        right.acquire();
        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        // 叉子释放
        putRightFork.run();
        right.release();
        putLeftFork.run();
        left.release();
        // 用餐人数释放
        this.philosophers.release();
    }
}
// #endregion snippet
