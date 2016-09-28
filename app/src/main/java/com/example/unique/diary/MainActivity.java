package com.example.unique.diary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
	private TextView tv_main_result = null;
	private List<Item> ItemList = new ArrayList<>();
   private final int requestCode = 1500;
	private ItemAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initItem();
        initView();

		adapter=new ItemAdapter(MainActivity.this,R.layout.item,ItemList);
		ListView listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				Item Item = ItemList.get(position);
				Toast.makeText(MainActivity.this, Item.getName(),
						Toast.LENGTH_SHORT).show();
			}
		});

	}
	public void initView(){

		Button btn_main_skip = (Button) findViewById(R.id.button);
		btn_main_skip.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,Main2Activity.class);
				//采用Intent普通传值的方式
				//跳转Activity
				startActivityForResult(intent, requestCode);
			}
		});
}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch(resultCode){
			case RESULT_OK:{//接收并显示Activity传过来的值
				String rs = data .getStringExtra("rs");
				Item a=new Item("","Mon",1);
				a.setname(rs);
				ItemList.set(0,a);
				adapter.notifyDataSetChanged();
				break;
			}
			default:
				break;
		}
	}


	private void initItem() {
		Item a = new Item(" ","Mon",1);
		ItemList.add(a);
		Item b = new Item(" ","Tue",2);
		ItemList.add(b);
		Item c = new Item(" ","Wed",3);
		ItemList.add(c);
		Item d = new Item(" ","Thur",4);
		ItemList.add(d);
		Item e = new Item(" ","Fri",5);
		ItemList.add(e);
		Item f = new Item(" ","Sat",6);
		ItemList.add(f);
		Item g = new Item(" ","Sun",7);
		ItemList.add(g);
		Item h = new Item(" ","Mon",8);
		ItemList.add(h);
	}

}
