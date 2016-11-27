package com.libreoffice.id.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

import com.libreoffice.id.R;
import com.libreoffice.id.adapters.HomeAdapter;
import com.libreoffice.id.contracts.HomeContract;
import com.libreoffice.id.customs.MaterialProgressBar;
import com.libreoffice.id.fragments.BaseFragment;
import com.libreoffice.id.fragments.BookmarksFragment;
import com.libreoffice.id.fragments.DocumentsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    @BindView(R.id.home_pager)
    ViewPager pager;
    @BindView(R.id.home_progressBar)
    MaterialProgressBar progressBar;
    @BindView(R.id.home_tab)
    TabLayout homeTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initComponents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initComponents() {
        initViewPager();
    }

    private void initViewPager() {

        Resources resources = this.getResources();

        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(DocumentsFragment.newInstance(this, resources.getString(R.string.home_documents)));
        fragments.add(BookmarksFragment.newInstance(this, resources.getString(R.string.home_bookmarks)));

        HomeAdapter adapter = new HomeAdapter(getSupportFragmentManager(), fragments);

        pager.setAdapter(adapter);
        homeTab.setupWithViewPager(pager);
    }

    @Override
    public void onProgress(boolean onProgress) {
        progressBar.setVisibility(onProgress ? View.VISIBLE : View.GONE);
    }
}
