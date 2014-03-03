package info.androidhive.tabsswipe.adapter;


import com.example.mas_victoryleap.LoginActivity;
import com.example.mas_victoryleap.R;
import com.example.mas_victoryleap.listAdapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;

@SuppressLint("NewApi")
public class AppsPageFragment extends Fragment implements View.OnClickListener{
	Button buttonPressed;
	static final String[] items = 
            new String[] { "Android", "iPhone", "WindowsMobile", "Blackberry","item2","item3",
            		"item4","item5","item6","item67","item533","3432","34234","4322221"};
	TextView title;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
  
        View rootView = inflater.inflate(R.layout.activity_apps_page, container, false);
        title=(TextView)rootView.findViewById(R.id.title);
        
        
        
        ListView listview= (ListView)rootView.findViewById(R.id.lv_apps);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items); 

                 listview.setAdapter(new listAdapter(getActivity(),items));  
                 
               
                 listview.setOnItemClickListener(new OnItemClickListener() {

                	    @Override             
                	    public void onItemClick(AdapterView<?> parent, View
                	    view, int position, long id) { 
                	    	title.setText("YOU SELECTED "+ position);
                	    	
                	    	
                	    }
                	});
                 
        /**
        //BUTTON
        buttonPressed = (Button)rootView.findViewById(R.id.button1);
        final TextView d=(TextView)rootView.findViewById(R.id.textView1);
        buttonPressed.setOnClickListener(this);
        final Context context=getActivity();
       
		//setListAdapter(new listAdapter(context, MOBILE_OS));
        
        rootView.findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						//d.setText("YOU CLIKC THE BUTTON:");
						AlertDialog.Builder alert = new AlertDialog.Builder(context);
						alert.setTitle(getString(R.string.promp_error));
						alert.setMessage("YOU CLICK BUTTON");
						alert.setPositiveButton("OK",
								  new DialogInterface.OnClickListener() {
								    public void onClick(DialogInterface dialog,int id) {
									dialog.cancel(); } });
						alert.show();
					}
				});
        **/
        
        return rootView;
        
        
        
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		
		
	}     
}
