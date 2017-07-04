#  基类设置

* [BaseActivity](#baseactivity)
* [BaseApplication](#baseapplication)


## BaseActivity
activity 的基类
添加了跳转公共方法和吐司公共方法
```
public class BaseActivity extends AppCompatActivity {
    protected void jumpToActivity(Class<?> mClass){
        startActivity(new Intent(this, mClass));
    }
    protected void jumpToActivity(Class<?> mClass, int requestCode){
        startActivityForResult(new Intent(this, mClass), requestCode);
    }
    protected void jumpToActivity(Class<?> mClass, Bundle bundle){
        startActivity(new Intent(this, mClass).putExtras(bundle));
    }
    protected void jumpToActivity(Class<?> mClass, Bundle bundle, int requestCode){
        startActivityForResult(new Intent(this, mClass).putExtras(bundle), requestCode);
    }
    protected void jumpToActivity(String className) throws ClassNotFoundException {
        Class<?> mClass = Class.forName(className);
        jumpToActivity(mClass);
    }
    protected void jumpToActivity(String className, int requestCode) throws ClassNotFoundException {
        Class<?> mClass = Class.forName(className);
        jumpToActivity(mClass, requestCode);
    }
    protected void jumpToActivity(String className, Bundle bundle) throws ClassNotFoundException {
        Class<?> mClass = Class.forName(className);
        jumpToActivity(mClass, bundle);
    }
    protected void jumpToActivity(String className, Bundle bundle, int requestCode) throws ClassNotFoundException {
        Class<?> mClass = Class.forName(className);
        jumpToActivity(mClass, bundle, requestCode);
    }
    protected void toast(String msg){
        Toast.makeText(this, StringUtil.isEmpty(msg) ? "" : msg, Toast.LENGTH_SHORT).show();
    }
    protected void toastLong(String msg){
        Toast.makeText(this, StringUtil.isEmpty(msg) ? "" : msg, Toast.LENGTH_LONG).show();
    }
    protected void toastUI(final String msg){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, StringUtil.isEmpty(msg) ? "" : msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void toastUILong(final String msg){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, StringUtil.isEmpty(msg) ? "" : msg, Toast.LENGTH_LONG).show();
            }
        });
    }
    protected void appExit() {
        new AlertDialog.Builder(this).setMessage("确定关闭吗？ ")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                }).setNegativeButton("取消", null).show();
    }

}
```
## BaseApplication
application 的基类
添加了全局context
```
public class BaseApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    public static Context getAppContext(){
        return context;
    }
}
```
