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

public class RestaurantActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] daftarRestaurant = {"Burger Buto", "Warung Lestari", "Puji Mulyo"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        ListView listRestaurants = (ListView)findViewById(R.id.RestaurantListView);

        ArrayAdapter<String> RestaurantAdapter = new ArrayAdapter<String>(this, R.layout.restaurants_list, R.id.RestaurantCell ,daftarRestaurant);

        listRestaurants.setAdapter(RestaurantAdapter);

        listRestaurants.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Buka detail " + daftarRestaurant[position], Toast.LENGTH_SHORT).show();
    }
}
