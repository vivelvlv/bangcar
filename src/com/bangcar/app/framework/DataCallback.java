package com.bangcar.app.framework;

import com.bangcar.app.mapi.base.MApiException;

public interface DataCallback {

    /**
     * 请求开始,此处放置开始加载的UI
     */
	public void onReqStart();

    /**
     * 请求结束,此处放置结束加载的UI
     */
	public void onReqEnd();

    /**
     * 返回成功，返回数据
     * @param data
     */
	public void onSuccess(Object data);

    /**
     * 逻辑异常，返回异常
     * @param exception
     */
	public void onLogincException(MApiException exception);

    /**
     * 系统异常，返回异常
     * @param e
     */
	public void onError(Exception e);
}
