/**
 * MainActivity.java
 *
 * Comment
 *
 * @category Contus
 * @package com.raj.example.androidmaterial1
 * @version 1.0
 * @author Contus Team <developers@contus.in>
 * @copyright Copyright (C) 2014 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package material.example.raj.com.materialdesignexample;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import material.example.raj.com.materialdesignexample.adapter.SlideMenuAdapter;
import material.example.raj.com.materialdesignexample.fragments.CardFragment;
import material.example.raj.com.materialdesignexample.fragments.PaletteFragment;
import material.example.raj.com.materialdesignexample.fragments.RecyclerFragment;
import material.example.raj.com.materialdesignexample.fragments.SvgFragment;

public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout drawer;
    private ListView listSlideMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_drawer);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);

        mToggle = new ActionBarDrawerToggle(this, drawer,
                R.string.abc_action_bar_home_description,
                R.string.abc_action_bar_home_description);
        mToggle.setDrawerIndicatorEnabled(true);

        drawer.setDrawerListener(mToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listSlideMenu = (ListView) findViewById(R.id.listSlideMenu);
        listSlideMenu.setAdapter(new SlideMenuAdapter(this));

        listSlideMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayView(position);
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Load and display the fragments
     *
     * @param position the integer refer the slide menu position
     */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0: {
                fragment =new RecyclerFragment();
                break;
            }
            case 1: {
                fragment =new CardFragment();
                break;
            }
            case 2: {
                fragment =new PaletteFragment();
                break;
            }
            case 3: {
                fragment =new SvgFragment();
                break;
            }
            default:
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();
        }
        // update selected item and title, then close the drawer
        listSlideMenu.setItemChecked(position, true);
        listSlideMenu.setSelection(position);
        drawer.closeDrawer(GravityCompat.START);
    }


}
