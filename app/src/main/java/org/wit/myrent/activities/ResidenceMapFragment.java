package org.wit.myrent.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.wit.android.helpers.MapHelper;
import org.wit.myrent.R;
import org.wit.myrent.app.MyRentApp;
import org.wit.myrent.models.Residence;

import static org.wit.android.helpers.IntentHelper.navigateUp;


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

    resId = (Long)getActivity().getIntent().getSerializableExtra(ResidenceFragment.EXTRA_RESIDENCE_ID);
    app = (MyRentApp)getActivity().getApplication();
    residence = app.portfolio.getResidence(resId);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    super.onCreateView(inflater, parent, savedInstanceState);
    View v = inflater.inflate(R.layout.activity_map, parent, false);
    getMapAsync(this);
    return v;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    switch (item.getItemId())
    {
      case android.R.id.home:
        navigateUp(getActivity(), ResidenceFragment.EXTRA_RESIDENCE_ID, resId);
        return true;

      default: return super.onOptionsItemSelected(item);
    }
  }

  // OnMapReadyCallback

  /**
   * Invoked by framework once fragment created
   * @param map The map associated with this residence
   */
  @Override
  public void onMapReady(GoogleMap map) {
    this.map = map;

    map.setOnMarkerDragListener(this);
    map.setOnInfoWindowClickListener(this);
    map.setOnMarkerClickListener(this);
    map.setOnCameraIdleListener(this);

    LatLng latLng = MapHelper.latLng(getActivity(), residence.geolocation);
    MarkerOptions options = new MarkerOptions()
        .title("Residence")
        .snippet("GPS : " + latLng.toString())
        .draggable(true)
        .position(latLng);

    map.addMarker(options);

    map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, (float)residence.zoom));

    map.setOnInfoWindowClickListener(this);
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
  /**
   * When marker drag ends, save Residence model geolocation and zoom.
   * @param marker The map marker representing current residence geolocation.
   */
  @Override
  public void onMarkerDragEnd(Marker marker) {
    residence.geolocation = MapHelper.latLng(marker.getPosition());
    residence.zoom = map.getCameraPosition().zoom;
    map.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
  }

  // GoogleMap.OnInfoWindowClickListener
  /**
   * Click an open infowindow to close it.
   * Click on a marker to open an infowindow
   * @param marker The marker associated with this infowindow.
   */
  @Override
  public void onInfoWindowClick(Marker marker) {
    marker.hideInfoWindow();
  }

  // GoogleMap.OnCameraIdleListener
  /**
   * We implement this interface to capture zoom when marker not dragged but zoom changed
   * example by pinching screen.
   * When google map camera stops moving we capture the zoom and save to model.
   */
  @Override
  public void onCameraIdle() {
    residence.zoom = map.getCameraPosition().zoom;
  }

  // GoogleMap.OnMarkerClickListener
  /**
   * The purpose of including this method is to update the info window information
   * with the geolocation of the current position of the marker.
   * @param marker The marker whose info window being refreshed
   * @return Returns false indicating default behaviour, i.e. open info window.
   */
  @Override
  public boolean onMarkerClick(Marker marker) {
    LatLng latLng = MapHelper.latLng(getActivity(), residence.geolocation);
    marker.setSnippet("GPS : " + latLng.toString());
    return false;
  }
}

