package com.practice.design.oo;

/**
 * The singleton pattern is one of the simplest design patterns:
 * it involves only one class which is responsible to instantiate itself,
 * to make sure it creates not more than one instance; in the same time it provides
 * a global point of access to that instance. In this case the same instance can be used from everywhere,
 * being impossible to invoke directly the constructor each time.
 *
 * Lazy instantiation using double locking mechanism.
 * The standard implementation shown in the above code is a thread safe implementation,
 * but it's not the best thread-safe implementation beacuse synchronization is very expensive
 * when we are talking about the performance. We can see that the synchronized method getInstance
 * does not need to be checked for syncronization after the object is initialized.
 * If we see that the singleton object is already created we just have to return it without
 * using any syncronized block. This optimization consist in checking in an unsynchronized block
 * if the object is null and if not to check again and create it in an syncronized block.
 * This is called double locking mechanism.
 *
 * In this case case the singleton instance is created when the getInstance() method is called for the first time.
 * This is called lazy instantiation and it ensures that the singleton instance is created only when it is needed.
 *
 * One more way is Early instantiation using implementation with static field.
 *
 * There are many common situations when singleton pattern is used:
 * - Logger Classes
 * - Configuration Classes
 * - Accesing resources in shared mode
 */
class OO_1_Singleton
{
  private static OO_1_Singleton instance;

  private OO_1_Singleton()
  {
    System.out.println("OO_1_Singleton(): Initializing Instance");
  }

  public static OO_1_Singleton getInstance()
  {
    if (instance == null)
    {
      synchronized(OO_1_Singleton.class)
      {
        if (instance == null)
        {
          System.out.println("getInstance(): First time getInstance was invoked!");
          instance = new OO_1_Singleton();
        }
      }
    }

    return instance;
  }

  public void doSomething()
  {
    System.out.println("doSomething(): OO_1_Singleton does something!");
  }
}

