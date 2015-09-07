/**
 * 
 */

package com.example.drawerlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author vishal.gaurav@hotmail.com
 */
public class CounterView extends FrameLayout implements OnClickListener {

    public static interface OnCountChangeListener {
        public void onCountChanged(View counterView, int previousCount, int currentCount);
    }

    private static final int DEFAULT_COUNT = 0;

    private static final int DEFAULT_MAX_COUNT = 15;

    private static final int DEFAULT_MIN_COUNT = 0;

    private Context mContext = null;

    private View rlContainer = null;

    private View txtCounterHandleLeft = null;

    private View txtCounterHandleRight = null;
    
    private View txtCounterText = null;


    private OnCountChangeListener countChangeListener = null;

    private int currentCount = DEFAULT_COUNT;

    private int previousCount = DEFAULT_COUNT;

    private int maxCount = DEFAULT_MAX_COUNT;

    private int minCount = DEFAULT_MIN_COUNT;

    /**
     * @param exception message
     */
    private void throwIllegalException(String message) {
        throw new IllegalStateException(message);
    }

    public CounterView(Context context) {
        this(context,null);
        // nothing to do 
    }

    public CounterView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        // nothing to do 
    }

    public CounterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, 0);
        initCounter(context, attrs, defStyleAttr);
    }


    private void initCounter(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        rlContainer = layoutInflater.inflate(R.layout.counter_view, null, false);
        if (rlContainer != null) {
            addView(rlContainer);
            initViews();
            resetCounts();
            updateView();
        } else {
            throwIllegalException("Unable to inflate view root view is null !!");
        }
    }

    private void initViews() {
        txtCounterHandleLeft = rlContainer.findViewById(R.id.txtCounterLeft);
        txtCounterHandleRight = rlContainer.findViewById(R.id.txtCounterRight);
        txtCounterText= rlContainer.findViewById(R.id.txtCounter);
        txtCounterHandleLeft.setOnClickListener(this);
        txtCounterHandleRight.setOnClickListener(this);

    }

    private void updateListener() {
        if (countChangeListener != null) {
            countChangeListener.onCountChanged(this, previousCount, currentCount);
        }
    }

    @Override
    public void onClick(View clickedView) {
        switch (clickedView.getId()) {
            case R.id.txtCounterRight:
                increaseCounterBy(1);
                break;
            case R.id.txtCounterLeft:
                decreaseCounterBy(1);
                break;
            default:
                break;
        }
    }

    private boolean decreaseCounterBy(int decreaseBy) {
        boolean result = false;
        if ((currentCount - decreaseBy) >= minCount) {
            addToCounter(-decreaseBy);
            updateView();
            result = true;
        }
        return result;

    }

    private void updateView() {
        ((TextView) txtCounterText).setText(String.valueOf(currentCount));
    }

    private boolean isCountInRange(int count) {
        return (count >= minCount && count <= maxCount);
    }

    public void resetView() {
        resetCounts();
        updateView();
        // updateListener();
    }

    private void resetCounts() {
        currentCount = DEFAULT_COUNT;
        previousCount = DEFAULT_COUNT;

    }

    public void setOnCountChangeListener(OnCountChangeListener listener) {
        countChangeListener = listener;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getMinCount() {
        return minCount;
    }

    public void setMinCount(int minCount) {
        this.minCount = minCount;
    }

    public OnCountChangeListener getCountChangeListener() {
        return countChangeListener;
    }

    public void setCurrentCount(int count, boolean willListenerBeUpdated) {
        if (isCountInRange(count)) {
            changeCounterTo(count, willListenerBeUpdated);
        } else {
            throwIllegalException("count should be within range. Check maxCount and minCount");
        }

    }

    private boolean increaseCounterBy(int increaseBy) {
        boolean result = false;
        if ((currentCount + increaseBy) <= maxCount) {
            addToCounter(increaseBy);
            updateView();
            result = true;
        }
        return result;
    }

    private void addToCounter(int valueToAdd) {
        previousCount = currentCount;
        currentCount += valueToAdd;
        updateListener();
    }

    private void changeCounterTo(int count, boolean willListenerBeUpdated) {
        previousCount = currentCount;
        currentCount = count;
        if (willListenerBeUpdated) {
            updateListener();
        }
    }
}
