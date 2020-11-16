package com.chen.interview.design;

/**
 * 饿汉式单例.
 * 通过static的静态初始化方式，在该类第一次被加载的时候，就有一个SimpleSingleton的实例被创建出来了.
 * 这样就保证在第一次想要使用该对象时，他已经被初始化好了.
 */
public class Singleton {
  private static Singleton singleton = new Singleton();

  private Singleton() {
  }

  public static Singleton getInstance() {
    return singleton;
  }
}
