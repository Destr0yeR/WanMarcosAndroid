package wan.wanmarcos.utils.Redirection;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import wan.wanmarcos.models.Course;
import wan.wanmarcos.models.Teacher;

/**
 * Created by carlos-pc on 09/10/15.
 */
public interface Redirection {
    void showActivity(AppCompatActivity myPreviousActivity,Class myActivity);
    void showFragment(AppCompatActivity myActivity,int containerID, Fragment fragmentView);
    /*void changeActivity(String tag,Object data);
    void changeActivity(String tag);
    void changeFragment(Object data);
    void toContactanosActivity();
    String getInformation(String key);
    /*void toListTeachers();
    void toShowEvents();
    void toProfileTeacher(Teacher teacher);
    void toTeacherCourseInformation(Course course);
    void addTeacherInformation(Teacher teacher);
    void addCourseInformation(Course course);
    float getFloatInformation(String key);
    int getIntInformation(String key);
<<<<<<< HEAD:app/src/main/java/wan/wanmarcos/utils/Redirection/Redirection.java
    String getStringInformation(String key);*/
}
