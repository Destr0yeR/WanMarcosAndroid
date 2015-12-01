package wan.wanmarcos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import wan.wanmarcos.R;
import wan.wanmarcos.managers.FragmentsMethods;
import wan.wanmarcos.managers.ItemAdapterListener;
import wan.wanmarcos.models.Preference;
import wan.wanmarcos.utils.Builder;
import wan.wanmarcos.utils.Constants;
import wan.wanmarcos.utils.RestClient;
import wan.wanmarcos.views.adapters.PreferenceListAdapter;

/**
 * Created by carlos-pc on 29/11/15.
 */
public class ProfileUserFragment extends Fragment implements FragmentsMethods {

    private PreferenceListAdapter preferenceListAdapter;
    private RecyclerView recyclerViewPreferences;

    public ProfileUserFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(Constants.FRAGMENT_PROFILE_PREFERENCES_LIST,container,false);
        setUpElements(view);
        addListeners();
        return view;
    }

    @Override
    public void setUpElements(View view) {
        recyclerViewPreferences=(RecyclerView)view.findViewById(R.id.preferencesLabel_list);
        //recyclerViewRating=(RecyclerView)view.findViewById(R.id.rating_list);
        preferenceListAdapter=new PreferenceListAdapter(this);
        getData();
        recyclerViewPreferences.setAdapter(preferenceListAdapter);
        //recyclerViewRating.setAdapter(ratingListAdapter);
        recyclerViewPreferences.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerViewRating.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void getData(){
        preferenceListAdapter.add(new Preference("FISI",0));
        preferenceListAdapter.add(new Preference("FISI 2",0));
        preferenceListAdapter.add(new Preference("FISI 3",0));
        preferenceListAdapter.add(new Preference("FISI 4", 0));
        preferenceListAdapter.add(new Preference("FISI 5 ", 0));
        preferenceListAdapter.add(new Preference("FISI 6", 0));
        preferenceListAdapter.add(new Preference("FISI 7", 0));
    }
    @Override
    public void addListeners() {
    }

    public void UpdatePhote(){

    }
}
