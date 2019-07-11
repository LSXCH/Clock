package com.bytedance.clockapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bytedance.clockapplication.widget.Clock;

public class MainActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;
    Runnable runnable;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                mClockView.setShowAnalog(true);
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable1, 0);

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacksAndMessages(null);
                mClockView.setShowAnalog(!mClockView.isShowAnalog());
                final boolean flag = mClockView.isShowAnalog();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if(flag == false)
                        {
                            mClockView.setShowAnalog(false);
                        }
                        else
                        {
                            mClockView.setShowAnalog(true);
                        }
                        handler.postDelayed(this, 1000);
                    }
                };
                handler.postDelayed(runnable, 0);
            }
        });

    }
}
