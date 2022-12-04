package dk.Via.ToDoApp.adapter;

import dk.Via.ToDoApp.model.Task;

public interface OnTodoClickListener {
    void onTodoClick(Task task);
    void onTodoRadioButtonClick(Task task);
}
