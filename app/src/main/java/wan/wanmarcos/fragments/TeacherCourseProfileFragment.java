package wan.wanmarcos.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wan.wanmarcos.R;
import wan.wanmarcos.models.Course;
import wan.wanmarcos.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeacherCourseProfileFragment extends Fragment {


    public TeacherCourseProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(Constants.FRAGMENT_TEACHER_COURSE_LAYOUT, container, false);
    }
}
