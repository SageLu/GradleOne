package com.zzhl.gradletest2;

/**
 * 类名: RealSubject
 * 此类用途: ---
 *
 * @Date: 2018-07-09 14:15
 * @FileName: com.zzhl.gradletest2.RealSubject.java
 */
public class RealSubject implements Subject
{
    @Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }
}