package com.bangcar.app.data;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.bangcar.app.activity.LoginActivity;
import com.bangcar.app.mapi.base.MApiException;
import com.bangcar.app.util.ConfigUtil;
import com.bangcar.app.util.Global;
import com.bangcar.app.util.HttpUtil;

/**
 * Created by xus5985 on 2014/6/27.
 */
public abstract class BaseClient extends DataCallbackImp {

	public Activity act;
	private DataCallback callback;

	/**
	 * synReqAndRes执行具体请求操作 1.创建同步client，例如： UserService.Client client = new
	 * UserService.Client(synprotocol);
	 * 2.调用client的数据访问接口，client.getUser("login1") 3.开始等待数据返回 4.完毕
	 * 5.注意在synReqAndRes中进行异常捕捉
	 */

	public BaseClient(Activity act) {
		this.act = act;
	}

	public abstract Object synReqAndRes(Object iface) throws TException;

	// 同步接口-》异步实现
	public void synClient(String url, String clientName,
			final DataCallback callback) {
		this.callback = callback;
		new GetDataTask(url, clientName).execute();
	}

	class GetDataTask extends AsyncTask<Void, Void, Void> {

		private Object obj;
		private int status = Global.DATA_OK;
		private String clientName;
		private String url;

		public GetDataTask(String url, String clientName) {
			this.url = url;
			this.clientName = clientName;
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				THttpClient thc = new THttpClient(url,
						HttpUtil.getNewHttpClient());
				TProtocol synprotocol = null;
				if (url.contains("https")) {
					TYgbTransport tf = new TYgbTransport(thc);
					synprotocol = new TBinaryProtocol(tf);
				} else {
					// else 本机测试使用的保留
					synprotocol = new TBinaryProtocol(thc);
				}
				Class<?> clientProcess = Class.forName(Global.THRIFTPATH
						+ clientName + "$Client");
				Constructor<?> con = clientProcess
						.getConstructor(TProtocol.class);
				Object iface = con.newInstance(synprotocol);
				obj = synReqAndRes(iface);

				// 通过反射获取head字段并保存skey
				Class<?> cls = obj.getClass();
				Field fld = cls.getDeclaredField("head");
				com.bangcar.app.mapi.base.MApiRespHead head = (com.bangcar.app.mapi.base.MApiRespHead) fld
						.get(obj);
				ConfigUtil.saveSkey(head.skey);

			} catch (MApiException e) {
				status = Global.DATA_LOGICEXCEPTION;
				obj = e;

				try {
					// 通过反射获取head字段并保存skey
					Class<?> cls = obj.getClass();
					Field fld = cls.getDeclaredField("head");
					com.bangcar.app.mapi.base.MApiRespHead head = (com.bangcar.app.mapi.base.MApiRespHead) fld
							.get(obj);
					ConfigUtil.saveSkey(head.skey);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception ex) {
				status = Global.DATA_SYSTEMEXCEPTION;
				obj = ex;
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);

			if (status == Global.DATA_LOGICEXCEPTION) {
				if (true == handleErrorCode((MApiException) obj)) {
					return;
				}
			}
			callback.onComplete(obj, status);
		}
	}

	/**
	 * 返回 true 表示 错误已经处理，不需要在下发， 返回 false表示没有处理错误，需要下发处理
	 * 这个方法用来添加需要返回到LoginActivity界面的统一错误码处理
	 * 
	 * @param ex
	 * @return
	 */
	private boolean handleErrorCode(MApiException ex) {
		int errorCode = ex.getRetCode();
		// int[] ToastList = ErrorCode.ToastList;
		int[] LoginList = ErrorCode.LoginList;
		// 下面是针对Toast类型的错误进行处理
		// for (int i = 0; i < ToastList.length; i++) {
		// if (errorCode == ToastList[i]){
		// Toast.makeText(act, ex.getRetMsg(), Toast.LENGTH_SHORT).show();
		// return true;
		// }
		// }
		for (int i = 0; i < LoginList.length; i++)
			if (errorCode == LoginList[i]) {
				Toast.makeText(act, ex.getRetMsg(), Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(act, LoginActivity.class);
				// TODO : 这里有个缺陷，如何把activity的栈底内容页清除掉，还没有实现，可以通过自己维护的栈列表来解决 9-18
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				act.startActivity(intent);
				act.finish();
				return true;
			}
		return false;
	}

}
