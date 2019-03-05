package com.project.hanlonglin.handialog.dialog;

import android.content.Context;

import com.project.hanlonglin.handialog.R;

/**
 * Created by hanlonglin on 2018/12/13.
 */

public class DialogFactory {
    //dialog类型
    public final static int DIALOG_SUCCESS = 0;
    public final static int DIALOG_SUCCESS_CANCEL = 1;
    public final static int DIALOG_FAIL = 2;
    public final static int DIALOG_FAIL_CANCEL = 3;
    public final static int DIALOG_WARNING = 4;
    public final static int DIALOG_WARNING_CANCEL = 5;

    public final static int DIALOG_CONFIRM = 6;

    public final static int DIALOG_ADVERT = 7;

    public final static int DIALOG_LIST = 8;

    public final static int DIALOG_HELP = 9;

    public static AlertDialog buildAlertDialog(Context context, int type) {
        AlertDialog dialog = null;
        switch (type) {
            case DIALOG_SUCCESS:
                dialog = createSuccessDialog(context);
                break;
            case DIALOG_SUCCESS_CANCEL:
                dialog = createSuccessCancelDialog(context);
                break;
            case DIALOG_FAIL:
                dialog = createFailDialog(context);
                break;
            case DIALOG_FAIL_CANCEL:
                dialog = createFailCancelDialog(context);
                break;
            case DIALOG_WARNING:
                dialog = createWarningDialog(context);
                break;
            case DIALOG_WARNING_CANCEL:
                dialog = createWarningCancelDialog(context);
                break;
        }

        return dialog;
    }

    public static ConfirmDialog buildConfirmDialog(Context context, int type) {
        ConfirmDialog dialog = null;
        switch (type) {
            case DIALOG_CONFIRM:
                dialog = createConfirmDialog(context);
                break;
        }
        return dialog;
    }
    public static ConfirmDialog buildConfirmDialog(Context context) {
        return buildConfirmDialog(context,DIALOG_CONFIRM);
    }


    public static AdvertDialog buildAdvertDialog(Context context, int type) {
        AdvertDialog dialog = null;
        switch (type) {
            case DIALOG_ADVERT:
                dialog = createAdvertDialog(context);
                break;
        }
        return dialog;
    }
    public static AdvertDialog buildAdvertDialog(Context context) {
        return buildAdvertDialog(context,DIALOG_ADVERT);
    }

    public static ListDialog buildListDialog(Context context, int type) {
        ListDialog dialog = null;
        switch (type) {
            case DIALOG_LIST:
                dialog = createListDialog(context);
                break;
        }
        return dialog;
    }
    public static ListDialog buildListDialog(Context context) {
        return buildListDialog(context,DIALOG_LIST);
    }

    public static HelpDialog buildHelpDialog(Context context, int type) {
        HelpDialog dialog = null;
        switch (type) {
            case DIALOG_HELP:
                dialog = createHelpDialog(context);
                break;
        }
        return dialog;
    }
    public static HelpDialog buildHelpDialog(Context context){
        return buildHelpDialog(context,DIALOG_HELP);
    }

    private static HelpDialog createHelpDialog(Context context) {
        return new HelpDialog(context)
                .message("请问有什么需要帮助的吗？");
    }

    private static ListDialog createListDialog(Context context) {
        return new ListDialog(context).title("列表");
    }

    private static AdvertDialog createAdvertDialog(Context context) {
        return new AdvertDialog(context);
    }

    private static ConfirmDialog createConfirmDialog(Context context) {
        return new ConfirmDialog(context)
                .title("确认？")
                .message("确认执行操作？");
    }

    private static AlertDialog createSuccessDialog(Context context) {
        return new AlertDialog(context)
                .title("成功")
                .messsage("操作成功")
                .showCancel(false);
    }

    private static AlertDialog createSuccessCancelDialog(Context context) {
        return new AlertDialog(context)
                .title("成功")
                .messsage("操作成功")
                .showCancel(true);
    }

    private static AlertDialog createFailDialog(Context context) {
        return new AlertDialog(context)
                .title("失败")
                .messsage("操作失败")
                .icon(R.drawable.handialog_fail)
                .animtype(AlertDialog.TYPE_FAIL)
                .showCancel(false);
    }

    private static AlertDialog createFailCancelDialog(Context context) {
        return new AlertDialog(context)
                .title("失败")
                .messsage("操作失败")
                .icon(R.drawable.handialog_fail)
                .animtype(AlertDialog.TYPE_FAIL)
                .showCancel(true);
    }

    private static AlertDialog createWarningDialog(Context context) {
        return new AlertDialog(context)
                .title("警告")
                .messsage("出现异常")
                .icon(R.drawable.handialog_warn)
                .animtype(AlertDialog.TYPE_WARN)
                .showCancel(false);
    }

    private static AlertDialog createWarningCancelDialog(Context context) {
        return new AlertDialog(context)
                .title("警告")
                .messsage("出现异常")
                .icon(R.drawable.handialog_warn)
                .animtype(AlertDialog.TYPE_WARN)
                .showCancel(true);
    }
}
