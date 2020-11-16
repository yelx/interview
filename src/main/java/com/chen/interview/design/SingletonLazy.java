package com.chen.interview.design;

/**
 * 懒汉模式.
 * 这种模式存在线程安全问题,参见测试 testSingletonLazyByCdl().
 */
public class SingletonLazy {
  private static SingletonLazy singletonLazy;

  private SingletonLazy() {
  }

  public static SingletonLazy getInstance() {
    if (null == singletonLazy) {
      singletonLazy = new SingletonLazy();
    }
    return singletonLazy;
  }
}
