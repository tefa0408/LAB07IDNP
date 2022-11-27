package org.idnp.idnp2022lab07.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.idnp.idnp2022lab07.R;
import org.idnp.idnp2022lab07.dialog.MessageDialog;
import org.idnp.idnp2022lab07.fragments.FragmentBlue;
import org.idnp.idnp2022lab07.fragments.FragmentRed;
import org.idnp.idnp2022lab07.fragments.FragmentSearch;
import org.idnp.idnp2022lab07.fragments.FragmentYellow;

public class MainActivity extends AppCompatActivity
        implements MainCallbacks {

    private static final String TAG = "MainActivity";
    private Fragment fragmentCurrent;
    private FragmentSearch fragmentSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragmentSearch();

        BottomNavigationView bottomNavigation =
                (BottomNavigationView) findViewById(R.id.bottom_navigation_home);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleBottomNavigationItemSelected(item);
                return true;
            }
        });

    }

    private void handleBottomNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_blue:
                fragmentCurrent = new FragmentBlue();
                switchFragment(fragmentCurrent);
                fragmentSearch.onMsgFromMainToFragment("Blue");
                break;
            case R.id.action_red:
                fragmentCurrent = new FragmentRed();
                switchFragment(fragmentCurrent);
                fragmentSearch.onMsgFromMainToFragment("Red");
                break;
            case R.id.action_yellow:
                fragmentCurrent = new FragmentYellow();
                switchFragment(fragmentCurrent);
                fragmentSearch.onMsgFromMainToFragment("Yellow");
                break;
        }
    }

    private void loadFragmentSearch() {
        fragmentSearch = FragmentSearch.newInstance("", "");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_buscar, fragmentSearch);
        fragmentTransaction.commit();

    }

    private void switchFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_home, fragment);
        fragmentTransaction.commit();

    }


    @Override
    public void onMsgFromFragToMain(String Sender, String Message) {
        if (fragmentCurrent == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            MessageDialog.newInstance("Primero debes seleccionar un color donde buscar").show(fragmentManager, null);
        }

        if (Sender.equals(FragmentRed.SENDER)) {
            Log.d(TAG, Message);

        } else if (Sender.equals(FragmentBlue.SENDER)) {
            Log.d(TAG, Message);

        } else if (Sender.equals(FragmentSearch.SENDER)) {
            Log.d(TAG, Message);
            if (fragmentCurrent instanceof FragmentRed)
                ((FragmentRed) fragmentCurrent).onMsgFromMainToFragment(Message);
            else if (fragmentCurrent instanceof FragmentBlue)
                ((FragmentBlue) fragmentCurrent).onMsgFromMainToFragment(Message);

        }

    }
}