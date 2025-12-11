package com.winter.app.test;

import java.util.function.Supplier;

public class Test {

	public void plus() throws Exception {
		Calc cal = (int a, int b)->a+b;
		int result = cal.cal(2, 3);
		
		Calc c2 = (int a, int b)-> a*b;
		c2.cal(3, 2);
		
		Supplier<Integer> s = () -> {
			return 2*2;
		};
	}
}
