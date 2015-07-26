package info.techienotes.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * An activity representing a single Item detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a ItemListActivity.
 */
public class ItemDetailActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ItemDetailFragment.ARG_ITEM_ID));

            //Instantiate the Fragment to be added later in this Activity
            ItemDetailFragment itemDetailFragment = new ItemDetailFragment();

            /**
             * set the arguments received in the Intent from
             * the previous Activity which started this Activity
             */
            itemDetailFragment.setArguments(arguments);

            /**
             * Create a FragmentManager which is used to
             * manage all the Fragments in an Activity.
             */
            FragmentManager mFragmentManager = getSupportFragmentManager();

            // Create a FragmentTransaction
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction = mFragmentTransaction
                    .add(R.id.item_detail_container, itemDetailFragment);
            mFragmentTransaction.commit();
        }
    }
}
