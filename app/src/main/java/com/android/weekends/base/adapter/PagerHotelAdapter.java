package com.android.weekends.base.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.weekends.R;

public class PagerHotelAdapter extends PagerAdapter {
    int[] mResources = {
            R.drawable.temple,
            R.drawable.temple,
            R.drawable.temple,
            R.drawable.temple,
            R.drawable.temple,
            R.drawable.temple
    };
    Context mContext;
    LayoutInflater mLayoutInflater;

    public PagerHotelAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout) o);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.row_hotelpageritem, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView_hotel);
        imageView.setImageResource(mResources[position]);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
