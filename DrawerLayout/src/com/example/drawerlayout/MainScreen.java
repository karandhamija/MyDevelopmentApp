package com.example.drawerlayout;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainScreen extends Activity implements LayoutFragment.FragmentCallback {

	int position = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen_new);
		FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction mTransaction = fragmentManager.beginTransaction();
        mTransaction.add(R.id.textView1, LayoutFragment.newInstance(position + 1)).commit();
        mTransaction = fragmentManager.beginTransaction();
        mTransaction.add(R.id.textView2, LayoutFragment.newInstance(position + 2)).commit();
        mTransaction = fragmentManager.beginTransaction();
        mTransaction.add(R.id.textView3, LayoutFragment.newInstance(position + 3)).commit();

		/*View.OnClickListener mNewListener = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String mTab = "";
				switch(v.getId()){
				case R.id.textView1 :
					mTab = "1";
					break;
				case R.id.textView2 :
					mTab = "2";
					break;
				case R.id.textView3 :
					mTab = "3";
					break;
				case R.id.textView4 :
					mTab = "4";
					break;
				}
				Intent mIntent = new Intent();
				mIntent.setClass(getApplicationContext(), MainActivity.class);
				mIntent.setData(Uri.parse(mTab));
				startActivity(mIntent);
			}
		};
		TextView mView1 = (TextView) findViewById(R.id.textView1);
		mView1.setOnClickListener(mNewListener);
		TextView mView2 = (TextView) findViewById(R.id.textView2);
		mView2.setOnClickListener(mNewListener);
		TextView mView3 = (TextView) findViewById(R.id.textView3);
		mView3.setOnClickListener(mNewListener);
		TextView mView4 = (TextView) findViewById(R.id.textView4);
		mView4.setOnClickListener(mNewListener);*/
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onCallback(int position) {
		// TODO Auto-generated method stub
		Log.v("karan", "onCallback position " + position);
		String mTab = "";
		switch(position){
		case 1 :
			mTab = "1";
			break;
		case 2 :
			mTab = "2";
			break;
		case 3 :
			mTab = "3";
			break;
		default :
			mTab = "4";
			break;
		}
		Intent mIntent = new Intent();
		mIntent.setClass(getApplicationContext(), MainActivity.class);
		mIntent.setData(Uri.parse(mTab));
		startActivity(mIntent);
	}

}