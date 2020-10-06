package com.example.mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        BarChart chart = findViewById(R.id.barchart);

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(1, 2));
        NoOfEmp.add(new BarEntry(2, 4));
        NoOfEmp.add(new BarEntry(3, 6));
        NoOfEmp.add(new BarEntry(4, 3));
        NoOfEmp.add(new BarEntry(5, 6));
        NoOfEmp.add(new BarEntry(6, 2));
        NoOfEmp.add(new BarEntry(7, 9));
        NoOfEmp.add(new BarEntry(8, 3));
        NoOfEmp.add(new BarEntry(9, 8));
        NoOfEmp.add(new BarEntry(10, 4));

        ArrayList year = new ArrayList();

        year.add("2008");
        year.add("2009");
        year.add("2010");
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");

        BarDataSet bardataset = new BarDataSet(NoOfEmp, "No Of Employee");
        chart.animateY(5000);
        BarData data = new BarData(bardataset,bardataset );
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);
    }
}
