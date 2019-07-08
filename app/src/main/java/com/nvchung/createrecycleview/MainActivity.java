package com.nvchung.createrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNumber;
    private AdapterNumber adapterNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO 1>> create xml
        // TODO 2>> create Adapter
        //TODO 3 >> setup RecycleView

        recyclerViewNumber = findViewById(R.id.numberRecycleView);

        AdapterNumber.ItemClick itemClick = new AdapterNumber.ItemClick() {
            @Override
            public void onItemClick(int pos) {
                Toast.makeText(MainActivity.this, "" + pos, Toast.LENGTH_SHORT).show();
            }
        };
        adapterNumber = new AdapterNumber(this,itemClick);

        recyclerViewNumber.setAdapter(adapterNumber);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerViewNumber.setLayoutManager(layoutManager);
        recyclerViewNumber.setItemAnimator(new DefaultItemAnimator());

    }

}
