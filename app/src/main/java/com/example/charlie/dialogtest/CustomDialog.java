package com.example.charlie.dialogtest;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.TextView;

/**
 * Created by charlie on 2017. 8. 18..
 */

public class CustomDialog extends Dialog implements View.OnClickListener{
    private static final int LAYOUT = R.layout.dialog_custom;

    private Context context;

    private TextInputEditText nameEt;
    private TextInputEditText emailEt;

    private TextView cancelTv;
    private TextView searchTv;

    private String name;

    public CustomDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public CustomDialog(Context context,String name){
        super(context);
        this.context = context;
        this.name = name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        nameEt = (TextInputEditText) findViewById(R.id.findPwDialogNameEt);
        emailEt = (TextInputEditText) findViewById(R.id.findPwDialogEmailEt);

        cancelTv = (TextView) findViewById(R.id.findPwDialogCancelTv);
        searchTv = (TextView) findViewById(R.id.findPwDialogFindTv);

        cancelTv.setOnClickListener(this);
        searchTv.setOnClickListener(this);

        if(name != null){
            nameEt.setText(name);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.findPwDialogCancelTv:
                cancel();
                break;
            case R.id.findPwDialogFindTv:
                break;
        }
    }
}
