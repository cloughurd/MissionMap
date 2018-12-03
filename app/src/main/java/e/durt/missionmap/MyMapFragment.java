package e.durt.missionmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MyMapFragment extends SupportMapFragment implements IMapDisplay, OnMapReadyCallback {
    private GoogleMap map;
    private IMapPresenter mapPresenter;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mapPresenter = new MapPresenter(this);

        getMapAsync(this);

        SingleFactory.setMapPresenter(mapPresenter);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setMapToolbarEnabled(false);

        mapPresenter.notifyMapReady();
    }

    @Override
    public void placePOIs(final List<IPlottable> thingsToPlace) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < thingsToPlace.size(); i++){
                    IPlottable point = thingsToPlace.get(i);
                    MarkerOptions marker = new MarkerOptions();
                    marker.title(point.getLabel());
                    marker.position(new LatLng(point.getLatDouble(), point.getLongDouble()));
                    map.addMarker(marker);
                    if(i < thingsToPlace.size() - 1){
                        Polyline line = map.addPolyline(new PolylineOptions().add(new LatLng(point.getLatDouble(), point.getLongDouble()),
                                new LatLng(thingsToPlace.get(i + 1).getLatDouble(), thingsToPlace.get(i + 1).getLongDouble())));
                    }
                }
            }
        });
    }

    @Override
    public InputStream getFileFromAssets(String filename) {
        try {
            return getActivity().getAssets().open(filename);
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void showMessage(final String message) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(),message, Toast.LENGTH_LONG);
            }
        });
    }
}
