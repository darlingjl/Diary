package com.example.unique.diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

	private int resourceId;

	public ItemAdapter(Context context, int textViewResourceId,
			List<Item> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Item Item = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.ItemWeek = (TextView) view.findViewById(R.id.week);
			viewHolder.ItemName = (TextView) view.findViewById(R.id.Item_name);
			viewHolder.ItemNum = (TextView) view.findViewById(R.id.num);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.ItemWeek.setText(Item.getWeek());
		viewHolder.ItemName.setText(Item.getName());
		viewHolder.ItemNum.setText(String.valueOf(Item.getNum()));
		return view;
	}

	class ViewHolder {

		TextView ItemWeek;
		TextView ItemNum;
		TextView ItemName;

	}

}
