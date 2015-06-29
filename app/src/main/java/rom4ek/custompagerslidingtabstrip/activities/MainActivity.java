package rom4ek.custompagerslidingtabstrip.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import rom4ek.custompagerslidingtabstrip.R;
import rom4ek.custompagerslidingtabstrip.adapters.MainAdapter;
import rom4ek.custompagerslidingtabstrip.model.ViewPagerTab;


public class MainActivity extends AppCompatActivity {

    PagerSlidingTabStrip tabs;
    ViewPager pager;
    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        ArrayList<ViewPagerTab> tabsList = new ArrayList<>();
        tabsList.add(new ViewPagerTab("One", 0));
        tabsList.add(new ViewPagerTab("Two", 1));
        tabsList.add(new ViewPagerTab("Three", 2));

        adapter = new MainAdapter(getSupportFragmentManager(), tabsList);

        pager.setAdapter(adapter);
        tabs.setViewPager(pager);

        pager.setOffscreenPageLimit(3);
        getSupportActionBar().hide();

        notifyTabStripChanged(2, 5);
    }


    private void notifyTabStripChanged(int position, int notificationsCount) {
        LinearLayout tabHost = (LinearLayout) tabs.getChildAt(0);
        RelativeLayout tabLayout = (RelativeLayout) tabHost.getChildAt(position);
        TextView badge = (TextView) tabLayout.findViewById(R.id.badge);
        if (notificationsCount > 0) {
            badge.setVisibility(View.VISIBLE);
            badge.setText(String.valueOf(notificationsCount));
        } else {
            badge.setVisibility(View.GONE);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
