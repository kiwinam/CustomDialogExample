package com.example.charlie.dialogtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                CustomDialog dialog = new CustomDialog(this);
                dialog.show();
                break;
        }
    }
}
