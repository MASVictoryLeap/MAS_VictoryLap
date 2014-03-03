package info.androidhive.tabsswipe.adapter;


import com.example.mas_victoryleap.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

public class AppsPageFragment extends Fragment implements OnClickListener {
	Button buttonPressed;
	
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

    
        View rootView = inflater.inflate(R.layout.activity_apps_page, container, false);
         
        buttonPressed = (Button)rootView.findViewById(R.id.button1);
        final TextView d=(TextView)rootView.findViewById(R.id.textView1);
        buttonPressed.setOnClickListener(this);
	
		
        
        rootView.findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						d.setText("YOU CLIKC THE BUTTON:");
						
					}
				});
        
        
        return rootView;
        
        
        
        
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
	}     
}
