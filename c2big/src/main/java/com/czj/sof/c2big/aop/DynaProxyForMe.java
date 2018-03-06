package com.czj.sof.c2big.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxyForMe implements InvocationHandler{

	
	 private Object proxy;
	
	
	 private Object delegate;
	 
	 
	 
	 public Object bind(Object delegate,Object proxy) {
		         this.proxy = proxy;
		         this.delegate = delegate;
		         return Proxy.newProxyInstance(
		                 this.delegate.getClass().getClassLoader(), this.delegate
		                         .getClass().getInterfaces(), this);
	}
	 
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Object result = null;
		try {
			Class clazz = this.proxy.getClass();
			
			Method start = clazz.getDeclaredMethod("start", new Class[] {Method.class});
			
			start.invoke(this.proxy, new Object[] {method});
			
			result = method.invoke(this.delegate, args);
			
			Method end = clazz.getDeclaredMethod("end", new Class[] {Method.class});
			
			end.invoke(this.proxy, new Object[] {method});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
