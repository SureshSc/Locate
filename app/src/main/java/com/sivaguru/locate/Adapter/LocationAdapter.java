package com.sivaguru.locate.Adapter;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sivaguru.locate.Helper.LocationClass;
import com.sivaguru.locate.R;

import java.util.ArrayList;

/**
 * Created by sureshsc on 02/03/16.
 */
public class LocationAdapter extends BaseAdapter {

    private ArrayList<LocationClass> arrayList;
    private Activity mContext;

    public LocationAdapter(ArrayList arrayList,Activity context) {
        this.arrayList = arrayList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);

        TextView title = (TextView)convertView.findViewById(R.id.locationTitle);
        TextView subTitle = (TextView)convertView.findViewById(R.id.locationSubTitle);

        LocationClass locationClass = new LocationClass();
        locationClass = arrayList.get(position);
        title.setText( locationClass.title);
        subTitle.setText(locationClass.subTitle);
        return convertView;
    }
}
