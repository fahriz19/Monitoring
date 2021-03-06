package com.elektro.monitorruangan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.elektro.monitorruangan.adapter.AcaraAdapter;
import com.elektro.monitorruangan.adapter.AcaraGridAdapter;
//import com.elektro.monitorruangan.fragment.ListDosenFragment;
import com.elektro.monitorruangan.fragment.ListDosenFragment;
import com.elektro.monitorruangan.fragment.MonitorFragment;
import com.elektro.monitorruangan.model.Dosen;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    manager.beginTransaction().replace(R.id.content_frame, new ListDosenFragment()).commit();
                    return true;
                case R.id.navigation_listdosen:
                    manager.beginTransaction().replace(R.id.content_frame, new MonitorFragment()).commit();
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
