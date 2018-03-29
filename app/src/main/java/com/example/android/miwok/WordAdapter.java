package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Moustafa on 2/4/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    int color;
    public WordAdapter(Activity context , ArrayList<Word> wordd,int colorr )
    {
        super(context,0,wordd);
        color = ContextCompat.getColor(getContext(),colorr);
    }
    @Override

    public View getView(int position,  View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentword = getItem(position);
        LinearLayout ll = (LinearLayout) listItemView.findViewById(R.id.lay);
        ll.setBackgroundColor(color);
        TextView defwTextView = (TextView) listItemView.findViewById(R.id.def);
        TextView miwwTextView = (TextView) listItemView.findViewById(R.id.miwo);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        defwTextView.setText(currentword.getDefaultTranslation());
        miwwTextView.setText(currentword.getMiwokWord());
        if(currentword.getResource_id() ==-1) {imageView.setVisibility(View.GONE);}
        else {
            imageView.setImageResource(currentword.getResource_id());
        }

        return listItemView; //super.getView(position, convertView, parent);

    }
}
