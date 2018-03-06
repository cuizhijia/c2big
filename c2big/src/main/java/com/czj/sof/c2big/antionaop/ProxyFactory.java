package com.czj.sof.c2big.antionaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂 *
 */
public class ProxyFactory
{
    public static Object newProxyInstance(final Object target,final Event aop)
    {
        // 生成代理对象的方法
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler()
                {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
                    {
                        aop.startWrite();// 关注点代码
                        Object result = method.invoke(target, args);// 执行目标对象的方法
                        aop.endWrite();// 关注点代码
                        return result;
                    }
                });
    }
}