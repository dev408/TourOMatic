package com.a408group.touromatic;

import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.a408group.model.TourItem;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * A fragment representing a single search_result detail screen.
 * This fragment is either contained in a {@link SearchResultListActivity}
 * in two-pane mode (on tablets) or a {@link SearchResultDetailActivity}
 * on handsets.
 */
public class SearchResultDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_TOUR_ITEM = "TourItem";

    /**
     * The dummy content this fragment is presenting.
     */
    private TourItem tourItem;
    ImageLoader imageLoader = null;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SearchResultDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (imageLoader == null) {
            imageLoader = ImageLoader.getInstance(); // Get singleton instance
        }
        if (getArguments().containsKey(ARG_TOUR_ITEM)) {
            Gson gson = new Gson();
            String tourItemJSON = getArguments().getString(ARG_TOUR_ITEM);

            tourItem = gson.fromJson(tourItemJSON, TourItem.class);
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            //   mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_TOUR_ITEM));

            SearchResultDetailActivity activity = (SearchResultDetailActivity) this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(tourItem.getLocationName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.searchresult_detail, container, false);
        // Show the dummy content as text in a TextView.
        if (tourItem != null) {
            ImageView iv = (ImageView) rootView.findViewById(R.id.detailImageView);
            imageLoader.displayImage(tourItem.getImageURL(), iv);
            WebView wv=(WebView) rootView.findViewById(R.id.description);

            wv.loadData(tourItem.getText() + "...." , "text/html; charset=utf-8", "utf-8");
            TextView tv=(TextView) rootView.findViewById(R.id.website);
            tv.setText(tourItem.getUrl());

        }
        return rootView;
    }
}
