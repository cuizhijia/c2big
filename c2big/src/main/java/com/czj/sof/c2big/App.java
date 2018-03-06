package com.czj.sof.c2big;

import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.czj.sof.c2big.aop.DynaProxyForMe;
import com.czj.sof.c2big.aop.Operator;
import com.czj.sof.c2big.aop.impl.EvenOperator;
import com.czj.sof.c2big.aop.impl.EventOperation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        System.out.println("czj".hashCode());
        
        Operator Operator = (Operator) new  DynaProxyForMe().bind(new EvenOperator(), new EventOperation());
        
        Operator.operation();
        
        String i_ = "234";
        
        System.out.println(i_);
        
	    try (InputStreamReader read = new InputStreamReader(System.in)) {
	    	int read2 = read.read();
	    	System.out.println(read2);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
    }
    
    
    
    public static <T> Map<String, Annotation[]> getAon(Class<T> clazz) {
    	
    	Method[] methods = clazz.getMethods();
    	
    	Map<String, Annotation[]> map = new HashMap<>();
    	
    	for (Method method : methods) {
    		map.put(method.getName(), method.getAnnotations());
		}
    	System.out.println(map);
    	return map;
    }
    
    
    
    
}
