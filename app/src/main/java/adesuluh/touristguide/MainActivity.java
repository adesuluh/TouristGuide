package adesuluh.touristguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView restaurantCategory = (TextView)findViewById(R.id.restaurant);
        TextView parkCategory = (TextView)findViewById(R.id.park);
        TextView natureCategory = (TextView)findViewById(R.id.nature);
        TextView beachCategory = (TextView)findViewById(R.id.beach);

        restaurantCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurantIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(restaurantIntent);
            }
        });

        parkCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parkIntent = new Intent(MainActivity.this, ParkActivity.class);
                startActivity(parkIntent);
            }
        });

        natureCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent natureIntent = new Intent(MainActivity.this, NatureActivity.class);
                startActivity(natureIntent);
            }
        });

        beachCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent beachIntent = new Intent(MainActivity.this, BeachActivity.class);
                startActivity(beachIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
