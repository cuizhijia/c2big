package com.czj.sof.c2big.aop;

import java.lang.reflect.Method;

public interface IOperation {

	void start(Method method);
	
	
	void end(Method method);
}
