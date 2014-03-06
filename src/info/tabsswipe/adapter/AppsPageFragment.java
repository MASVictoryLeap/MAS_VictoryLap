package info.tabsswipe.adapter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.mas_victoryleap.ApplicationUtilities;
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
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ListFragment;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;

@SuppressLint({ "NewApi", "ValidFragment" })
public class AppsPageFragment extends Fragment implements View.OnClickListener{
	Button buttonPressed;
	//private String[]processList;
	private ArrayList<String>processList;
	private Drawable [] icons;
	TextView title;
	HashMap<String,ApplicationUtilities> tableOfProcess= new HashMap<String,ApplicationUtilities>();
	
	private List<RunningAppProcessInfo> process;
	private ActivityManager activityMan;
	Context context;
	
	
	public AppsPageFragment(Context thisContext){
		context=thisContext;
	}
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
  
        View rootView = inflater.inflate(R.layout.activity_apps_page, container, false);
        Context context=getActivity();
        
        title=(TextView)rootView.findViewById(R.id.title);
		//Activity Manager
		activityMan = (ActivityManager)context.getSystemService(context.ACTIVITY_SERVICE);
		process = activityMan.getRunningAppProcesses();
		PackageManager packMan= context.getPackageManager();
		//processList=new String[process.size()];
		processList=new ArrayList();
		String str=null;
		ApplicationUtilities proc;
		for(int i=0; i<process.size();i++){
			//processList[i]=process.get(i).processName;
			try {
				str=(String) packMan.getApplicationLabel(packMan.getApplicationInfo(process.get(i).processName, PackageManager.GET_META_DATA));
				
				//the String str might retrieve a process that has null Label
				//therefore, must check it before get the icon
				if (str!=null){
					processList.add(str);
					proc= new ApplicationUtilities(context,process.get(i));
					tableOfProcess.put(str, proc);
					
				}
				
			
			} catch (NameNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}
		
		

		
		
		
        
        ListView listview= (ListView)rootView.findViewById(R.id.lv_apps);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, processList); 

                 listview.setAdapter(new listAdapter(getActivity(),processList,tableOfProcess));  
                 
               
                 listview.setOnItemClickListener(new OnItemClickListener() {

                	    @Override             
                	    public void onItemClick(AdapterView<?> parent, View
                	    view, int position, long id) { 
                	    	title.setText("YOU SELECTED "+processList.get(position)+ "AT INDEX:"+position);
                	    	
                	    	
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
