# handialog
以我的姓氏命名的对话框，主打轻量级，使用简便，功能流畅，动画效果简约不普通

引入：
Step 1: Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
  	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.hanlonglin:handialog:Tag'
	}
  
  使用：
  //成功：
  DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_SUCCESS).show();
  
  
  //失败
  DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_FAIL).show();
  
  //警告
  DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_WARNING_CANCEL).show();
  
  //确定
  DialogFactory.buildConfirmDialog(this, DialogFactory.DIALOG_CONFIRM)
                .message("")
                .title("").show();
                
  //按钮监听
  DialogFactory.buildAlertDialog(this, DialogFactory.DIALOG_SUCCESS)
                .setAlertDialogListener(new AlertDialogListener() {
                    @Override
                    public void onCancel() {
                        
                    }

                    @Override
                    public void onConfrim() {

                    }
                }).show();
                
 //广告
 DialogFactory.buildAdvertDialog(this, DialogFactory.DIALOG_ADVERT)
                .url("http://t8.baidu.com/it/u=2063170438,222422588&fm=191&app=48&wm=1,13,90,45,0,7&wmo=10,10&n=0&g=0n&f=JPEG?sec=1853310920&t=ecdf5c04372612896a6a5d483c942e29")
                .showType(AdvertDialog.TYPE_HTTP)
                .show();
                
 //广告监听
 DialogFactory.buildAdvertDialog(this, DialogFactory.DIALOG_ADVERT)
                .url("http://t8.baidu.com/it/u=2063170438,222422588&fm=191&app=48&wm=1,13,90,45,0,7&wmo=10,10&n=0&g=0n&f=JPEG?sec=1853310920&t=ecdf5c04372612896a6a5d483c942e29")
                .showType(AdvertDialog.TYPE_HTTP)
                .setConfirmListener(new ConfirmListener() {
                    @Override
                    public void onClick() {
                        Log.e("TAG","click the advert");
                    }
                }).show();
