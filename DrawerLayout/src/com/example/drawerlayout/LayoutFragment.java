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

	View.OnClickListener mNewClickListener = new View.OnClickListener() {
		
		@Override
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int mnum = 0;
			switch(Integer.parseInt((String) v.getTag())){
			
			case 1:
				mnum = 1;
				break;
			case 2:
				mnum = 2;
				break;
			case 3:
				mnum = 3;
				break;
			}
			mCallBack.onCallback(mnum);
		}
	};

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static LayoutFragment newInstance() {
    	LayoutFragment fragment = new LayoutFragment();
        /*Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        mSectionNumber = sectionNumber;
        fragment.setArguments(args);*/
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
		rootView = inflater.inflate(R.layout.fragment_layout, container, false);

		TextView mView1 = (TextView) rootView.findViewById(R.id.textView1);
		mView1.setOnClickListener(mNewClickListener);
		TextView mView2 = (TextView) rootView.findViewById(R.id.textView2);
		mView2.setOnClickListener(mNewClickListener);
		TextView mView3 = (TextView) rootView.findViewById(R.id.textView3);
		mView3.setOnClickListener(mNewClickListener);
		return rootView;
	}

	
}