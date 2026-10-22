/*
========================================================================================
CASE 1: LAZY INITIALIZATION (NOT THREAD SAFE)
========================================================================================
PROBLEM:
- Works fine in single-threaded applications.
- In multi-threading, multiple threads can enter at the same time and create multiple objects.

SOLUTION:
- Use synchronization / lock / Bill Pugh / Enum based Singleton.
========================================================================================

class SingletonLazyNotThreadSafe {

    private static SingletonLazyNotThreadSafe instance;

    private SingletonLazyNotThreadSafe() {
        System.out.println("SingletonLazyNotThreadSafe Instance Created");
    }

    public static SingletonLazyNotThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazyNotThreadSafe();
        }
        return instance;
    }
}

*/

/*
========================================================================================
CASE 2: EAGER INITIALIZATION (THREAD SAFE BUT NOT LAZY)
========================================================================================
PROBLEM:
- Instance is created at class loading time (Eager).
- If object creation is heavy (DB connection / file load), startup time increases.
- Memory is used even if instance is never used.

SOLUTION:
- Use Lazy initialization (Bill Pugh / Double Check Lock).
========================================================================================

class SingletonEagerThreadSafe {

    private static final SingletonEagerThreadSafe instance = new SingletonEagerThreadSafe();

    private SingletonEagerThreadSafe() {
        System.out.println("SingletonEagerThreadSafe Instance Created");
    }

    public static SingletonEagerThreadSafe getInstance() {
        return instance;
    }
}
*/

/*
========================================================================================
CASE 3: LAZY + THREAD SAFE USING SYNCHRONIZED METHOD
========================================================================================
PROBLEM:
- Thread safe because only one thread can enter method at a time.
- But performance issue: Every call requires lock even after instance is created.

SOLUTION:
- Use Double Check Locking or Bill Pugh Singleton.
========================================================================================

class SingletonSynchronizedMethod {

    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod() {
        System.out.println("SingletonSynchronizedMethod Instance Created");
    }

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}
*/

/*
========================================================================================
CASE 4: DOUBLE CHECK LOCKING (LAZY + THREAD SAFE + BETTER PERFORMANCE)
========================================================================================
PROBLEM:
- synchronized method is slow because lock is acquired every time.
- We want locking only when instance is not created yet.

SOLUTION:
- Double Check Locking:
  1) First check without lock (fast path)
  2) Lock only if instance is null
  3) Check again inside lock
  4) Create instance

IMPORTANT:
- Use "volatile" to avoid instruction reordering issues in multithreading.
========================================================================================

class SingletonDoubleCheckLocking {

    private static volatile SingletonDoubleCheckLocking instance;

    private static final Lock lock = new ReentrantLock();

    private SingletonDoubleCheckLocking() {
        System.out.println("SingletonDoubleCheckLocking Instance Created");
    }

    public static SingletonDoubleCheckLocking getInstance() {

        if (instance == null) { // First check (no lock)
            lock.lock();
            try {
                if (instance == null) { // Second check (with lock)
                    instance = new SingletonDoubleCheckLocking();
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }
}
*/

/*
========================================================================================
CASE 5: BILL PUGH SINGLETON (BEST PRACTICE - LAZY + THREAD SAFE)
========================================================================================
PROBLEM:
- We want:
  ✅ Lazy initialization
  ✅ Thread safety
  ✅ High performance
  ✅ Simple code
- synchronized / locks add overhead and complexity.

SOLUTION:
- Bill Pugh Singleton using static inner class.
- JVM loads the inner class only when it is referenced.
- JVM guarantees class loading is thread-safe.

KEY POINT:
- Outer class static variables initialize when outer class loads.
- Inner class static variables initialize only when inner class is referenced.

So INSTANCE is created only when getInstance() is called (Lazy).
========================================================================================

class SingletonBillPugh {

    private SingletonBillPugh() {
        System.out.println("SingletonBillPugh Instance Created");
    }

    private static class Helper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return Helper.INSTANCE;
    }
}
*/

/*
========================================================================================
CASE 6: ENUM SINGLETON (MOST RECOMMENDED IN JAVA)
========================================================================================
PROBLEM:
- Normal Singleton can break using:
  ❌ Reflection
  ❌ Serialization/Deserialization
  ❌ Cloning (if allowed)
- We want the most secure Singleton.

SOLUTION:
- Enum Singleton is the safest and simplest in Java.
- JVM ensures only one instance.
- Reflection & Serialization safe by default.

NOTE:
- Enum Singleton is eager by nature (created when enum is loaded).
========================================================================================

enum SingletonEnum {
    INSTANCE;

    public void doSomething() {
        System.out.println("SingletonEnum doSomething() called");
    }
}
*/

