package com.think4software.androidpoc.android;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.think4software.androidpoc.R;
import com.think4software.androidpoc.android.activities.NetworkActivity;
import com.think4software.androidpoc.android.activities.NetworkActivity_;
import com.think4software.androidpoc.model.Counter;
import com.think4software.androidpoc.service.CounterService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @ViewById(R.id.fab)
    FloatingActionButton fab;

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawer;

    @ViewById
    TextView counterLabel;

    private Counter counter;

    @Bean
    CounterService counterService;

    @Click(R.id.fab)
    public void floatingActionListener(View view) {
        Intent intent = new Intent(this, NetworkActivity_.class);
        startActivity(intent);
    }

    @AfterViews
    public void init() {

        setSupportActionBar(toolbar); // I had to set it manually to work with the NoActionBar theme
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // counter init
        counter = counterService.getCounter();
        if (counter == null) {
            counter = new Counter();
        }
        counterLabel.setText(counter.getValue() + "");
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @OptionsItem(R.id.action_settings)
    public void menuSettings() {

    }

    @OptionsItem(R.id.action_save)
    public void menuSave() {
        counterService.saveCounter(counter);

        Snackbar.make(fab, "Counter Saved!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Click(R.id.increase_counter)
    public void increaseCounter() {

        counter.increaseCounter();
        counterLabel.setText(counter.getValue() + "");
    }
}
