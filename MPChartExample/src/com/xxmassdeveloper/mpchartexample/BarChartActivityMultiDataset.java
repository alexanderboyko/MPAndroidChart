
package com.xxmassdeveloper.mpchartexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;

import java.util.ArrayList;
import java.util.Random;

public class BarChartActivityMultiDataset extends DemoBase implements OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private BarChart mChart;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_barchart);

        tvX = (TextView) findViewById(R.id.tvXMax);
        tvX.setTextSize(10);
        tvY = (TextView) findViewById(R.id.tvYMax);

        mSeekBarX = (SeekBar) findViewById(R.id.seekBar1);
        mSeekBarX.setOnSeekBarChangeListener(this);

        mSeekBarY = (SeekBar) findViewById(R.id.seekBar2);
        mSeekBarY.setOnSeekBarChangeListener(this);

        mChart = (BarChart) findViewById(R.id.chart1);
//        mChart.setOnChartValueSelectedListener(this);
//        mChart.getDescription().setEnabled(false);

//        mChart.setDrawBorders(true);

        // scaling can now only be done on x- and y-axis separately
//        mChart.setPinchZoom(false);
//
//        mChart.setDrawBarShadow(false);
//
//        mChart.setDrawGridBackground(false);
//
//        // create a custom MarkerView (extend MarkerView) and specify the layout
//        // to use for it
//        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
//        mv.setChartView(mChart); // For bounds control
//        mChart.setMarker(mv); // Set the marker to the chart
//
//        mSeekBarX.setProgress(10);
//        mSeekBarY.setProgress(100);
//
//        Legend l = mChart.getLegend();
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l.setOrientation(Legend.LegendOrientation.VERTICAL);
//        l.setDrawInside(true);
//        l.setTypeface(mTfLight);
//        l.setYOffset(0f);
//        l.setXOffset(10f);
//        l.setYEntrySpace(0f);
//        l.setTextSize(8f);
//
//        XAxis xAxis = mChart.getXAxis();
//        xAxis.setTypeface(mTfLight);
//        xAxis.setGranularity(1f);
//        xAxis.setCenterAxisLabels(true);
//        xAxis.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return String.valueOf((int) value);
//            }
//        });
//
//        YAxis leftAxis = mChart.getAxisLeft();
//        leftAxis.setTypeface(mTfLight);
//        leftAxis.setValueFormatter(new LargeValueFormatter());
//        leftAxis.setDrawGridLines(false);
//        leftAxis.setSpaceTop(35f);
//        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//
//        mChart.getAxisRight().setEnabled(false);

        mChart.setPinchZoom(false);
        mChart.setScaleEnabled(false);
        mChart.setDoubleTapToZoomEnabled(false);
        mChart.setDrawGridBackground(false);
        mChart.setDragEnabled(true);
        //todo change no data text
        mChart.setNoDataText("No data");
        mChart.getLegend().setEnabled(false);
        mChart.setDragOffsetX(25f);
        mChart.getDescription().setEnabled(false);
        mChart.getDescription().setText("");
        mChart.getAxisRight().setDrawLabels(false);
        mChart.getAxisRight().setEnabled(false);
        mChart.setClipValuesToContent(false);
        mChart.animateY(400);
        mChart.setHighlightFullBarEnabled(false);
        mChart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {

            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {
                Log.d("DRAG", "onChartTranslate: " + dX + " " + dY);
            }
        });


        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setCenterAxisLabels(true);
        xAxis.setValueFormatter((value, axis) -> String.valueOf((int) value));
        xAxis.setYOffset(30f);
        //todo set date dynamically
        xAxis.setDate("Apr 2018");
        xAxis.setTextSize(13f);
        //xAxis.setTextColor(ContextCompat.getColor(this, R.color.textColorDarkSecondary));
        //xAxis.setTypeface(ResourcesCompat.getFont(this, R.font.serifa_std_light));

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setGranularity(3.33f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setAxisMaximum(10f);
        leftAxis.setTextSize(12f);
        //leftAxis.setTypeface(ResourcesCompat.getFont(this, R.font.serifa_std_light));
        leftAxis.mAxisRange = 10f;
        leftAxis.setLabelCount(3);
        leftAxis.setValueFormatter((value, axis) -> {
            if (value == 3.33f) return "Improve";
            if (value == 6.66f) return "Reflect";
            if (value == 9.99f) return "Maintain";
            return "";
        });
        leftAxis.setDrawGridLines(true);
        //leftAxis.setAxisLineColor(ContextCompat.getColor(this, R.color.chartGridColor));
        //leftAxis.setGridColor(ContextCompat.getColor(this, R.color.chartGridColor));
        //.setmGridLabelsColor(ContextCompat.getColor(this, R.color.stats_background));
        leftAxis.setCenterAxisLabels(true);
        leftAxis.setYOffset(35f);
        leftAxis.setXOffset(25f);

        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<BarEntry> entries1 = new ArrayList<>();
        ArrayList<BarEntry> entries2 = new ArrayList<>();

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 30; i++) {
            entries.add(new BarEntry(i, random.nextInt(10)));
            entries1.add(new BarEntry(i, random.nextInt(10)));
            entries2.add(new BarEntry(i, random.nextInt(10)));
        }

        BarDataSet barDataSet = new BarDataSet(entries, "dfff");
        barDataSet.setHighlightEnabled(false);
        barDataSet.setDrawValues(false);
        barDataSet.setColor(Color.RED);
        BarDataSet barDataSet1 = new BarDataSet(entries1, "dfff1");
        barDataSet1.setHighlightEnabled(false);
        barDataSet1.setDrawValues(false);
        barDataSet1.setColor(Color.BLUE);
        BarDataSet barDataSet2 = new BarDataSet(entries2, "dfff2");
        barDataSet2.setHighlightEnabled(false);
        barDataSet2.setDrawValues(false);
        barDataSet2.setColor(Color.GREEN);

        BarData barData = new BarData(barDataSet, barDataSet1, barDataSet2);

        mChart.setData(barData);

        float groupSpace = 0.34f;
        float barSpace = 0.07f; // x3 DataSet
        float barWidth = 0.15f; // x3 DataSet

        mChart.getBarData().setBarWidth(barWidth);
        xAxis.setAxisMinimum(0);

        mChart.setVisibleXRange(4f, 5f);
        mChart.setVisibleYRangeMinimum(10f, YAxis.AxisDependency.LEFT);
        mChart.setVisibleYRangeMaximum(10f, YAxis.AxisDependency.LEFT);
        mChart.getBarData().groupBars(0, groupSpace, barSpace);
        mChart.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionToggleValues: {
                for (IBarDataSet set : mChart.getData().getDataSets())
                    set.setDrawValues(!set.isDrawValuesEnabled());

                mChart.invalidate();
                break;
            }
            case R.id.actionTogglePinch: {
                if (mChart.isPinchZoomEnabled())
                    mChart.setPinchZoom(false);
                else
                    mChart.setPinchZoom(true);

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleAutoScaleMinMax: {
                mChart.setAutoScaleMinMaxEnabled(!mChart.isAutoScaleMinMaxEnabled());
                mChart.notifyDataSetChanged();
                break;
            }
            case R.id.actionToggleBarBorders: {
                for (IBarDataSet set : mChart.getData().getDataSets())
                    ((BarDataSet) set).setBarBorderWidth(set.getBarBorderWidth() == 1.f ? 0.f : 1.f);

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleHighlight: {
                if (mChart.getData() != null) {
                    mChart.getData().setHighlightEnabled(!mChart.getData().isHighlightEnabled());
                    mChart.invalidate();
                }
                break;
            }
            case R.id.actionSave: {
                // mChart.saveToGallery("title"+System.currentTimeMillis());
                mChart.saveToPath("title" + System.currentTimeMillis(), "");
                break;
            }
            case R.id.animateX: {
                mChart.animateX(3000);
                break;
            }
            case R.id.animateY: {
                mChart.animateY(3000);
                break;
            }
            case R.id.animateXY: {
                mChart.animateXY(3000, 3000);
                break;
            }
        }
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        float groupSpace = 0.08f;
        float barSpace = 0.03f; // x4 DataSet
        float barWidth = 0.2f; // x4 DataSet
        // (0.2 + 0.03) * 4 + 0.08 = 1.00 -> interval per "group"

        int groupCount = mSeekBarX.getProgress() + 1;
        int startYear = 1980;
        int endYear = startYear + groupCount;

        tvX.setText(startYear + "-" + endYear);
        tvY.setText("" + (mSeekBarY.getProgress()));

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals4 = new ArrayList<BarEntry>();

        float randomMultiplier = mSeekBarY.getProgress() * 100000f;

        for (int i = startYear; i < endYear; i++) {
            yVals1.add(new BarEntry(i, (float) (Math.random() * randomMultiplier)));
            yVals2.add(new BarEntry(i, (float) (Math.random() * randomMultiplier)));
            yVals3.add(new BarEntry(i, (float) (Math.random() * randomMultiplier)));
            yVals4.add(new BarEntry(i, (float) (Math.random() * randomMultiplier)));
        }

        BarDataSet set1, set2, set3, set4;

        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {

            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet) mChart.getData().getDataSetByIndex(1);
            set3 = (BarDataSet) mChart.getData().getDataSetByIndex(2);
            set4 = (BarDataSet) mChart.getData().getDataSetByIndex(3);
            set1.setValues(yVals1);
            set2.setValues(yVals2);
            set3.setValues(yVals3);
            set4.setValues(yVals4);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();

        } else {
            // create 4 DataSets
            set1 = new BarDataSet(yVals1, "Company A");
            set1.setColor(Color.rgb(104, 241, 175));
            set2 = new BarDataSet(yVals2, "Company B");
            set2.setColor(Color.rgb(164, 228, 251));
            set3 = new BarDataSet(yVals3, "Company C");
            set3.setColor(Color.rgb(242, 247, 158));
            set4 = new BarDataSet(yVals4, "Company D");
            set4.setColor(Color.rgb(255, 102, 0));

            BarData data = new BarData(set1, set2, set3, set4);
            data.setValueFormatter(new LargeValueFormatter());
            data.setValueTypeface(mTfLight);

            mChart.setData(data);
        }

        // specify the width each bar should have
        mChart.getBarData().setBarWidth(barWidth);

        // restrict the x-axis range
        mChart.getXAxis().setAxisMinimum(startYear);

        // barData.getGroupWith(...) is a helper that calculates the width each group needs based on the provided parameters
        mChart.getXAxis().setAxisMaximum(startYear + mChart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        mChart.groupBars(startYear, groupSpace, barSpace);
        mChart.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.i("Activity", "Selected: " + e.toString() + ", dataSet: " + h.getDataSetIndex());
    }

    @Override
    public void onNothingSelected() {
        Log.i("Activity", "Nothing selected.");
    }
}
