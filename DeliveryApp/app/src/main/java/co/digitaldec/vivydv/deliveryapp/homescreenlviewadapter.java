package co.digitaldec.vivydv.deliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vivekya on 6/4/2017.
 */
public class homescreenlviewadapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> stringlist = new ArrayList<String>();
    private int pos=0;
    private LayoutInflater inflater;

    public homescreenlviewadapter(Context context, int textViewResourceId, ArrayList<String> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.stringlist = objects;
    }

    @Override
    public long getItemId(int position) {
        pos=position;
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public String getItem(int position) {
        return stringlist.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = null;
        convertView = null;
        rowView = convertView;
        // Check if an existing view is being reused, otherwise inflate the view
        if (rowView == null) {
            LayoutInflater inflator;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.allconsignmentslistrow, parent, false);
        }

        String currentPosition = getItem(position);

        if(currentPosition != null) {
            TextView name = (TextView) rowView.findViewById(R.id.artist);
            name.setText(stringlist.get(position).toString());
        }
        return rowView;
    }


}