package com.example.shreyas.benchmarkapp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shreyas.benchmarkapp.utils.Calculator;

public class BenchmarkMainActivity extends AppCompatActivity {

    private EditText etArraySize;
    private RadioGroup rgComplexity;
    private int[] array;
    private ConstraintLayout clBenchmarkAll;
    private  ConstraintLayout clSortingMethods;
    private TextView tvSelectionSort;
    private TextView tvInsertionSort;
    private TextView tvMurgeSort;
    private TextView tvBubbleSort;
    private TextView tvHeapSort;
    private long totalSortTime = 0;
    private  TextView tvChooseComplexity;
    private Button btnGenrateArray;
    private LinearLayout llGenrateArrayLayout;
    private Boolean genrated = false;


    public void doSort(View view) {
        switch(view.getId()) {
            case R.id.btnSelectionSort:
                totalSortTime = Calculator.doSelectionSort(array);
                tvSelectionSort.setText(""+ totalSortTime +"ms");

                break;
            case R.id.btnBubbleSort:
                totalSortTime = Calculator.doBubbleSort(array);
                tvBubbleSort.setText(""+ totalSortTime +"ms");
                break;

            case R.id.btnMurgeSort:
                totalSortTime = Calculator.doMurgeSort(array, 0, array.length-1);
                tvMurgeSort.setText(""+ totalSortTime +"ms");
                break;

            case R.id.btnInsertionSort:
                totalSortTime = Calculator.doInsertionSort(array);
                tvInsertionSort.setText(""+ totalSortTime +"ms");
                break;

            case R.id.btnHeapSort:
                totalSortTime = Calculator.doHeapSort(array);
                tvHeapSort.setText(""+ totalSortTime +"ms");
                break;
        }
    }

    public void GenerateArray(View view) {
        Boolean put = true;
        if (genrated) {
            etArraySize.setVisibility(View.VISIBLE);
            tvChooseComplexity.setText("Choose Complexity");
            rgComplexity.setVisibility(View.VISIBLE);
            btnGenrateArray.setText("Generate Array");
            clSortingMethods.setVisibility(View.INVISIBLE);
            clBenchmarkAll.setVisibility(View.INVISIBLE);
            genrated = false;
        }
        else {
            int size = 0;

            try {
                size = Integer.parseInt(etArraySize.getText().toString());
            } catch (Exception e) {
                Toast.makeText(this, "Enter the Length of the Array", Toast.LENGTH_SHORT).show();
                put = false;
            }

            if(put) {
                clSortingMethods.setVisibility(View.VISIBLE);
                clBenchmarkAll.setVisibility(View.VISIBLE);
                etArraySize.setVisibility(View.INVISIBLE);
                rgComplexity.setVisibility(View.INVISIBLE);
                btnGenrateArray.setText("Generate Again");
                tvBubbleSort.setText("__");
                tvHeapSort.setText("__");
                tvInsertionSort.setText("__");
                tvMurgeSort.setText("__");
                tvSelectionSort.setText("__");
                switch (rgComplexity.getCheckedRadioButtonId()) {

                    case R.id.rbBestCase:
                        array = Calculator.generateSortedArray(size);
                        tvChooseComplexity.setText("Best Case Array Genrated");
                        break;

                    case R.id.rbAverageCase:
                        array = Calculator.generateRandomArray(size);
                        tvChooseComplexity.setText("Average Case Array Genrated");
                        break;

                    case R.id.rbWorstCase:
                        array = Calculator.generateSortedArrayDesc(size);
                        tvChooseComplexity.setText("Worst Case Array Genrated");
                        break;
                }
                genrated = true;
            }
        }
    }

    public void sortAll(View view) {
        totalSortTime = Calculator.doBubbleSort(array);
        tvBubbleSort.setText(""+ totalSortTime +"ms");

        totalSortTime = Calculator.doSelectionSort(array);
        tvSelectionSort.setText(""+ totalSortTime +"ms");

        totalSortTime = Calculator.doInsertionSort(array);
        tvInsertionSort.setText(""+ totalSortTime +"ms");

        totalSortTime = Calculator.doMurgeSort(array, 0, array.length-1);
        tvMurgeSort.setText(""+ totalSortTime +"ms");

        totalSortTime = Calculator.doHeapSort(array);
        tvHeapSort.setText(""+ totalSortTime +"ms");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnechmark_main);

        etArraySize = (EditText) findViewById(R.id.etArraySize);
        rgComplexity = (RadioGroup) findViewById(R.id.rgComplexity);
        clBenchmarkAll = (ConstraintLayout) findViewById(R.id.clBenchmarkAll);
        clSortingMethods = (ConstraintLayout) findViewById(R.id.clSortingMethods);
        tvSelectionSort = (TextView) findViewById(R.id.tvSelectionSort);
        tvBubbleSort = (TextView) findViewById(R.id.tvBubbleSort);
        tvInsertionSort = (TextView) findViewById(R.id.tvInsertionSort);
        tvMurgeSort = (TextView) findViewById(R.id.tvMurgeSort);
        tvHeapSort = (TextView) findViewById(R.id.tvHeapSort);
        tvChooseComplexity = (TextView) findViewById(R.id.tvChooseComplexity);
        btnGenrateArray = (Button) findViewById(R.id.btnGenrateArray);
        llGenrateArrayLayout =(LinearLayout) findViewById(R.id.llGenrateArrayLayout);

        tvChooseComplexity.setTextSize(18);
    }
}
