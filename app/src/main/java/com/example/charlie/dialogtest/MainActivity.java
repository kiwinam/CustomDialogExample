package com.example.charlie.dialogtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int LAYOUT = R.layout.activity_main;

    private EditText nameEt;
    private Button showDialogBtn;


    private TextView resultNameTv;
    private TextView resultEmailTv;

    private String requestName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        nameEt = (EditText) findViewById(R.id.nameEt);
        showDialogBtn = (Button) findViewById(R.id.showDialogBtn);
        resultNameTv = (TextView) findViewById(R.id.resultNameTv);
        resultEmailTv = (TextView) findViewById(R.id.resultEmailTv);

        showDialogBtn.setOnClickListener(this); // Set click Listener
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showDialogBtn:
                requestName = nameEt.getText().toString();
                CustomDialog dialog = new CustomDialog(this,requestName);
                dialog.setDialogListener(new MyDialogListener() {  // MyDialogListener 를 구현
                    @Override
                    public void onPositiveClicked(String email, String name) {
                        setResult(email,name);
                    }

                    @Override
                    public void onNegativeClicked() {
                        Log.d("MyDialogListener","onNegativeClicked");
                    }
                });
                dialog.show();
                break;
        }
    }

    private void setResult(String email,String name){
        resultEmailTv.setText(email);
        resultNameTv.setText(name);
    }
}
