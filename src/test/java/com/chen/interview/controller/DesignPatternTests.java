package com.chen.interview.controller;

import static org.assertj.core.api.Assertions.assertThat;


import com.chen.interview.design.Singleton;
import com.chen.interview.design.Singleton2;
import com.chen.interview.design.SingletonLazy;
import com.chen.interview.design.SingletonLazy2;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class DesignPatternTests {
  static ExecutorService scheduler = Executors.newFixedThreadPool(8);
  static CountDownLatch countDownLatch;

  @Test
  public void testSingleton() {
    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();
    assertThat(s1 == s2);
  }

  @Test
  public void testSingletonByCdl() throws Exception {
    countDownLatch = new CountDownLatch(5);
    Set<Singleton> set = new HashSet<>();

    for (int index = 0; index < 5; index++) {
      Runnable run = () -> {
        System.out.println("currentThread:" + Thread.currentThread().getName() + " start.");
        try {
          Singleton singleton = Singleton.getInstance();
          set.add(singleton);
        } finally {
          countDownLatch.countDown();
        }
      };
      scheduler.submit(run);
    }
    countDownLatch.await();
    scheduler.shutdown();

    set.forEach(s -> {
      System.out.println("Singleton is=" + s.toString());
    });

    assertThat(set).hasSize(1);
  }

  @Test
  public void testSingleton2ByCdl() throws Exception {
    countDownLatch = new CountDownLatch(10);
    Set<Singleton2> set = new HashSet<>();

    for (int index = 0; index < 10; index++) {
      Runnable run = () -> {
        System.out.println("currentThread:" + Thread.currentThread().getName() + " start.");
        try {
          Singleton2 singleton2 = Singleton2.getInstance();
          set.add(singleton2);
        } finally {
          countDownLatch.countDown();
        }
      };
      scheduler.submit(run);
    }
    countDownLatch.await();
    scheduler.shutdown();

    set.forEach(s -> {
      System.out.println("Singleton is=" + s.toString());
    });

    assertThat(set).hasSize(1);
  }

  @Test
  public void testSingletonLazyByCdl() throws Exception {
    countDownLatch = new CountDownLatch(10);
    Set<SingletonLazy> set = new HashSet<>();

    for (int index = 0; index < 10; index++) {
      Runnable run = () -> {
        System.out.println("currentThread:" + Thread.currentThread().getName() + " start.");
        try {
          SingletonLazy lazy = SingletonLazy.getInstance();
          set.add(lazy);
        } finally {
          countDownLatch.countDown();
        }
      };
      scheduler.submit(run);
    }
    countDownLatch.await();
    scheduler.shutdown();

    set.forEach(s -> {
      System.out.println("Singleton is=" + s.toString());
    });

    assertThat(set).hasSize(1);
  }

  @Test
  public void testSingletonLazy2ByCdl() throws Exception {
    countDownLatch = new CountDownLatch(5);
    Set<SingletonLazy2> set = new HashSet<>();

    for (int index = 0; index < 5; index++) {
      Runnable run = () -> {
        System.out.println("currentThread:" + Thread.currentThread().getName() + " start.");
        try {
          SingletonLazy2 lazy2 = SingletonLazy2.getInstance();
          set.add(lazy2);
        } finally {
          countDownLatch.countDown();
        }
      };
      scheduler.submit(run);
    }
    countDownLatch.await();
    scheduler.shutdown();

    set.forEach(s -> {
      System.out.println("Singleton is=" + s.toString());
    });

    assertThat(set).hasSize(1);
  }

}
