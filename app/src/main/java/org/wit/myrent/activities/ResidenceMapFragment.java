package org.wit.myrent.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;

import org.wit.myrent.R;
import org.wit.myrent.app.MyRentApp;
import org.wit.myrent.models.Residence;

/**
 * Created by jfitzgerald on 12/10/2016.
 */
public class ResidenceMapFragment extends MapFragment implements OnMapReadyCallback,
    GoogleMap.OnMarkerDragListener,
    GoogleMap.OnInfoWindowClickListener,
    GoogleMap.OnCameraIdleListener,
    GoogleMap.OnMarkerClickListener
{

  /*
  * We use the current residence when navigating back to parent class - ResidenceFragment as
  * this is required in ResidenceFragment onCreate. The navigateUp
  */
  Long resId;

  Residence residence; // The residence associated with this map fragment
  MyRentApp app;
  GoogleMap map;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    super.onCreateView(inflater, parent, savedInstanceState);
    View v = inflater.inflate(R.layout.activity_map, parent, false);

    return v;
  }

  // OnMapReadyCallback
  @Override
  public void onMapReady(GoogleMap googleMap) {

  }

  // GoogleMap.OnMarkerDragListener
  @Override
  public void onMarkerDragStart(Marker marker) {

  }

  // GoogleMap.OnMarkerDragListener
  @Override
  public void onMarkerDrag(Marker marker) {

  }

  // GoogleMap.OnMarkerDragListener
  @Override
  public void onMarkerDragEnd(Marker marker) {

  }

  // GoogleMap.OnInfoWindowClickListener
  @Override
  public void onInfoWindowClick(Marker marker) {

  }

  // GoogleMap.OnCameraIdleListener
  @Override
  public void onCameraIdle() {

  }

  // GoogleMap.OnMarkerClickListener
  @Override
  public boolean onMarkerClick(Marker marker) {
    return false;
  }
}

