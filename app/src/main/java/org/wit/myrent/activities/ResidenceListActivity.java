package org.wit.myrent.activities;

import com.example.android.multidex.MyRentApp.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ResidenceListActivity extends AppCompatActivity
{
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_container);

    FragmentManager manager = getSupportFragmentManager();
    Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
    if (fragment == null)
    {
      fragment = new ResidenceListFragment();
      manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
    }
  }
}
