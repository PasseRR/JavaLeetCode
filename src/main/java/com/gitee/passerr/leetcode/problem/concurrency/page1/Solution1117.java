package com.gitee.passerr.leetcode.problem.concurrency.page1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * 你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 * 换句话说:
 * 如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。
 * 如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。
 * 书写满足这些限制条件的氢、氧线程同步代码。
 * <p>
 * 示例 1:
 * 输入: "HOH"
 * 输出: "HHO"
 * 解释: "HOH" 和 "OHH" 依然都是有效解。
 * <p>
 * 示例 2:
 * 输入: "OOHHHH"
 * 输出: "HHOHHO"
 * 解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" 和 "OHHOHH" 依然都是有效解。
 * <p>
 * 限制条件:
 * 输入字符串的总长将会是 3n, 1 ≤ n ≤ 50；
 * 输入字符串中的 “H” 总数将会是 2n；
 * 输入字符串中的 “O” 总数将会是 n。
 * @author xiehai
 * @date 2019/07/30 13:32
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution1117 {
    public void execute(String s) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        H2O h2O = new H2O();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'H') {
                executorService.execute(() -> {
                    try {
                        h2O.hydrogen(() -> System.out.print("H"));
                    } catch (Exception ignore) {
                    }
                });
            } else {
                executorService.execute(() -> {
                    try {
                        h2O.oxygen(() -> System.out.print("O"));
                    } catch (Exception ignore) {
                    }
                });
            }
        }
    }
}

// #region snippet
class H2O {
    private Semaphore hs = new Semaphore(2);
    private Semaphore os = new Semaphore(1);
    /**
     * 氢元素出现次数
     */
    private volatile int hc = 0;

    public H2O() {
        try {
            // 先让氢元素打印
            os.acquire();
        } catch (Exception ignore) {

        }
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hs.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        synchronized (this) {
            hc += 1;
            if ((hc & 1) == 0) {
                os.release();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        os.acquire();
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        hs.release(2);
    }
}

// #endregion snippet
