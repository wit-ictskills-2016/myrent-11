package org.wit.myrent.activities;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by jfitzgerald on 12/10/2016.
 */
public class ResidenceMapFragment extends MapFragment implements OnMapReadyCallback,
    GoogleMap.OnMarkerDragListener,
    GoogleMap.OnInfoWindowClickListener,
    GoogleMap.OnCameraIdleListener
{

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
}

