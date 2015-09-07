
package com.example.drawerlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class CriteriaActivity extends AppCompatActivity implements OnClickListener {

    private View fromDateContainter = null;

    private View toDateContainer = null;

    private View fromCityContainter = null;

    private View toCityContainer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_search);
        intiViews();
    }

    private void intiViews() {
        fromDateContainter = findViewById(R.id.lnrFromDate,true);
        toDateContainer = findViewById(R.id.lnrToDate,true);
        fromCityContainter = findViewById(R.id.lnrFromCity,true);
        toCityContainer = findViewById(R.id.lnrToCity,true);

    }
    private View findViewById(int resId,boolean isSetDefaultClickLestener) throws NullPointerException{
        View resultView = null ;
        resultView = findViewById(resId);
        resultView.setOnClickListener(this);
        return resultView;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.criteria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View clickedView) {
        switch (clickedView.getId()) {
            case R.id.lnrFromDate:
                launchCalendarActivity(clickedView);
                break;
            case R.id.lnrToDate:
                launchCalendarActivity(clickedView);
                break;
            case R.id.lnrToCity:
                launchCityPickerActivity(clickedView);
                break;
            case R.id.lnrFromCity:
                launchCityPickerActivity(clickedView);
                break;
            default:
                break;
        }
    }

    public void launchCalendarActivity(View clickedView) {
        Intent newIntent = new Intent(this, DatePickerActivity.class);
        startActivity(newIntent);
    }

    public void launchCityPickerActivity(View clickedView) {
        Intent newIntent = new Intent(this, CityPickerActivity.class);
        startActivity(newIntent);
    }
    
    public static void launchSearchActivity(Context context){
        Intent newIntent = new Intent(context, CriteriaActivity.class);
        context.startActivity(newIntent);
    }
}
