package com.chen.interview.design;

import java.io.Serializable;

/**
 * 使用双重校验锁方式实现单例.
 */
public class SingletonLazy2 implements Serializable {
  private static volatile SingletonLazy2 singletonLazy2;

  private SingletonLazy2() {
  }

  private Object readResolve() {
    return singletonLazy2;
  }

  public static SingletonLazy2 getInstance() {
    if (null == singletonLazy2) {
      synchronized (SingletonLazy2.class) {
        if (null == singletonLazy2) {
          singletonLazy2 = new SingletonLazy2();
        }
      }
    }

    return singletonLazy2;
  }
}
