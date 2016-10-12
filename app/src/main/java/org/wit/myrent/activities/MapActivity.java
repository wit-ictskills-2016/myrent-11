package org.wit.myrent.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.*;
import org.wit.myrent.R;
import org.wit.myrent.app.MyRentApp;
import org.wit.myrent.models.Residence;

public class MapActivity extends AppCompatActivity
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

    //MapFragment mapFragment = (ResidenceMapFragment) getFragmentManager().findFragmentById(R.id.map);

    FragmentManager manager = getFragmentManager();
    Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
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
