package cn.zdh.popwindowdemo;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    ImageView iv_back, iv_right;
    RelativeLayout rl_layout, rl_layout_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_right = (ImageView) findViewById(R.id.iv_right);

        rl_layout = (RelativeLayout) findViewById(R.id.rl_layout);
        rl_layout_txt = (RelativeLayout) findViewById(R.id.rl_layout_txt);


        iv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
               // showAnimator();


            }
        });

    }

    /**
     * 监听
     */
    public void text(View view) {
        dismissPopWindow();
       // dismissAnimator();
    }

    /**
     * 动画
     */
    private PopupWindow popWindow;

    private void showPopupWindow() {
        View popView = View.inflate(this, R.layout.popup_layout, null);

        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().widthPixels;
        popWindow = new PopupWindow(popView, width, height, true);

        //  popWindow.setFocusable(true);
        //   popWindow.setOutsideTouchable(false);

        //设置背景颜色
        //ColorDrawable dw = new ColorDrawable(0x30000000);
        // popWindow.setBackgroundDrawable(dw);

        //设置动画
          popWindow.setAnimationStyle(R.style.lightAnimation);
       // popWindow.setAnimationStyle(R.style.topAnimation);


        //显示位置
        popWindow.showAsDropDown(rl_layout);


    }



    private void showAnimator() {
        //因为缩放到0.8，剩下的0.2上下个占一半所以上移空间为0.1f
        rl_layout_txt.setVisibility(View.VISIBLE);
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(rl_layout_txt, "translationY", -rl_layout_txt.getHeight() * 1f + 50f, 1f + 30f, 0f);
        translationYAnimator.setDuration(500);//动画必须设置时间；
        translationYAnimator.start();
    }


    private void dismissPopWindow() {
        if (popWindow != null & popWindow.isShowing()) {
            popWindow.dismiss();
            popWindow = null;

        }
    }

    private void dismissAnimator() {
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(rl_layout_txt, "translationY", 30f, 0f, -rl_layout_txt.getHeight() * 1f - 100f);
        translationYAnimator.setDuration(500);//动画必须设置时间；
        translationYAnimator.start();

    }

}
