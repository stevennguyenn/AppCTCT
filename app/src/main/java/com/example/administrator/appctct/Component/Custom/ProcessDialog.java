package com.example.administrator.appctct.Component.Custom;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.appctct.Component.Constant.Ints;
import com.example.administrator.appctct.Component.Constant.Strings;
import com.example.administrator.appctct.Interfaces.Dialog.ProcessAlterDialogClick;
import com.example.administrator.appctct.Interfaces.Dialog.ProcessCustomDialogClick;
import com.example.administrator.appctct.R;

public class ProcessDialog implements DialogInterface.OnClickListener, View.OnClickListener {

    private ProcessAlterDialogClick listened;
    private ProcessCustomDialogClick listenedCustom;
    private EditText edCode;
    private static Dialog dialog;

//    public void setListened(ProcessAlterDialogClick listened){
//        this.listened  = listened;
//    }

    public void setListenedCustom(ProcessCustomDialogClick listenedCustom) {
        this.listenedCustom = listenedCustom;
    }

    public void showAlterDialogMessage(Activity activity, String message){
        AlertDialog dialog = new AlertDialog.Builder(activity)
                            .setTitle(Strings.Dialog.title)
                            .setMessage(message)
                            .setPositiveButton(Strings.Dialog.btYes,this)
                            .setNegativeButton(Strings.Dialog.btCancel,this)
                            .show();
    }

    public void showNotification(Activity activity, String message){
        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setTitle(Strings.Dialog.title)
                .setMessage(message)
                .setNegativeButton(Strings.Dialog.btNo,this)
                .show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which){
            case Ints.BUTTON_NEGATIVE:
                dialog.dismiss();
                break;
            case Ints.BUTTON_POSITITE:
                listened.onClickPositive();
                break;
                default:
                    break;
        }
    }

    public void showDialogInputCode(Activity activity) {
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_update_code_ctct);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button yes = dialog.findViewById(R.id.btConfirmDialog);
        edCode = dialog.findViewById(R.id.edInputCode);
        yes.setOnClickListener(this);
        dialog.show();
    }

    static public void dismissCustomDialog(){
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public String getCodeInCustomDialog(){
        return edCode.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btConfirmDialog:
                if (!getCodeInCustomDialog().equals("")) {
                    listenedCustom.onClickPositive(getCodeInCustomDialog());
                    break;
                }
                edCode.setError("Empty");
                break;
                default:
                    break;
        }
    }
}
