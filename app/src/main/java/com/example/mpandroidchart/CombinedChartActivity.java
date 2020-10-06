package com.example.mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CombinedChartActivity extends AppCompatActivity {
    private CombinedChart chart;
    private Integer count = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combined_chart);

        chart = findViewById(R.id.chart1);
        chart.getDescription().setEnabled(false);
        chart.setBackgroundColor(Color.WHITE);
        chart.setDrawGridBackground(false);
        chart.setDrawBarShadow(false);
        chart.setHighlightFullBarEnabled(false);

        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setAxisMinimum(-0.75f);
        xAxis.setAxisLineColor(Color.RED);
        xAxis.setGranularity(1f);


        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return months[(int) value % months.length];
            }
        });

        CombinedData data = new CombinedData();

        data.setData(generateLineData());
        data.setData(generateBarData());
//        Test 02/10
//        data.setData(generateBarData2());
        xAxis.setAxisMaximum(data.getXMax());
        chart.animateY(3000);
        chart.animateX(3000);
        xAxis.setAxisMaximum(data.getXMax() + 0.75f);
        chart.setData(data);
        chart.invalidate();
        chart.setOnChartGestureListener(new OnChartGestureListener() {
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
                Toast.makeText(CombinedChartActivity.this, ""+me.getX()+" me "+ me.getY()+" --"+dX+" --" + dY, Toast.LENGTH_SHORT).show();

            }
        });
        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
//                Toast.makeText(CombinedChartActivity.this, "ok"+e.getX() +"---"+e.getY()+"*--"+h.getX()+"*---"+h.getY(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }


    Random ran = new Random();
    int x = ran.nextInt(1) + 1;

    protected float getRandom(float range, float start) {
        return (float) (Math.random() * range) + start;
    }

    private LineData generateLineData() {

        LineData d = new LineData();

        ArrayList<Entry> entries = new ArrayList<>();

//        for (int index = 0; index < count; index++)
//            entries.add(new Entry(index ,index,2));
        entries.add(new Entry(0, getRandom(5, 2)));
        entries.add(new Entry(1, getRandom(5, 2)));
        entries.add(new Entry(2, getRandom(5, 2)));
        entries.add(new Entry(3, getRandom(5, 2)));
        entries.add(new Entry(4, getRandom(5, 2)));
        entries.add(new Entry(5, getRandom(5, 2)));
        entries.add(new Entry(6, getRandom(5, 2)));
        entries.add(new Entry(7, getRandom(5, 2)));
        entries.add(new Entry(8, getRandom(5, 2)));
        entries.add(new Entry(9, getRandom(5, 2)));
        entries.add(new Entry(10, getRandom(5, 2)));
//        entries.add(new Entry(11,getRandom(10,2)));
//        entries.add(new Entry(12,getRandom(10,2)));
//        entries.add(new Entry(13,getRandom(10,2)));
//        entries.add(new Entry(14,getRandom(10,2)));
//        entries.add(new Entry(15,getRandom(10,2)));
//        entries.add(new Entry(16,getRandom(10,2)));
//        entries.add(new Entry(17,getRandom(10,2)));
//        entries.add(new Entry(18,getRandom(10,2)));
//        entries.add(new Entry(19,getRandom(10,2)));
//        entries.add(new Entry(20,getRandom(10,2)));
//        entries.add(new Entry(21,getRandom(10,2)));
//        entries.add(new Entry(22,getRandom(10,2)));
//        entries.add(new Entry(23,getRandom(10,2)));
        LineDataSet set = new LineDataSet(entries, "Số lượng thẻ đã bán");
        set.setColor(Color.rgb(240, 238, 70));
        set.setLineWidth(1f);
        set.setCircleColor(Color.rgb(240, 238, 70));
        set.setCircleRadius(5f);
        set.setFillColor(Color.rgb(240, 238, 70));
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.rgb(240, 238, 70));

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return d;
    }

    private BarData generateBarData() {

        ArrayList<BarEntry> entries1 = new ArrayList<>();
        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(0, getRandom(5, 2)));
        group1.add(new BarEntry(1, getRandom(5, 2)));
        group1.add(new BarEntry(2, getRandom(5, 2)));
        group1.add(new BarEntry(3, getRandom(5, 2)));
        group1.add(new BarEntry(4, getRandom(5, 2)));
        group1.add(new BarEntry(5, getRandom(5, 2)));
        group1.add(new BarEntry(6, getRandom(5, 2)));
        group1.add(new BarEntry(7, getRandom(5, 2)));
        group1.add(new BarEntry(8, getRandom(5, 2)));
        group1.add(new BarEntry(9, getRandom(5, 2)));
        group1.add(new BarEntry(10, getRandom(5, 2)));
//        group1.add(new BarEntry(11,getRandom(10,2)));
//        group1.add(new BarEntry(12,getRandom(10,2)));
//        group1.add(new BarEntry(13,getRandom(10,2)));
//        group1.add(new BarEntry(14,getRandom(10,2)));
//        group1.add(new BarEntry(15,getRandom(10,2)));
//        group1.add(new BarEntry(16,getRandom(10,2)));
//        group1.add(new BarEntry(17,getRandom(10,2)));
//        group1.add(new BarEntry(18,getRandom(10,2)));
//        group1.add(new BarEntry(19,getRandom(10,2)));
//        group1.add(new BarEntry(20,getRandom(10,2)));
//        group1.add(new BarEntry(21,getRandom(10,2)));
//        group1.add(new BarEntry(22,getRandom(10,2)));
//        group1.add(new BarEntry(23,getRandom(10,2)));
        ArrayList<BarEntry> entries2 = new ArrayList<>();

//        for (int index = 0; index < count; index++) {
//            entries1.add(new BarEntry(0, getRandom(25, 25)));

        // stacked
//            entries2.add(new BarEntry(0, new float[]{getRandom(13, 12), getRandom(13, 12)}));
//        }

//
//        BarDataSet set1 = new BarDataSet(entries1, "Bar 1");
////        set1.setColor(Color.rgb(60, 220, 78));
////        set1.setValueTextColor(Color.rgb(60, 220, 78));
////        set1.setValueTextSize(1f);
////        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
//        BarDataSet set2 = new BarDataSet(entries2, "Bar 1");
//        set1.setColor(Color.rgb(60, 220, 78));
//        set1.setValueTextColor(Color.rgb(60, 220, 78));
//        set1.setValueTextSize(10f);
//        BarDataSet set2 = new BarDataSet(entries2, "");
//        set2.setStackLabels(new String[]{"Stack 1", "Stack 2"});
//        set2.setColors(Color.rgb(61, 165, 255), Color.rgb(23, 197, 255));
//        set2.setValueTextColor(Color.rgb(61, 165, 255));
//        set2.setValueTextSize(10f);
//        set2.setAxisDependency(YAxis.AxisDependency.LEFT);

        float groupSpace = 0.1f;
        float barSpace = 0.4f; // x2 dataset
        float barWidth = 0.45f; // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"

//        BarData d = new BarData(set1, set1);
//        BarData d = new BarData(set1, set1);
//        d.setBarWidth(barWidth);

        // make this BarData object grouped
        BarDataSet barDataSet = new BarDataSet(group1, "Doang số bán thẻ");
        barDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
//        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setColor(Color.rgb(60, 220, 78));
        barDataSet.setValueTextColor(Color.rgb(60, 220, 78));
        barDataSet.setValueTextSize(10);

        BarData barData = new BarData(barDataSet);
        barData.setValueTextSize(10f);
        barData.setBarWidth(0.9f);

        barDataSet.setValueTextColor(Color.BLACK);
        return barData;
//        return d;
    }

    private BarData generateBarData2() {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));
        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        return data;
    }

    protected final String[] months = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Agu", "May"
    };

    protected final String[] parties = new String[]{
            "Party A", "Party B", "Party C", "Party D", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };
}