//package com.example.diabetescalc;
//
//import android.app.DatePickerDialog;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.DatePicker;
//import android.widget.TextView;
//
//import com.github.mikephil.charting.data.BarEntry;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * Created by spike on 2/20/2016.
// */
//public class TerrysChart extends baseActivity {
//    ArrayList<Entry> entries = new ArrayList<>();
//    ArrayList<String> labels = new ArrayList<String>();
//    private Calendar c = Calendar.getInstance();
//    TextView edtStartDate;
//    TextView edtEndDate;
//    Date startdate;
//    Date enddate;
//    LineChart chart;
//
//    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            c.set(Calendar.YEAR, year);
//            c.set(Calendar.MONTH, monthOfYear);
//            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            setCurrentDateOnView();
//
//        }
//
//    };
//    DatePickerDialog.OnDateSetListener EndDate = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            c.set(Calendar.YEAR, year);
//            c.set(Calendar.MONTH, monthOfYear);
//            c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//            setEndDateOnView();
//
//        }
//
//    };
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.terrysview);
//        chart = (LineChart) findViewById(R.id.chartViewID);
//        edtStartDate = (TextView) findViewById(R.id.edtStartDate);
//        edtEndDate = (TextView) findViewById(R.id.edtEndDate);
//        showChart();
//    }
//
//    private void showChart() {
//        chart.clear();
//        entries.clear();
//        labels.clear();
//        readBloodLog();
//        LineDataSet dataSet = new LineDataSet(entries, "Blood Sugar");
//
//        // setContentView(chart);
//        LineData data = new LineData(labels, dataSet);
//        chart.setData(data);
//    }
//
//
//    public void ChartdateonClick(View v) {
//        new DatePickerDialog(this, date, c.get(Calendar.YEAR),
//                c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
//    }
//    public void ChartEnddateonClick(View v) {
//        new DatePickerDialog(this, EndDate, c.get(Calendar.YEAR),
//                c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
//    }
//
//    private void setCurrentDateOnView() {
//        //String dateFormat =  "MM/dd/yyyy";
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
//        edtStartDate.setText(sdf.format(c.getTime()));
//        startdate = c.getTime();
//        showChart();
//    }
//
//    public void setEndDateOnView() {
//        //String dateFormat =  "MM/dd/yyyy";
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
//        edtEndDate.setText(sdf.format(c.getTime()));
//        enddate = c.getTime();
//        showChart();
//    }
//
//    public boolean compareDay(Date day1, Date day2){
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
//        String formatatedDay1 = sdf.format(day1);
//        String formatatedDay2 = sdf.format(day2);
//        return formatatedDay1.equals(formatatedDay2);
//    }
//
//
//    private void readBloodLog(){
//        FileInputStream inputStream = null;
//
//        try {
//            inputStream = openFileInput( BloodSugarFileName );
//            byte[]  rawData = new byte[ inputStream.available()];
//            while (inputStream.read( rawData ) != -1 ){
//            }
//            // raw data holds the entire log file
//            Scanner s = new Scanner( new String (rawData) );
//            s.useDelimiter( "\\n" );
//            int count = 0;
//            while ( s.hasNext() ){
//                String temp = s.next();
//                String a[] = temp.split(delimiter);
//                System.out.println(a[0]);
//                String GraphDate = a[0];
//                DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//                Date gDate = format.parse(GraphDate);
//                Date fDate = format.parse(GraphDate);
//                System.out.println(gDate);
//
//                if (startdate != null) {
//                    System.out.println(gDate.compareTo(startdate));
//                    if(gDate.after(startdate) || compareDay(startdate, gDate)  ){
//                        try {
//                            entries.add( new BarEntry( Float.parseFloat( a[2]), count ));
//                            count += 1;
//                            //x-axis
//                            labels.add(a[0]);
//                        } catch (NumberFormatException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                else if (enddate != null ) {
//                    System.out.println(fDate.compareTo(enddate));
//                    if(fDate.before(enddate)  || compareDay(enddate, fDate)){
//                        try {
//                            entries.add( new BarEntry( Float.parseFloat( a[2]), count ));
//                            count += 1;
//                            //x-axis
//                            labels.add(a[0]);
//                        } catch (NumberFormatException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                }
//
//
//                 if (startdate == null && enddate == null){
//                    try {
//                        entries.add( new BarEntry( Float.parseFloat( a[2]), count ));
//                        count += 1;
//                        //x-axis
//                        labels.add(a[0]);
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//
//                // date = a[0], bloodsugar=a[2]
//                //y-axis
//
//            }
//            s.close();
//
//        } catch ( Exception e ){
//            Log.e("Chart", e.getMessage());
//        } finally {
//            if (inputStream != null){
//                try{
//                    inputStream.close();
//                } catch ( IOException e){
//                    Log.e("Chart", e.getMessage());
//                }
//            }
//
//        }
//    }
//}
