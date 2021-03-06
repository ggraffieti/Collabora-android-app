package org.gammf.collabora_android.app.gui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.gammf.collabora_android.app.R;

import java.util.ArrayList;

/**
 * Created by @MattiaOriani on 12/08/2017
 *
 * Custom Adapter for list view
 */
public class DrawerItemCustomAdapter extends ArrayAdapter<CollaborationComponentInfo> {

    Context mContext;
    int layoutResourceId;
    ArrayList<CollaborationComponentInfo> data = null;


    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, ArrayList<CollaborationComponentInfo> data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        CollaborationComponentInfo folder = data.get(position);

        imageViewIcon.setImageResource(folder.getIcon());
        textViewName.setText(folder.getContent());

        return listItem;
    }

    public void updateList(CollaborationComponentInfo newItem){
        this.data.add(newItem);
    }
}

