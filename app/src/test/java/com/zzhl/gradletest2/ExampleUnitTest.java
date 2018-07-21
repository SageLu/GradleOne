package com.zzhl.gradletest2;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void proxy()  {

        //    我们要代理的真实对象
        Subject realSubject = new RealSubject();

        //    我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /*
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
         * 第一个参数<<正确：定义代理类的类加载器>>。错误： handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象)
         * 第二个参数realSubject.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
         */
        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), realSubject
                .getClass().getInterfaces(), handler);
//        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject
//                .getClass().getInterfaces(), handler);

        System.out.println(subject.getClass().getName());
        subject.rent();
        subject.hello("world");

        /*
    run log 控制台打印日志如下：

        com.sun.proxy.$Proxy4
        proxy.getClass():class com.sun.proxy.$Proxy4
        before rent house
        Method:public abstract void com.zzhl.gradletest2.Subject.rent()
        I want to rent my house
        after rent house
        proxy.getClass():class com.sun.proxy.$Proxy4
        before rent house
        Method:public abstract void com.zzhl.gradletest2.Subject.hello(java.lang.String)
        hello: world
        after rent house

        Process finished with exit code 0

     */
    }


}