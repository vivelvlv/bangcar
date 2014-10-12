package com.bangcar.app.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bangcar.app.YGBApp;
import com.bangcar.app.mapi.common.User;

public class ConfigUtil {

	public static final String UID = "uid";
	public static final String EMAIL = "email";
	public static final String EMAILVERIFIED = "emailVerified";
	public static final String MOBILE = "mobile";
	public static final String CORPID = "corpId";
	public static final String ISRESETPWD = "isResetPwd";
	public static final String NAME = "name";
	public static final String IDCARDNO = "idCardNo";
	public static final String AVATAR = "avatar";
	public static final String CORPNAME = "corpName";

	public static int screenWidth, screenHeight;
	public static String model = Build.MODEL.toLowerCase();

	public static float getY(int height) {
		if (screenHeight == 0 || screenHeight == 960) {
			return height;
		}
		return height * screenHeight / 960 + 0.5f;
	}

	public static int getX(int width) {
		if (screenWidth == 0 || screenWidth == 640) {
			return width;
		}
		float scale = (float) screenHeight / 960;
		float nw = width * scale + 0.5f;
		int w = (int) Math.ceil(nw);
		return w;
	}

	public static int getMonth(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		return cal.get(Calendar.MONTH) + 1;
	}

	public static int getHour(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	public static int getMinute(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		return cal.get(Calendar.MINUTE);
	}

	public static int getDay(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public static int getSecond(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(time);
		return cal.get(Calendar.SECOND);
	}

	@SuppressLint("SimpleDateFormat")
	public static String getDate(int time, String pattern) {
		String sdf = new SimpleDateFormat(pattern).format(new Date(
				(long) time * 1000));
		return sdf;

	}

	/**
	 * 保存服务器时间
	 * 
	 * @param time
	 */
	public static void saveRTime(long time) {
		long rtime = (long) time * 1000;
		YGBApp.getUserSp().edit().putLong("rtime", rtime).commit();
		YGBApp.getUserSp().edit()
				.putLong("localTime", System.currentTimeMillis()).commit();
	}

	// 获取服务端时间与本地时间的差
	public static long getLeaveTime() {
		return getLocalTime() - getRTime();
	}

	public static long getRTime() {
		return YGBApp.getUserSp().getLong("rtime", -1L);
	}

	public static long getLocalTime() {
		return YGBApp.getUserSp().getLong("localTime", -1L);
	}

	/**
	 * 判断是否是今天
	 * 
	 * @param time
	 * @return
	 */
	public static boolean isToday(long time) {
		if (time > getStartTime() && time <= getEndTime()) {
			return true;
		}
		return false;
	}

	/**
	 * 今天开始时间
	 * 
	 * @return
	 */
	private static Long getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.setTime(new Date());
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTimeInMillis();
	}

	/**
	 * 今天结束时间
	 * 
	 * @return
	 */
	private static Long getEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.setTime(new Date());
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTimeInMillis();
	}

	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	/**
	 * 设置ListView自适应高度
	 * 
	 * @param listView
	 * @param attHeight
	 */
	public static void setListViewHeightBasedOnChildren(ListView listView,
			int attHeight) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}

		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}

		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1))
				+ attHeight;
		listView.setLayoutParams(params);
	}

	public static void initDate(int lastTime, TextView dateTv) {
		int currentTime = (int) (System.currentTimeMillis() / 1000);
		int calTime = lastTime;
		int resultTime = currentTime - calTime;
		if (resultTime > 0) {
			if (resultTime / 60 < 60) {
				dateTv.setText(((resultTime / 60) + 1) + "分钟前");
			} else if (resultTime / 60 >= 60 && resultTime / 3600 < 24) {
				dateTv.setText((resultTime / 3600) + "小时前");
			} else if (resultTime / 3600 >= 24 && resultTime / (3600 * 24) < 30) {
				dateTv.setText(resultTime / (3600 * 24) + "天前");
			} else if (resultTime / (3600 * 24) >= 30
					&& resultTime / (3600 * 24 * 30) < 12) {
				dateTv.setText(resultTime / (3600 * 24) + "月前");
			} else if (resultTime / (3600 * 24 * 30 * 12) >= 1) {
				dateTv.setText(resultTime / (3600 * 24 * 30 * 12) + "年前");
			}
		}
	}

	/**
	 * 保存skey
	 * 
	 * @param skey
	 */
	public static void saveSkey(String skey) {
		SharedPreferences sp = YGBApp.getUserSp();
		Editor edit = sp.edit();
		edit.putString("skey", skey);
		edit.commit();
	}

	/**
	 * 获取skey
	 * 
	 * @return
	 */
	public static String getSkey() {
		return YGBApp.getUserSp().getString("skey", "");
	}

	/**
	 * 清楚登录态
	 */
	public static void clearSkey() {
		YGBApp.getUserSp().edit().putString("skey", "").commit();
	}

	/**
	 * 保存用户信息
	 * 
	 * @param user
	 */
	public static void saveUser(User user) {
		if(user == null){
			return;
		}
		SharedPreferences sp = YGBApp.getUserSp();
		Editor edit = sp.edit();
		edit.putInt(UID, user.uid);
		edit.putString(EMAIL, user.email);
		edit.putInt(EMAILVERIFIED, user.emailVerified);
		edit.putString(MOBILE, user.mobile);
		edit.putInt(CORPID, user.corpId);
		edit.putInt(ISRESETPWD, user.isResetPwd);
		edit.putString(NAME, user.name);
		edit.putString(IDCARDNO, user.idCardNo);
		edit.putString(AVATAR, user.avatar);
		edit.putString(CORPNAME, user.corpName);
		edit.commit();
	}

	/**
	 * 获取User对象
	 * 
	 * @return
	 */
	public static User getUser() {
		User user = new User();
		SharedPreferences sp = YGBApp.getUserSp();
		user.uid = sp.getInt(UID, -1);
		user.email = sp.getString(EMAIL, "");
		user.emailVerified = sp.getInt(EMAILVERIFIED, -1);
		user.mobile = sp.getString(MOBILE, "");
		user.corpId = sp.getInt(CORPID, -1);
		user.isResetPwd = sp.getInt(ISRESETPWD, -1);
		user.name = sp.getString(NAME, "");
		user.idCardNo = sp.getString(IDCARDNO, "");
		user.avatar = sp.getString(AVATAR, "");
		user.corpName = sp.getString(CORPNAME, "");
		return user;
	}

	/**
	 * 正则匹配返回产品期限值
	 * 
	 * @param value
	 * @return
	 */
	public static String getPeriodValue(String value) {
		Pattern p = Pattern.compile("((\\-)?\\d+(.\\d+)?)");
		Matcher m = p.matcher(value);
		if (m.find()) {
			return m.group(1);
		}
		return "";
	}
	
	/**
	 * 格式化金钱
	 * @param d
	 * @return
	 */
	public static String formateMoney(double d){
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("##,###");
		return myformat.format(d);
	}

	/**
	 * 压缩图片
	 * 
	 * @param image
	 * @return
	 */
	public static Bitmap compressImage(Bitmap image, int maxSize) {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
		int options = 100;
		while (baos.toByteArray().length / 1024 > maxSize) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
			options -= 10;// 每次都减少10
			baos.reset();// 重置baos即清空baos
			if (options < 0 || options > 100) {
				break;
			}
			image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中
			System.out.println("sssssssizenew " + baos.toByteArray().length
					/ 1024);
		}
		ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
		Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片
		return bitmap;
	}

	/**
	 * 根据宽度缩放图片
	 * 
	 * @param bitmap
	 * @param destWidth
	 * @return
	 */
	public static Bitmap scaleBmp(Bitmap bitmap, float destWidth) {
		int height = bitmap.getHeight();
		int width = bitmap.getWidth();
		float nWidth = destWidth;
		float nHeight = ((float) destWidth / width) * height;
		float scaleWidth = ((float) nWidth) / width;
		float scaleHeight = ((float) nHeight) / height;
		// 5、创建Matrix对象 Matrix是在Android中用于操作图像的类
		Matrix matrix = new Matrix();
		// 6、使用Matrix对象跟缩放比例实现缩放图片
		matrix.postScale(scaleWidth, scaleHeight);
		return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
	}

	/**
	 * 读取图片属性：旋转的角度
	 * 
	 * @param path
	 *            图片绝对路径
	 * @return degree旋转的角度
	 */
	public static int readPictureDegree(String path) {
		int degree = 0;
		try {
			ExifInterface exifInterface = new ExifInterface(path);
			int orientation = exifInterface.getAttributeInt(
					ExifInterface.TAG_ORIENTATION,
					ExifInterface.ORIENTATION_NORMAL);
			switch (orientation) {
			case ExifInterface.ORIENTATION_ROTATE_90:
				degree = 90;
				break;
			case ExifInterface.ORIENTATION_ROTATE_180:
				degree = 180;
				break;
			case ExifInterface.ORIENTATION_ROTATE_270:
				degree = 270;
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return degree;
	}

	/**
	 * 旋转图片
	 * 
	 * @param angle
	 * @param bitmap
	 * @return Bitmap
	 */
	public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
		// 旋转图片 动作
		Matrix matrix = new Matrix();
		matrix.postRotate(angle);
		// 创建新的图片
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
				bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		// if(!bitmap.isRecycled()){
		// bitmap.recycle();
		// }
		return resizedBitmap;
	}

	public static int readDegressByUri(Uri mImageCaptureUri) {

		// 不管是拍照还是选择图片每张图片都有在数据中存储也存储有对应旋转角度orientation值
		// 所以我们在取出图片是把角度值取出以便能正确的显示图片,没有旋转时的效果观看
		int angle = 0;
		ContentResolver cr = YGBApp.getInstance().getContentResolver();
		Cursor cursor = cr.query(mImageCaptureUri, null, null, null, null);// 根据Uri从数据库中找
		if (cursor != null) {
			cursor.moveToFirst();// 把游标移动到首位，因为这里的Uri是包含ID的所以是唯一的不需要循环找指向第一个就是了
			String orientation = "0";
			try {
				orientation = cursor.getString(cursor
						.getColumnIndex("orientation"));
			} catch (Exception e) {
				return 0;
			} finally {
				cursor.close();
			}
			if (orientation != null && !"".equals(orientation)) {
				angle = Integer.parseInt(orientation);
			}
		}
		return angle;
	}

	@SuppressWarnings("resource")
	public static Bitmap getBitmapFromFile(File file) {
		BitmapFactory.Options bfOptions = new BitmapFactory.Options();
		bfOptions.inDither = false;
		bfOptions.inPurgeable = true;
		bfOptions.inSampleSize = 2;
		bfOptions.inPreferredConfig = Bitmap.Config.RGB_565;
		// bfOptions.inTempStorage = new byte[150 * 1024];
		bfOptions.inJustDecodeBounds = false;
		FileInputStream fs = null;
		Bitmap bmp = null;
		try {
			fs = new FileInputStream(file);
			if (fs != null) {
				bmp = BitmapFactory.decodeStream(fs, null, bfOptions);
				// bmp = BitmapFactory.decodeFileDescriptor(fs.getFD(), null,
				// bfOptions);
				return bmp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bmp;
	}
}
