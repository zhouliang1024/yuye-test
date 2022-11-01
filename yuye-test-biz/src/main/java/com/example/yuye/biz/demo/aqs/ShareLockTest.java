package com.example.yuye.biz.demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 一共创建最多共同有3个线程共享的共享锁。
 * 创建5个线程去竞争共享锁。
 *
 * @author zhouliang
 * @date 2022/10/20 2:26 PM
 */
@Slf4j
public class ShareLockTest {
    public static void main(String[] args) throws InterruptedException {
        ShareLock shareLock = new ShareLock(3);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                shareLock.lockShare();
                try {
                    log.info("lock success");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    shareLock.releaseShare();
                    log.info("release success");
                }

            }, "thread-" + i).start();
        }
        Thread.sleep(10000);
    }
}
