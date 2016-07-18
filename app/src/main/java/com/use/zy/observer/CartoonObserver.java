package com.use.zy.observer;

public class CartoonObserver implements Observer {

	@Override
	public void update(Subject subject, Object data) {
		System.out.println( " 我是"+this.getClass().
				getSimpleName()+"，  "+data+"别看漫画了");	
	}

}
