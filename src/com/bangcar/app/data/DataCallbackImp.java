package com.bangcar.app.data;

public abstract class DataCallbackImp implements DataCallback{

	public abstract void dealwithData(Object data,int status);
	
	@Override
	public void onComplete(Object data, int status) {
		dealwithData(data, status);
	}
	
}
