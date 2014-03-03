package com.example.mas_victoryleap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final String[] values;

  public listAdapter(Context context, String[] values) {
    super(context, R.layout.activity_apps_row, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.activity_apps_row, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.label);
    TextView app_description = (TextView)rowView.findViewById(R.id.tv_app_description);
    ImageView icon_logo = (ImageView) rowView.findViewById(R.id.icon);
    textView.setText(values[position]);
    // change the icon for Windows and iPhone
    String s = values[position];
    if (s.startsWith("iPhone")) {
      icon_logo.setImageResource(R.drawable.apple_logo);
      app_description.setText("apple is the best in town");
    } else {
      icon_logo.setImageResource(R.drawable.android_logo);
    }

    return rowView;
  }
  
  
}
