package com.a408group.touromatic;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import com.a408group.touromatic.restwrapper.GoogleNearestRoadsRest;
import com.a408group.model.TourItem;
import com.a408group.model.TourItems;
import com.google.gson.Gson;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * An activity representing a list of search_results. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link SearchResultDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class SearchResultListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    public static final String EXTRA_OBJ = "key.EXTRA_OBJ";
    public static final String EXTRA_NOTIF_FLAG = "key.EXTRA_NOTIF_FLAG";
    ImageLoader imageLoader = null;
    // give preparation animation activity transition

    static ArrayList<TourItem> items = null;
    static String origin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (imageLoader == null) {
            imageLoader = ImageLoader.getInstance(); // Get singleton instance
            imageLoader.init(ImageLoaderConfiguration.createDefault(SearchResultListActivity.this));
        }
        setContentView(R.layout.activity_searchresult_list);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        String tourItemsJSON = (String) b.get("TourItems");
        Gson gson = new Gson();
        TourItems tourItems = gson.fromJson(tourItemsJSON, TourItems.class);
        setItems(tourItems.getTourItem());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
        Button buidlTourButton= (Button) findViewById(R.id.build_tour);

        buidlTourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GoogleNearestRoadsRest.init(getApplicationContext());
                GoogleNearestRoadsRest.doGoogleNearestRoads("40.685723,-73.984534","walking",items);

            }
        });

        Button showMapButton= (Button) findViewById(R.id.show_map);

        showMapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(SearchResultListActivity.this, MapWithClusteredMarkersActivity.class);
                Gson gson = new Gson();
                String jsonInString = gson.toJson(SearchResultListActivity.items);
                intent.putExtra("TourItems", jsonInString);
                intent.putExtra("Origin", "40.685723,-73.984534");
                startActivity(intent);

            }
        });


    }

    public void setItems(ArrayList<TourItem> items) {
        View recyclerView = findViewById(R.id.activity_searchresult_list);
        assert recyclerView != null;
        this.items = items;
        setupRecyclerView((RecyclerView) recyclerView, items);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView, ArrayList<TourItem> items) {
        recyclerView.setAdapter(new TourItemsItemRecyclerViewAdapter(items));
    }

    public class TourItemsItemRecyclerViewAdapter
            extends RecyclerView.Adapter<TourItemsItemRecyclerViewAdapter.ViewHolder> {

        private final List<TourItem> mValues;

        public TourItemsItemRecyclerViewAdapter(List<TourItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.searchresult_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mView.setTag(position);

            //        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(0,0));
            //     holder.mImageView.setImageBitmap(bitmap);
            if (holder.mItem.getImageURL() != null) {
                imageLoader.displayImage(holder.mItem.getImageURL(), holder.mImageView);

            }
            holder.mContentView.setText(holder.mItem.getLocationName());
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = v.getContext();
                    Intent intent = new Intent(context, SearchResultDetailActivity.class);
                    Integer i = (Integer) v.getTag();
                    TourItem item = items.get(i.intValue());
                    Gson gson = new Gson();
                    String jsonInString = gson.toJson(item);

                    intent.putExtra("TourItem", jsonInString);
                    context.startActivity(intent);

                    //   intent.(SearchResultDetailFragment.ARG_TOUR_ITEM, holder.mItem);

                    //    context.startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final ImageView mImageView;
            public final TextView mContentView;
            public TourItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (ImageView) view.findViewById(R.id.image);
                mContentView = (TextView) view.findViewById(R.id.text);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
