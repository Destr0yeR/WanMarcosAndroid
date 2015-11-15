package wan.wanmarcos.views.adapters;

import android.content.Context;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import wan.wanmarcos.R;
import wan.wanmarcos.managers.ItemAdapterListener;
import wan.wanmarcos.managers.ViewHolderSetters;
import wan.wanmarcos.models.Teacher;
import wan.wanmarcos.utils.Constants;
import wan.wanmarcos.views.widgets.CircleTransform;

public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.TeacherHolder> {
    private LayoutInflater inflater;
    private List<Teacher> teachers= new ArrayList<>();
    private ItemAdapterListener itemAdapterListener;
    private Object mLock;

    public TeacherListAdapter(Context context){
        inflater= LayoutInflater.from(context);
    }
    @Override
    public TeacherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(Constants.TEACHER_NEW_ITEM, parent, false);
        TeacherHolder teacherCustomer = new TeacherHolder(view);
        return teacherCustomer;
    }

    @Override
    public void onBindViewHolder(TeacherHolder holder, int position) {
        Teacher teacher=teachers.get(position);
        holder.setElements(teacher);
    }

    public void setListener(ItemAdapterListener listener){
        this.itemAdapterListener =listener;
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public synchronized void add(Teacher teacher){
            teachers.add(0,teacher);
            notifyItemInserted(0);
    }

    public class  TeacherHolder extends RecyclerView.ViewHolder implements ViewHolderSetters<Teacher>,View.OnClickListener{
        private TextView teacherName;
        private RatingBar teacherRating;
        private ImageView teacherImage;
        private TextView teacherCourses;
        private TextView teacherAssumptions;
        private View vista;
        private Teacher current;
        public TeacherHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            teacherName= (TextView) itemView.findViewById(R.id.teacher_item_name);
            teacherRating=(RatingBar)itemView.findViewById(R.id.teacher_item_ratingbar);
            teacherImage=(ImageView)itemView.findViewById(R.id.teacher_item_picture);
            teacherCourses=(TextView)itemView.findViewById(R.id.teacher_item_courses);
            teacherAssumptions=(TextView)itemView.findViewById(R.id.teacher_item_faculties);
            vista=itemView;
        }

        @Override
        public void setElements(Teacher elements) {
            current=elements;
            teacherName.setText(elements.getName());
            teacherRating.setRating(elements.getRaiting());

            teacherCourses.setText(vista.getContext().getString(R.string.teacher_courses)+ elements.getFaculties());
            teacherAssumptions.setText(vista.getContext().getString(R.string.teacher_faculties)+elements.getDescription());
            Picasso.with(vista.getContext()).load(elements.getImageUrl()).transform(new CircleTransform()).into(teacherImage);
        }

        @Override
        public void onClick(View v) {
            itemAdapterListener.itemClicked(v,current);
        }
    }
    public void addAll(final List<Teacher> teacher) {
        final int currentCount = teacher.size();
        synchronized(teachers) {
            teachers.addAll(teacher);
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            notifyItemRangeInserted(currentCount, teacher.size());
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    notifyItemRangeInserted(currentCount, teacher.size());
                }
            });
        }
    }
}