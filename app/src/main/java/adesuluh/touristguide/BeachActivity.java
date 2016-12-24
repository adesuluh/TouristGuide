package adesuluh.touristguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by adesuluh on 12/23/16.
 */

public class BeachActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    final ArrayList<Place> places = new ArrayList<>();
    final ArrayList<String> strPlace = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach);

        final ListView listBeach = (ListView)findViewById(R.id.BeachListView);

        db.child("places").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                    Log.d("TAG1", noteDataSnapshot.toString());
                    Place p = ds.getValue(Place.class);
                    if (p.getType().equalsIgnoreCase("beach")) {
                        places.add(p);
                        strPlace.add(p.getName());
                    }
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(BeachActivity.this, R.layout.park_list, R.id.ParkCell, strPlace);
                listBeach.setAdapter(adapter);
                listBeach.setOnItemClickListener(BeachActivity.this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this, "Buka detail " + daftarBeach[position], Toast.LENGTH_SHORT).show();
    }
}
