package com.bangcar.app.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;

import android.os.AsyncTask;

import com.bangcar.app.data.TYgbTransport;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.util.Global;
import com.bangcar.app.util.HttpUtil;

/**
 * Created by 9020MT on 2014/10/8.
 */
public class RequestFramework {

	public Object client = null;
	public DataCallback callback = null;

	/*
	 * 构造函数
	 */
	public RequestFramework(String url) {
		preRequest(url);
	}

	public void setCallback(DataCallback callback) {
		this.callback = callback;
	}

	/*
	 * 预请求,根据请求地址和API名字创建一个XXXXXAPI.client对象
	 */
	private Object preRequest(String url) {
		try {
			String generateUrl = Global.HOST + url + Global.urlEnd;
			THttpClient thc = new THttpClient(generateUrl,
					HttpUtil.getNewHttpClient());
			TProtocol synprotocol = null;
			if (generateUrl.contains("https")) {
				TYgbTransport tf = new TYgbTransport(thc);
				synprotocol = new TBinaryProtocol(tf);
			} else {
				// else 本机测试使用的保留
				synprotocol = new TBinaryProtocol(thc);
			}
			String endName = url.substring(1);
			String apiName = url.substring(0, 1).toUpperCase() + endName
					+ "API";
			Class<?> clientProcess = Class.forName(Global.THRIFTPATH + apiName
					+ "$Client");
			Constructor<?> con = clientProcess.getConstructor(TProtocol.class);
			client = con.newInstance(synprotocol);
		} catch (Exception e) {
			System.out.println("创建请求客户端失败");
			client = null;
		}
		return client;
	}

	/*
	 * 返回执行结果
	 */
	public void resultRequest(Object response, int status) {
		// endReqUI();
		// responseHandle(response, status);
	}

	/**
	 * 带callback的请求方法
	 * 
	 * @param client
	 * @param methodName
	 * @param args
	 * @param callback
	 */
	public void exeReq(final String methodName, DataCallback callback,final Object... args) {
		this.callback = callback;
		callback.onReqStart();
		new GetDataTask(this.client, methodName, args).execute();
	}

	/**
	 * 不带callback的请求方法，需要手动setCallback;
	 * 
	 * @param client
	 * @param methodName
	 * @param args
	 */
	public void exeReq(final String methodName, final Object... args) {
		if (callback == null) {
			throw new IllegalArgumentException("request callback is null");
		}
		callback.onReqStart();
		new GetDataTask(this.client, methodName, args).execute();
	}

	class GetDataTask extends AsyncTask<Void, Void, Void> {

		private Object owner;
		private int status = Global.DATA_OK;
		private String methodName;
		private Object[] args;
		private Object response;

		public GetDataTask(Object owner, String methodName, Object... args) {
			this.owner = owner;
			this.methodName = methodName;
			this.args = args;
		}

		@Override
		protected Void doInBackground(Void... params) {

			Class ownerClass = owner.getClass();
			Class[] argsClass = new Class[args.length];
			for (int i = 0, j = args.length; i < j; i++) {
				argsClass[i] = args[i].getClass();
			}
			Method method = null;
			try {
				method = ownerClass.getMethod(methodName, argsClass);
			} catch (NoSuchMethodException e) {
				status = Global.DATA_SYSTEMEXCEPTION;
				response = e;
			}
			try {
				response = method.invoke(owner, args);
			} catch (Exception e) {
				if (e instanceof MApiException) {
					status = Global.DATA_LOGICEXCEPTION;
					response = e;
				} else {
					status = Global.DATA_SYSTEMEXCEPTION;
					response = e;
				}
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			if (callback == null) {
				throw new IllegalArgumentException("callback is null");
			}
			callback.onReqEnd();
			switch (status) {
			case Global.DATA_OK:
				callback.onSuccess(response);
				break;
			case Global.DATA_LOGICEXCEPTION:
				callback.onLogincException((MApiException) response);
				break;
			case Global.DATA_SYSTEMEXCEPTION:
				callback.onError((Exception) response);
				break;
			}
		}
	}
}
