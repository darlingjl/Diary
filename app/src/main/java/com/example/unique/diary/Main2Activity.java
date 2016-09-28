package com.example.unique.diary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 目标Activity，接收Activity传入值并回传值给源Activity
 * */
public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        initView();
    }

    /**
     * 初始化控件信息
     * */
    private void initView(){
        //接收Activity传过来的值
        final Intent data = getIntent();
        final EditText edit_text=(EditText)findViewById(R.id.combined_edit_text) ;

        Button btn_rs_skip = (Button) findViewById(R.id.button2);
        btn_rs_skip.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {//采用Intent绑定Bundle的形式回传值
                //新建一个Bundle，Bundle主要放值类型
                Bundle bundle = new Bundle();
                String input=edit_text.getText().toString();
                bundle.putString("rs", input);
                //将Bundle赋给Intent
                data.putExtras(bundle);
                //跳转回MainActivity
               setResult(RESULT_OK, data);
                //关闭当前activity
                finish();
            }
        });
    }
}