package com.libreoffice.id.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by rhony on 11/27/16.
 */

public abstract class BaseFragment extends Fragment {

    public String fragmentTitle;
    protected Context context;
    protected Resources resources;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.context = view.getContext();
        this.resources = context.getResources();
        super.onViewCreated(view, savedInstanceState);
    }
}
