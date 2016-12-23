package adesuluh.touristguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by adesuluh on 12/23/16.
 */

public class ParkActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] daftarPark = {"Alun-Alun Kota Malang", "Alun-Alun Kota Batu"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park);

        ListView listPark = (ListView)findViewById(R.id.ParkListView);

        ArrayAdapter<String> ParkAdapter = new ArrayAdapter<String>(this, R.layout.park_list, R.id.ParkCell, daftarPark);

        listPark.setAdapter(ParkAdapter);

        listPark.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Buka detail " + daftarPark[position], Toast.LENGTH_SHORT).show();

    }
}
