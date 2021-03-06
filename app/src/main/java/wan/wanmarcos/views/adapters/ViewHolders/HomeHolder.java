package wan.wanmarcos.views.adapters.ViewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import wan.wanmarcos.R;
import wan.wanmarcos.models.Home;
import wan.wanmarcos.utils.Storage;
import wan.wanmarcos.views.adapters.HomeListAdapter;
import wan.wanmarcos.views.widgets.CircleTransform;

/**
 * Created by carlos-pc on 29/11/15.
 */
public class HomeHolder extends CustomViewHolder<Home>{
    private TextView referenceName;
    private ImageView referenceImage;
    private TextView referenceTypeDescription;
    private TextView referenceDescription;
    private int current;
    private HomeListAdapter fragmentChange;

    public HomeHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        referenceImage=(ImageView)itemView.findViewById(R.id.teacher_item_picture);
        referenceName=(TextView)itemView.findViewById(R.id.home_item_name);
        referenceTypeDescription=(TextView)itemView.findViewById(R.id.home_item_description_label);
        referenceDescription=(TextView)itemView.findViewById(R.id.home_item_description);
    }

    @Override
    public void setElements(Home object) {
        Picasso.with(itemView.getContext()).load(object.getUrl()).transform(new CircleTransform()).into(referenceImage);
        referenceName.setText(object.getName());
        referenceTypeDescription.setText(object.getType());
        referenceDescription.setText(object.getDescription());
        current=object.getId();
    }

    @Override
    public void onClick(View v) {
        if("event".equals(referenceTypeDescription.getText().toString())){
            Storage.getSingelton().storageData(current,Storage.KEY_EVENT_ID);
        }
        else if("professor".equals(referenceTypeDescription.getText().toString())) {
            Storage.getSingelton().storageData(current,Storage.KEY_TEACHER_ID);
        }
        fragmentChange.setFragment(referenceTypeDescription.getText().toString());
        recyclerViewClickListener.recyclerViewListClicked(v,current);
    }

    public void setFragmentChange(HomeListAdapter fragmentChange) {
        this.fragmentChange = fragmentChange;
    }
}
