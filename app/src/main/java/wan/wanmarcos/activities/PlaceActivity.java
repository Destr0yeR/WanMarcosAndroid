package wan.wanmarcos.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import wan.wanmarcos.R;
import wan.wanmarcos.fragments.NavigationDrawerFragment;
import wan.wanmarcos.fragments.ProfileUserFragment;
import wan.wanmarcos.utils.Constants;
import wan.wanmarcos.utils.Redirection.Redirect;

public class PlaceActivity extends AppCompatActivity {

    private Toolbar toolbar;
    NavigationDrawerFragment drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Lugares");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setBackgroundColor(toolbar, R.attr.colorPrimary);
        drawerFragment = (NavigationDrawerFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.SetUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        Redirect.getSingelton().showFragment(this, Constants.PLACE_CONTAINER, Constants.FRAGMENT_LIST_PLACE);
    }
    private void setBackgroundColor(Toolbar toolbar,int resID)
    {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(resID, typedValue, true);
        int color = typedValue.data;
        toolbar.setBackgroundColor(color);
    }

}
