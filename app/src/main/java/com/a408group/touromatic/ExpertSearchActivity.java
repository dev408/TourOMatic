package com.a408group.touromatic;

import com.a408group.touromatic.restwrapper.SearchRest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;
import android.widget.GridView;

import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.content.res.TypedArray;
import 	android.graphics.Typeface;
public class ExpertSearchActivity extends AppCompatActivity {

    private TextView mTextMessage;
    List<String> list;
    GridView gridView;
    private GridViewAdapter gridAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_expert_search);




        list=new ArrayList<String>();
        list.add("Architecture");
        list.add("Outdoors");
        list.add("Food & Drink");
        list.add("Gallery");
        list.add("Monument");
        list.add("Museum");
        list.add("Oddities");
        list.add("Shopping");
        list.add("Roadside");

        gridView=(GridView) findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(this, R.layout.grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);

        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.transit_mode), iconFont);

        Button submitButton= (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Within the activity

                SearchRest.init(getApplicationContext());
                SearchRest.doSearch();
             //   Intent i2 = new Intent(getApplicationContext(), SearchResultListActivity.class);
             //   startActivity(i2);
            }
        });
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(ExpertSearchActivity.this, CategoryDetailsActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);
            }
        });


        // Retrieve the PlaceAutocompleteFragment.
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                String name= place.getName().toString();
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.

            }
        });
    }
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, list.get(i)));
        }
        return imageItems;
    }







}


