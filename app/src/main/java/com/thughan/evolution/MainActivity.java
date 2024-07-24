package com.thughan.evolution;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.thughan.android.ModuleConstants;
import com.thughan.designmode.DesignConstants;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mDesignMode;
    private Button mLeakCanary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ARouter.init(getApplication());
        mDesignMode = findViewById(R.id.btn_design_mode);
        mLeakCanary = findViewById(R.id.btn_leak_canary);

        mLeakCanary.setOnClickListener(this);
        mDesignMode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_design_mode:
                ARouter.getInstance().build(DesignConstants.ACTIVITY_PATH).navigation();
                break;
            case R.id.btn_leak_canary:
                ARouter.getInstance().build(ModuleConstants.ACTIVITY_PATH).navigation();
                break;
            default:
                break;
        }
    }
}