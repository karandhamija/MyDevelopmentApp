package com.example.drawerlayout;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainScreen extends Activity implements FragmentCallback {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainscreen_new);
		FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction mTransaction = fragmentManager.beginTransaction();
        mTransaction.add(R.id.textView1, LayoutFragment.newInstance()).commit();
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
//		Intent mIntent = new Intent();
//		mIntent.setClass(getApplicationContext(), MainActivity.class);
//		mIntent.setData(Uri.parse(mTab));
//		startActivity(mIntent);
		CriteriaActivity.launchSearchActivity(MainScreen.this);
	}

}