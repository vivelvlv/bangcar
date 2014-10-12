package com.bangcar.app.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;
import com.bangcar.app.R;
import com.bangcar.app.mapi.profile.AuthCheckResp;

/**
 * 初次账户安全的总界面
 * Created by vive on 2014/9/24.
 */
public class AccountManagerActivity extends BaseFragmentActivity {
    private Fragment[] mFragments = new Fragment[4];
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private View cancelTv;
    private TextView titleTv, operateTv;
    private Intent intent;
    private String[] operateTvList = {"下一步", "下一步", "下一步", "完成"};
    private String[] titleTvList = {"实名认证(1/4)", "填写银行卡(2/4)", "验证银行卡(3/4)", "设置交易密码(4/4)"};
    private int pid = 0, step = 0;
    private AuthCheckResp authCheckResp = null;

    @Override
    protected void setLayout() {
        setContentView(R.layout.layout_account_manager_activity);
    }

    @Override
    protected void findViews() {
        fragmentManager = getSupportFragmentManager();
        mFragments[0] = fragmentManager.findFragmentById(R.id.NameIdentificationFragmentId);    //step1:实名认证
        mFragments[1] = fragmentManager.findFragmentById(R.id.AddBankCardFragmentId);           //step2:添加银行卡
        mFragments[2] = fragmentManager.findFragmentById(R.id.BankVerificationFragmentId);      //step3:银行卡认证
        mFragments[3] = fragmentManager.findFragmentById(R.id.SettingTradePasswordFragmentId);  //step4:设置密码
        cancelTv = findViewById(R.id.cancelTv);
        titleTv = (TextView) findViewById(R.id.titleTv);
        operateTv = (TextView) findViewById(R.id.operateTv);

    }

    /**
     * 设置左上角的文字
     *
     * @param operateTv
     */
    private void setOperateTv(String operateTv) {
        this.operateTv.setText(operateTv);
    }

    private void setTitleTv(String titleTv) {
        this.titleTv.setText(titleTv);
    }

    /**
     * 交给分fragment进行下一步的操作设置
     *
     * @param onClickListener
     */
    public void setOperateTvHandle(View.OnClickListener onClickListener) {
        this.operateTv.setOnClickListener(onClickListener);
    }

    /**
     * 展示那个页面 0 - 3
     * 选择fragment的总入口
     *
     * @param step
     */
    private void gotoFragment(int step) {
        if (!((0 <= step) && (step <= 3))) {
            return;
        }
        fragmentTransaction = fragmentManager.beginTransaction()
                .hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]).hide(mFragments[3]);
        fragmentTransaction.show(mFragments[step]).commit();
        setOperateTv(operateTvList[step]);
        setTitleTv(titleTvList[step]);
    }

    /**
     * 通用的处理CheckAuth接口方法
     *
     * @param resp
     */
    public void generateAuthDeal(AuthCheckResp resp) {
        authCheckResp = resp;
        switch (resp.getAuthStep()) {
            case STEP_FINISH:
                showToast("绑定完成");
                AccountManagerActivity.this.finish();
                break;
            case STEP_IDCARD:
                gotoFragment(0);//进行身份认证：外部入口进来到这里
                break;
            case STEP_BANKCARD:
                if (resp.getAuthId() == null || resp.getAuthId().trim().isEmpty()) {
                    gotoFragment(1);
                } else {
                    gotoFragment(2);
                }
                break;
            case STEP_TRANSPWD:
                gotoFragment(3);
                break;
        }
    }

    public AuthCheckResp getAuthCheckResp() {
        return authCheckResp;
    }

    @Override
    protected void setEvents() {
        cancelTv.setOnClickListener(this);
    }

    /**
     * 这里的step是后台传输过来的step总共有三步：
     * 1.实名认证
     * 2.绑卡 2-1添加银行卡，2-2红包验卡
     * 3.设置密码
     * <p/>
     * 需要映射到四个fragment上
     */
    @Override
    protected void initDatas() {
        intent = getIntent();//获得现在用户认证状态
        AuthCheckResp resp = (AuthCheckResp) intent.getSerializableExtra("eAuth");
        pid = intent.getIntExtra("pid", -1);
        generateAuthDeal(resp);
    }

    @Override
    public void responseData(Object data, int status) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancelTv:
                finish();
                break;
        }
    }
}
