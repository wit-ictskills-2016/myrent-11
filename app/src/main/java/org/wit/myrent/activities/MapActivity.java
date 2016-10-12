package org.wit.myrent.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.*;
import org.wit.myrent.R;
import org.wit.myrent.app.MyRentApp;
import org.wit.myrent.models.Residence;

public class MapActivity extends FragmentActivity
{

  /*
 * We use the current residence when navigating back to parent class - ResidenceFragment as
 * this is required in ResidenceFragment onCreate. The navigateUp
 */
  Long resId;

  Residence residence; // The residence associated with this map pane
  MyRentApp app;
  GoogleMap map;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_container);

    //getActionBar().setDisplayHomeAsUpEnabled(true);
    //MapFragment mapFragment = (ResidenceMapFragment) getFragmentManager().findFragmentById(R.id.map);

    FragmentManager manager = getSupportFragmentManager();
    SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.fragmentContainer);
    if (fragment == null)
    {
      fragment = new ResidenceMapFragment();
      manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
    }

//    Fragment fragment =  ResidenceMapFragment.newInstance();
//    FragmentTransaction fragmentTransaction =
//        getFragmentManager().beginTransaction();
//    fragmentTransaction.add(R.id.fragmentContainer, fragment);
//    fragmentTransaction.commit();
  }

}
