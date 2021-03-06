package wan.wanmarcos.views.adapters;

import android.support.v4.app.Fragment;
import android.view.View;

import java.io.File;

import wan.wanmarcos.models.Preference;
import wan.wanmarcos.utils.Constants;
import wan.wanmarcos.views.adapters.ViewHolders.CustomHeaderViewHolder;
import wan.wanmarcos.views.adapters.ViewHolders.CustomViewHolder;
import wan.wanmarcos.views.adapters.ViewHolders.PreferenceHolder;
import wan.wanmarcos.views.adapters.ViewHolders.UserProfileHeaderHolder;

/**
 * Created by Francisco on 1/12/2015.
 */
public class PreferenceListAdapter extends CustomDoubleAdapter<Preference> {
    private UserProfileHeaderHolder holder;
    public PreferenceListAdapter(Fragment fragment) {
        super(fragment, Constants.PREFERENCE_NEW_ITEM, Constants.USER_PROFILE_HEADER);
    }

    @Override
    public CustomViewHolder getObject(View view) {
        return new PreferenceHolder(view);
    }
    @Override
    public CustomHeaderViewHolder getObjectHeader(View view) {
        holder = new UserProfileHeaderHolder(view);
        return holder;

    }
    @Override
        public int getContainerID() {
            return Constants.PROFILE_CONTAINER;
        }

    @Override
    public String getFragmentName() {
        return Constants.FRAGMENT_PROFILE;
    }

    public void UpdatePhoto(File img)
    {
        holder.UpdatePhoto(img);
    }
}
