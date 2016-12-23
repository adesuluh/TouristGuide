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

public class NatureActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] daftarNature = {"Paralayang", "Sedudo Waterfall", "Arjuna Mountain", "Kawi Mountain", "Rumah Kayu", "Cangar Hot Spring"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature);

        ListView listNature = (ListView)findViewById(R.id.NatureListView);

        ArrayAdapter<String> NatureAdapter = new ArrayAdapter<String>(this, R.layout.nature_list, R.id.NatureCell,daftarNature);

        listNature.setAdapter(NatureAdapter);

        listNature.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Buka detail " + daftarNature[position], Toast.LENGTH_SHORT).show();

    }
}
