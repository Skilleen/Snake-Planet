package skilleen.snakeplanet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpNorthAmerica();
            }
        }
    }


    private void setUpNorthAmerica() {
        Marker easternCanadaMarker = mMap.addMarker(new MarkerOptions().position(new LatLng(50.4214, -75.6919)).title("Eastern Canada").snippet("Click To View Snakes"));
        Marker westernCanadaMarker = mMap.addMarker(new MarkerOptions().position(new LatLng(50.4214, -110.6919)).title("Western Canada").snippet("Click To View Snakes"));
        final Polygon easternCanada = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(47.5675, -52.7072),
                        new LatLng(43.7000, -79.4000),
                        new LatLng(49.8994, -97.1392),
                        new LatLng(55.9903, -87.6331),
                        new LatLng(54.9103, -59.8022),
                        new LatLng(47.5675, -52.7072))
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(0x5F00FF00));
        Polygon westernCanada = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(55.9903, -87.6331),
                        new LatLng(55.9903, -117.6331),
                        new LatLng(50.8994, -127.1392),
                        new LatLng(45.7000, -119.4000),
                        new LatLng(49.8994, -97.1392),
                        new LatLng(55.9903, -87.6331))
                .strokeColor(Color.RED)
                .strokeWidth(2)
                .fillColor(0x5FFF9900));
        mMap.setOnInfoWindowClickListener(
                new GoogleMap.OnInfoWindowClickListener(){
                    public void onInfoWindowClick(Marker marker){
                        Intent nextScreen = new Intent(MapsActivity.this,SearchByLocation.class);
                        String country = marker.getTitle();
                        nextScreen.putExtra("country", country);
                        startActivityForResult(nextScreen, 0);

                    }
                }
        );
    }
}
