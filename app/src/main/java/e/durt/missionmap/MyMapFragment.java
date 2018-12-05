package e.durt.missionmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
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
    private MapView mapView;
    private IMapPresenter mapPresenter;
    private LinearLayout footer;
    private TextView help;
    private TextView clicked;
    private final String instructionsText = "Click Here for Epistles";
    private final double START_LAT = 28.6329957;
    private final double START_LONG = -106.06910040000002;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mapPresenter = new MapPresenter(this);

//        getMapAsync(this);

        SingleFactory.setMapPresenter(mapPresenter);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View v = layoutInflater.inflate(R.layout.fragment_my_map, viewGroup, false);

        mapView = v.findViewById(R.id.mapview);
        mapView.onCreate(bundle);
        mapView.getMapAsync(this);

        footer = v.findViewById(R.id.map_footer);
        footer.setClickable(true);
        footer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapPresenter.selectArea(clicked.getText().toString().split("\n")[0]);
            }
        });

        help = v.findViewById(R.id.click_instructions);
        clicked = v.findViewById(R.id.clicked_area);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setMapToolbarEnabled(false);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(START_LAT, START_LONG), 5.0f));

        mapPresenter.notifyMapReady();
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                help.setText(instructionsText);
                String label = marker.getTitle() + "\n" + (String)marker.getTag();
                clicked.setText(label);
                return false;
            }
        });
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

                    Marker addedMarker = map.addMarker(marker);
                    addedMarker.setTag(point.getDateString());
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
                Toast.makeText(getContext(),message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
