package com.czj.sof.c2big.match;

import java.util.Random;

public final class DescMatch {

	
	public static Integer[] descM(Integer[] array) {
		
		Integer temp;
		for (int i = array.length-1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if(array[j+1] < array[j]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
	
	
	public static int[] descM2(int[] array) {
		
		for(int i =0;i < array.length - 1;i++)  
		{  
			for(int j = 0;j <  array.length - 1-i;j++)// j开始等于0，  
			{  
				if(array[j] < array[j+1])  
				{  
					int temp = array[j];  
					array[j] = array[j+1];  
					array[j+1] = temp;  
				}  
			}  
		}  
		return array;
	}
	
	
	public static int[] descXE(int[] array) {
	        //希尔排序
	        int d=array.length;
            while(true) {
                d=d/2;
                for(int x=0;x<d;x++) {
                    for(int i=x+d;i<array.length;i=i+d) {
                        int temp=array[i];
                        int j;
                        for(j=i-d;j>=0&&array[j]>temp;j=j-d) {
                            array[j+d]=array[j];
                        }
                        array[j+d]=temp;
                    }
                }
                if(d==1) {
                    break;
                }
            }
            return array;       
	}
	
	
	 public static void sort(int[] array, int left, int right) {
	        if (left >= right)
	            return;
	        // 找出中间索引
	        int center = (left + right) / 2;
	        // 对左边数组进行递归
	        sort(array, left, center);
	        // 对右边数组进行递归
	        sort(array, center + 1, right);
	        // 合并
	        merge(array, left, center, right);
	        // 打印每次排序结果
//	        for (int i = 0; i < array.length; i++) {
//	            System.out.print(array[i] + " ");
//	        }
//	        System.out.println();
	  
	    }
	  
	    /**
	     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
	     * 
	     * @param array
	     *            数组对象
	     * @param left
	     *            左数组的第一个元素的索引
	     * @param center
	     *            左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
	     * @param right
	     *            右数组最后一个元素的索引
	     */
	    public static void merge(int[] array, int left, int center, int right) {
	        // 临时数组
	        int[] tmpArr = new int[array.length];
	        // 右数组第一个元素索引
	        int mid = center + 1;
	        // third 记录临时数组的索引
	        int third = left;
	        // 缓存左数组第一个元素的索引
	        int tmp = left;
	        while (left <= center && mid <= right) {
	            // 从两个数组中取出最小的放入临时数组
	            if (array[left] <= array[mid]) {
	                tmpArr[third++] = array[left++];
	            } else {
	                tmpArr[third++] = array[mid++];
	            }
	        }
	        // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
	        while (mid <= right) {
	            tmpArr[third++] = array[mid++];
	        }
	        while (left <= center) {
	            tmpArr[third++] = array[left++];
	        }
	        // 将临时数组中的内容拷贝回原数组中
	        // （原left-right范围的内容被复制回原数组）
	        while (tmp <= right) {
	            array[tmp] = tmpArr[tmp++];
	        }
	    }
	
	
	public static void main(String[] args) {
		
		int[] array = new int[20000];
		
		for (int i = 0; i < array.length; i++) {
			
			array[i] = new Random().nextInt(1000);
			
		}
		long currentTimeMillis = System.currentTimeMillis();
		descXE(array).toString();
		long currentTimeMillis2 = System.currentTimeMillis();
		
		long currentTimeMillis3 = System.currentTimeMillis();
		descM2(array);
		long currentTimeMillis4 = System.currentTimeMillis();
		
		long currentTimeMillis5 = System.currentTimeMillis();
		sort(array, 0, array.length - 1);
		long currentTimeMillis6 = System.currentTimeMillis();
		
		System.out.println("descXE 为："+(currentTimeMillis2-currentTimeMillis));
		
		System.out.println("descM2    为："+(currentTimeMillis4-currentTimeMillis3));
		
		System.out.println("sort   为："+(currentTimeMillis6-currentTimeMillis5));
	}
	
	
	
	
	
}
