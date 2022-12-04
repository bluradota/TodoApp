package dk.Via.ToDoApp.util;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import dk.Via.ToDoApp.model.Priority;
import dk.Via.ToDoApp.model.Task;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        simpleDateFormat.applyPattern("EEE, MMM d");

        return  simpleDateFormat.format(date);

    }
    public static void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }

    public static int priorityColor(Task task) {
        int color;
        if (task.getPriority() == Priority.HIGH) {
             color = Color.argb(255,255, 0, 0);
        }else if (task.getPriority() == Priority.MEDIUM) {
             color = Color.argb(233,155, 179,122);
        }else {
             color = Color.argb(150, 111, 181, 229);
        }
        return color;
    }
}
