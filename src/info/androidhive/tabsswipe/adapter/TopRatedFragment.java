package info.androidhive.tabsswipe.adapter;

import com.example.mas_victoryleap.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopRatedFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.activity_top_rated, container, false);
         
        return rootView;
    }         
}
