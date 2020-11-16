package com.chen.interview.design;

/**
 * 静态内部类式.
 */
public class Singleton2 {
  private static class SingletonHolder {
    private static final Singleton2 instance = new Singleton2();
  }

  private Singleton2() {
  }

  public static Singleton2 getInstance() {
    return SingletonHolder.instance;
  }
}
