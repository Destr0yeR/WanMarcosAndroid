package wan.wanmarcos.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wan.wanmarcos.R;
import wan.wanmarcos.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SectionCourseTitle.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SectionCourseTitle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SectionCourseTitle extends Fragment {
    private String name;
    private String teacher;
    public SectionCourseTitle(String name, String teacher){
        this.name=name;
        this.teacher=teacher;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(Constants.COURSE_TITLE,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView editText=(TextView)view.findViewById(R.id.teacher_name);
        editText.setText(teacher);
        TextView editText1=(TextView)view.findViewById(R.id.course_name);
        editText1.setText(name);
    }

}