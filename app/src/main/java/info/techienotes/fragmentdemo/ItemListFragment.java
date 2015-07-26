package info.techienotes.fragmentdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import info.techienotes.fragmentdemo.dummy.DummyContent;

// ListFragment is also a Fragment with having a list like view already in it.
public class ItemListFragment extends ListFragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemListFragment() {
    }

    // Content in the list.
    private DummyContent dummyContent;

    /**
     * A callback interface that all Activities containing this Fragment must
     * implement. This mechanism allows activities to be notified of item selections.
     */
    public interface Callbacks {
        //  Callback for when an item has been selected.
        public void onItemSelected(String id);
    }

    private Callbacks mCallbacks;

    /**
     * When this Fragment is attached to its host Activity.
     * In onAttach() we are just checking if the host Activity
     * has implemented the Callbacks interface or not.
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    /**
     * In onCreate(), we set content in the list of the ItemListFragment
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dummyContent = new DummyContent();

        /**
         * this function set the adapter for the list provided by default
         * in this ListFragment. It just combines the list of DummyContent
         * Objects to view provided by list.
         */
        setListAdapter(new ArrayAdapter<DummyContent.DummyItem>(
                getActivity(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1, dummyContent.getItemList()));
    }

    /**
     * This function identifies which item in the list was clicked.
     */
    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        // Notify the active callbacks interface (the activity, if the
        // fragment is attached to one) that an item has been selected.
        DummyContent.DummyItem dummy = (DummyContent.DummyItem)dummyContent.getItemList().get(position);
        mCallbacks.onItemSelected(dummy.getId());
    }
}
