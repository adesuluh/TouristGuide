package adesuluh.touristguide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

/**
 * Created by ridho on 12/26/16.
 */

public class DetailActivity extends AppCompatActivity {

    Place place;
    private ImageView imgView;
    private TextView titlePlace,
            labelAdressPlace,
            addressPlace,
            labelTypePlace,
            typePlace,
            labelLatitudePlace,
            latitudePlace,
            labelLongitudePlace,
            longitudePlace,
            labelDescriptionPlace,
            descriptionPlace;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_place);

        imgView = (ImageView) findViewById(R.id.imgView);
        titlePlace = (TextView) findViewById(R.id.titlePlace);
        labelAdressPlace = (TextView) findViewById(R.id.labelAdressPlace);
        addressPlace = (TextView) findViewById(R.id.addressPlace);
        labelTypePlace = (TextView) findViewById(R.id.labelTypePlace);
        typePlace = (TextView) findViewById(R.id.typePlace);
        labelLatitudePlace = (TextView) findViewById(R.id.labelLatitudePlace);
        latitudePlace = (TextView) findViewById(R.id.latitudePlace);
        labelLongitudePlace = (TextView) findViewById(R.id.labelLongitudePlace);
        longitudePlace = (TextView) findViewById(R.id.longitudePlace);
        labelDescriptionPlace = (TextView) findViewById(R.id.labelDescriptionPlace);
        descriptionPlace = (TextView) findViewById(R.id.descriptionPlace);

        Intent i = getIntent();
        place = (Place) i.getSerializableExtra("place");

        titlePlace.setText(place.getName());
        addressPlace.setText(place.getAddress());
        typePlace.setText(place.getType());
        latitudePlace.setText(place.getLatitude());
        longitudePlace.setText(place.getLongitude());
        descriptionPlace.setText(place.getDescription());

        ImageDownloader imgDownloader = new ImageDownloader(imgView);
        imgDownloader.execute(place.getImage());
    }

    public void openMap(View view) {
        Intent intent = null, chooser = null;
        if (view.getId() == R.id.mapOpenButton) {
            intent = new Intent(android.content.Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:" + place.getLatitude() + ", " + place.getLongitude()));
            chooser= Intent.createChooser(intent, "Launch Maps");
            startActivity(chooser);
        }
    }

    class ImageDownloader extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public ImageDownloader(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap mIcon = null;
            try {
                InputStream in = new java.net.URL(url).openStream();
                mIcon = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
            }
            return mIcon;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
