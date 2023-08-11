### [题目](https://leetcode-cn.com/problems/print-foobar-alternately/){:target="_blank"}

我们提供一个类：

```java
class FooBar {
    public void foo() {
        for (int i = 0; i < n; i++) {
           print("foo");
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            print("bar");
        }
    }
}

```

两个不同的线程将会共用一个 FooBar实例。其中一个线程将会调用foo()方法，另一个线程将会调用bar()方法。

请设计修改程序，以确保 "foobar" 被输出 n 次。



**示例 1:**
输入: n = 1  
输出: "foobar"  
解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。

**示例 2:**
输入: n = 2  
输出: "foobarfoobar"  
解释: "foobar" 将被输出两次。
