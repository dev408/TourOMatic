package com.a408group.touromatic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a408group.model.GoogleRouteLegWrapper;
import com.a408group.model.RouteLegWrapperInterface;
import com.a408group.model.TourItem;
import com.a408group.model.TourRoute;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by michael on 9/20/17.
 */




/**
 * An activity representing a list of search_results. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link SearchResultDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class RouteLegsListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    public static final String EXTRA_OBJ = "key.EXTRA_OBJ";
    public static final String EXTRA_NOTIF_FLAG = "key.EXTRA_NOTIF_FLAG";
    ImageLoader imageLoader = null;
    // give preparation animation activity transition

    public static List<GoogleRouteLegWrapper> items = null;
    TourRoute tourRoute=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (imageLoader == null) {
            imageLoader = ImageLoader.getInstance(); // Get singleton instance
            imageLoader.init(ImageLoaderConfiguration.createDefault(RouteLegsListActivity.this));
        }
        setContentView(R.layout.activity_tourlegs_list);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        String tourRouteJSON = (String) b.get("TourRoute");
        Gson gson = new Gson();
        tourRoute = gson.fromJson(tourRouteJSON, TourRoute.class);
        setItems(tourRoute.getLegs());
 //       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);
    //    toolbar.setTitle(getTitle());
        Button showMapButton= (Button) findViewById(R.id.show_map);

        showMapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(RouteLegsListActivity.this,RouteSummaryMapActivity.class);
                String points=tourRoute.getOveryviewPolylinePoints();

                intent.putExtra("PolylineOverview", points);
                Gson gson = new Gson();
                String jsonInString = gson.toJson(tourRoute);
                intent.putExtra("TourRoute", jsonInString);
                startActivity(intent);

            }
        });
    }



    public void setItems(List<GoogleRouteLegWrapper> items) {
        View recyclerView = findViewById(R.id.tourlegs_list);
        assert recyclerView != null;
        this.items = items;
        setupRecyclerView((RecyclerView) recyclerView, items);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView, List<GoogleRouteLegWrapper> items) {
        recyclerView.setAdapter(new  RouteLegsRecyclerViewAdapter(items));
    }

    public class  RouteLegsRecyclerViewAdapter
            extends RecyclerView.Adapter< RouteLegsRecyclerViewAdapter.ViewHolder> {

        private final List<GoogleRouteLegWrapper> mValues;

        public  RouteLegsRecyclerViewAdapter(List<GoogleRouteLegWrapper> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.tourlegs_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mView.setTag(position);

            //        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(0,0));
            //     holder.mImageView.setImageBitmap(bitmap);
            if (holder.mItem.getTourItem().getImageURL() != null) {
                imageLoader.displayImage(holder.mItem.getTourItem().getImageURL(), holder.mImageView);

            }
            holder.mContentView.setText(holder.mItem.getTourItem().getLocationName());
            holder.mStart.setText(holder.mItem.getTourItem().getAddress());
        //    holder.mStart.setText(holder.mItem.getLeg().getStartAddress());
     //       holder.mEnd.setText(holder.mItem.getLeg().getEndAddress());
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = v.getContext();

                    Integer i = (Integer) v.getTag();
                    TourItem item = items.get(i.intValue()).getTourItem();
                    String origin="";
                    if(i==0) {
                        origin = tourRoute.getStartLocation();
                    }
                    else {
                        TourItem lastItem= items.get(i.intValue()-1).getTourItem();
                        origin = lastItem.getAddress();
                    }
                    String destination=item.getAddress();
                    String url="https://www.google.com/maps/dir/?api=1&" + "origin=" + origin + "&" + "destination=" + destination;
                    openWebPage(url);

                }
            });

        }
        public void openWebPage(String url) {

        //    Uri webpage = Uri.parse(Uri.encode(url));
            Uri webpage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final ImageView mImageView;
            public final TextView mContentView;
            public final TextView mStart;
            public final TextView mEnd;
            public RouteLegWrapperInterface mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mImageView = (ImageView) view.findViewById(R.id.image);
                mContentView = (TextView) view.findViewById(R.id.text);
                mStart = (TextView) view.findViewById(R.id.Start);
                mEnd = (TextView) view.findViewById(R.id.End);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
