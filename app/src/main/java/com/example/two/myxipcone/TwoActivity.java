package com.example.two.myxipcone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.two.baselib.impl.IDataManager;
import com.example.two.baselib.impl.IUserManager;
import com.xuexiang.xipc.XIPC;
import com.xuexiang.xipc.core.channel.IPCListener;
import com.xuexiang.xipc.core.channel.IPCService;

import static com.xuexiang.xipc.XIPC.getContext;

public class TwoActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

//        XIPC.connect(getContext());
//        XIPC.setIPCListener(new IPCListener() {
//            @Override
//            public void onIPCConnected(Class<? extends IPCService> service) {
//                Toast.makeText(TwoActivity.this,"绑定成功",Toast.LENGTH_SHORT).show();
//                IUserManager is = XIPC.getInstance(IUserManager.class);
//                tv.setText(is.getUser()+"---1");
//            }
//        });

        XIPC.connect(getContext());
        XIPC.setIPCListener(new IPCListener() {
            @Override
            public void onIPCConnected(Class<? extends IPCService> service) {
                Toast.makeText(TwoActivity.this,"绑定成功",Toast.LENGTH_SHORT).show();
                IDataManager is = XIPC.getInstance(IDataManager.class);
                tv.setText(is.getString("name")+"---1");
            }
        });


    }

    @Override
    protected void onDestroy() {
        XIPC.disconnect(getContext());
        super.onDestroy();

    }
}
