package com.example.zezhou.bd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView productListView;
    Spinner categorySpinner;
    ProductAdapter productListViewAdapater;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Product> displayList = new ArrayList<>();

    private void setUpProducts(){
        products.add(new Product("Bulb1", "0001", 1, R.drawable.bulb1));
        products.add(new Product("Bulb2", "0002", 1, R.drawable.bulb2));
        products.add(new Product("Speaker1", "0003", 2, R.drawable.speaker1));
        products.add(new Product("Speaker2", "0004", 2, R.drawable.speaker2));
        products.add(new Product("PowerBoard1", "0005", 3, R.drawable.powerboard1));
        products.add(new Product("PowerBoard2", "0006", 3, R.drawable.powerboard2));
        products.add(new Product("Switch1", "0007", 4, R.drawable.switch1));
        products.add(new Product("Switch2", "0008", 4, R.drawable.switch2));
        products.add(new Product("Timer1", "0009", 5, R.drawable.timer1));
        products.add(new Product("Timer2", "0010", 5, R.drawable.timer2));

        displayList.addAll(products);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpProducts();

        productListView = (ListView) findViewById(R.id.productListView);
        productListViewAdapater = new ProductAdapter(MainActivity.this,
                R.layout.product_item, displayList);
        productListView.setAdapter(productListViewAdapater);

        categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
        categorySpinner.setPrompt("Please select a category");
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"The category you choosed is："
                        + getResources().getStringArray(R.array.category_array)[position],Toast.LENGTH_SHORT).show();
                updateDisplayListByCategory(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    void updateDisplayListByCategory(int category){
        productListViewAdapater.clear();

        for(Product p: products){
            if (p.getCategoryInt() == category || category == 0){
                productListViewAdapater.insert(p, productListViewAdapater.getCount());
            }
        }


    }

}
