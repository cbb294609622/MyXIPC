# Android 跨进程通信

在单个APP 中，主进程和子进程，进行通讯
在两个APP 中，跨进程通讯。

## Demo介绍
        app         被调用者
        twoapp      调用者
        baselib     实现和接口库

## 步骤：

    1.添加maven
            allprojects {
                 repositories {
                    ...
                    maven { url "https://jitpack.io" }
                }
            }

    2.添加引用
            dependencies {
              ...
              implementation 'com.github.xuexiangjys:XIPC:1.0.1'
              //注 XIPC作者使用gson传输，请自行加入gson引用
            }

    3.在Application中注册接口服务:
            //被调用者，本地只需要注册实现，无需注册接口
            XIPC.init(this);
            XIPC.debug(BuildConfig.DEBUG);
            XIPC.register(UserManager.class);

            //调用者，需要注册接口，但不用注册实现
            XIPC.init(this);
            XIPC.debug(BuildConfig.DEBUG);
            XIPC.register(IUserManager.class);
            注：注册多个接口or实现皆可以使用改接口的包名如下：
                XIPC.register("com.example.two.twoapp.service");

    4.接口类和实现类，请具体参考baselib中impl和mode

    5.跨应用通讯请按照如下方式：
            XIPC.connectApp(getContext(), "com.example.two.myxipcone"); //这里设置的是被调用App的包名
            应用内建立通讯后，可操作被调用者中暴露出的方法。
            使用完，必须断开连接，以保持下次连接成功。
            XIPC.disconnect(getContext());//上下文请使用XIPC中getContext

*以上数据以及代码是根据*
    xiaofei      [https://github.com/Xiaofei-it/Hermes]
    xuexiangjys  [https://github.com/xuexiangjys/XIPC]

*两位大神所制作的Demo*

***特别感谢***

