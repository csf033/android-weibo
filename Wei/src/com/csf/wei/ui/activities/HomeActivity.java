package com.csf.wei.ui.activities;

import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.csf.wei.R;
import com.csf.wei.ui.fragments.HomeFragment;

public class HomeActivity extends BaseActivity {
	private DrawerLayout mDrawerLayout;
	private LinearLayout mDrawer;
	private FrameLayout mContent;
	private ActionBar mActionBar;
	private ActionBarDrawerToggle mDrawerToggle;
	private Fragment mHomeFragment;
	private FragmentManager fm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		mDrawerLayout = (DrawerLayout) findViewById(R.id.home_drawer);
		mDrawerLayout.setDrawerListener(new DemoDrawerListener());
		mDrawer = (LinearLayout) findViewById(R.id.home_left_drawer);
		mContent = (FrameLayout) findViewById(R.id.home_fragment_container);
		
		mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, 
				R.string.drawer_open, R.string.drawer_close);
		// TODO ¼ì²âÓÃ»§×´Ì¬
		
		mHomeFragment = new HomeFragment(); 
		fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(mHomeFragment, "home");
		ft.commit();
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}
	
	  @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        /*
	         * The action bar home/up action should open or close the drawer.
	         * mDrawerToggle will take care of this.
	         */
	        if (mDrawerToggle.onOptionsItemSelected(item)) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }
	  private class DemoDrawerListener implements DrawerLayout.DrawerListener {
	        @Override
	        public void onDrawerOpened(View drawerView) {
	            mDrawerToggle.onDrawerOpened(drawerView);
//	            mActionBar.onDrawerOpened();
	        }

	        @Override
	        public void onDrawerClosed(View drawerView) {
	            mDrawerToggle.onDrawerClosed(drawerView);
//	            mActionBar.onDrawerClosed();
	        }

	        @Override
	        public void onDrawerSlide(View drawerView, float slideOffset) {
	            mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
	        }

	        @Override
	        public void onDrawerStateChanged(int newState) {
	            mDrawerToggle.onDrawerStateChanged(newState);
	        }
	    }
}
