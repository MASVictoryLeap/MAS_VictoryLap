package com.example.mas_victoryleap;


import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final ArrayList<String> applicationName;

  private HashMap<String,ApplicationUtilities>ProcessTable;
  
  //constructor
  public listAdapter(Context context, ArrayList<String> values, HashMap<String,ApplicationUtilities> processes) {
    super(context, R.layout.activity_apps_row, values);
    this.context = context;
    applicationName = values;
    ProcessTable=processes;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.activity_apps_row, parent, false);
    
    TextView textView = (TextView) rowView.findViewById(R.id.label);
    TextView app_description = (TextView)rowView.findViewById(R.id.tv_app_description);
    ImageView icon_logo = (ImageView) rowView.findViewById(R.id.icon);

    textView.setText(ProcessTable.get(applicationName.get(position)).getAppName());
    app_description.setText(""+ProcessTable.get(applicationName.get(position)).getMemoryUsage());
  
    
    // display application icon or default icon if application doesnt have an icon
    if(ProcessTable.get(applicationName.get(position)).getAppIcon()!=null){
    	 icon_logo.setImageDrawable(ProcessTable.get(applicationName.get(position)).getAppIcon());
    }
    else
    	icon_logo.setImageResource(R.drawable.android_logo);

    
    return rowView;
  }
  
  
}
