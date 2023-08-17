package com.gitee.passerr.leetcode.problem.concurrency.page1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Solution1316
 * @author xiehai
 * @date 2023/08/17 15:57
 */
public class Solution1195 {
    /**
     * 模拟测试方法
     * @param n 数字n
     */
    public void execute(int n) {
        FizzBuzz fizzBuzz = new FizzBuzz(n);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.execute(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.execute(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.execute(() -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

class FizzBuzz {
    private final int n;
    private boolean isEnable = true;
    Semaphore fizz = new Semaphore(1);
    Semaphore buzz = new Semaphore(1);
    Semaphore fizzbuzz = new Semaphore(1);
    Semaphore number = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
        try {
            // 初始化时 让3、5、3&5等待
            fizz.acquire();
            buzz.acquire();
            fizzbuzz.acquire();
        } catch (InterruptedException e) {

        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            this.fizz.acquire();
            if (!this.isEnable) {
                break;
            }
            printFizz.run();
            this.number.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            this.buzz.acquire();
            if (!this.isEnable) {
                break;
            }
            printBuzz.run();
            this.number.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            this.fizzbuzz.acquire();
            if (!this.isEnable) {
                break;
            }
            printFizzBuzz.run();
            this.number.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            this.number.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                this.fizzbuzz.release();
            } else if (i % 3 == 0) {
                this.fizz.release();
            } else if (i % 5 == 0) {
                this.buzz.release();
            } else {
                printNumber.accept(i);
                this.number.release();
            }
        }

        // 无论是哪一个数字打印都会释放一个普通数字信号量 等待其他线程打印完成
        this.number.acquire();
        // 结束标识
        this.isEnable = false;
        // 跳出循环
        this.buzz.release();
        this.fizz.release();
        this.fizzbuzz.release();
    }
}
