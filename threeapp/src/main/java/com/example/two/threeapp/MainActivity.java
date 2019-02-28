package com.example.two.threeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.two.baselib.impl.IUserManager;
import com.xuexiang.xipc.XIPC;
import com.xuexiang.xipc.core.channel.IPCListener;
import com.xuexiang.xipc.core.channel.IPCService;

import static com.xuexiang.xipc.XIPC.getContext;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        XIPC.connectApp(getContext(),"com.example.two.myxipcone");
        XIPC.setIPCListener(new IPCListener() {
            @Override
            public void onIPCConnected(Class<? extends IPCService> service) {
                Toast.makeText(MainActivity.this,"绑定成功",Toast.LENGTH_SHORT).show();
                IUserManager userManager = XIPC.getInstance(IUserManager.class);
                tv.setText(userManager.getUser()+"--APP3");
            }
        });
    }
}
