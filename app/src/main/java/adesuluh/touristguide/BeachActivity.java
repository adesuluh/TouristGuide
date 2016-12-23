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

public class BeachActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] daftarBeach = {"Balekambang Beach", "Goa Cina Beach"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);

        ListView listBeach = (ListView)findViewById(R.id.BeachListView);

        ArrayAdapter<String> BeachAdapter = new ArrayAdapter<String>(this, R.layout.beach_list, R.id.BeachCell, daftarBeach);

        listBeach.setAdapter(BeachAdapter);

        listBeach.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Buka detail " + daftarBeach[position], Toast.LENGTH_SHORT).show();

    }
}
