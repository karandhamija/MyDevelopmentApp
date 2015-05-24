package com.example.drawerlayout;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class LayoutFragment extends Fragment {

	FragmentCallback mCallBack;
	
	public interface FragmentCallback {
		
		public void onCallback(int posion);
	}

	private static final String ARG_SECTION_NUMBER = "section_number";
    
    private static int mSectionNumber = 0;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LayoutFragment newInstance(int sectionNumber) {
    	LayoutFragment fragment = new LayoutFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        mSectionNumber = sectionNumber;
        fragment.setArguments(args);
        return fragment;
    }

    public LayoutFragment() {
    }
 
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity); 
		try {
			mCallBack = (FragmentCallback) activity;				
		}catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement mCallBack");
        }
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = null;
		mSectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
		Log.v("karan", "mSectionNumber is " + mSectionNumber);
		rootView = inflater.inflate(R.layout.fragment_layout, container, false);
		
		TextView mTextView = (TextView) rootView.findViewById(R.id.textView1);
		String text = "";

		switch(mSectionNumber){
			case 1: 
				text = "Flights";
				break;
			case 2: 
				text = "Hotels";
				break;
			case 3: 
				text = "Buses";
				break;
			case 4: 
				text = "Settings";
				break;
				
		}
		Log.v("karan", "text is " + text);
		mTextView.setText(text);
		((View) mTextView.getParent()).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.v("karan", "OnClick");
				// TODO Auto-generated method stub
				int mnum = getArguments().getInt(ARG_SECTION_NUMBER);;
				mCallBack.onCallback(mnum);
			}
		});
		return rootView;
	}
	
}