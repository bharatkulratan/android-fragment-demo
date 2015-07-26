package info.techienotes.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.techienotes.fragmentdemo.dummy.DummyContent;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a ItemListActivity
 * in two-pane mode (on tablets) or a ItemDetailActivity on handsets.
 */
public class ItemDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

     // The dummy content this fragment is presenting.
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment arguments.
            mItem = (DummyContent.DummyItem)new DummyContent().getItemMappings()
                    .get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    /**
     * This method creates and returns the View for the fragment.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View inflated from XML file
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            String detailFragmentString = mItem.content;
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(detailFragmentString);
        }
        return rootView;
    }
}
