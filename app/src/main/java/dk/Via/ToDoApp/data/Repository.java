package dk.Via.ToDoApp.data;


import android.app.Application;

import dk.Via.ToDoApp.model.Task;
import dk.Via.ToDoApp.util.TaskRoomDatabase;

import java.util.List;

import androidx.lifecycle.LiveData;

public class Repository {
    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public Repository(Application application) {
        TaskRoomDatabase database = TaskRoomDatabase.getDatabase(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insert(Task task) {
         TaskRoomDatabase.databaseWriterExecutor.execute( () -> taskDao.insertTask(task));
    }
    public LiveData<Task> get(long id) { return taskDao.get(id); }

    public void update(Task task) {
         TaskRoomDatabase.databaseWriterExecutor.execute(() -> taskDao.update(task));
    }

    public void delete(Task task) {
         TaskRoomDatabase.databaseWriterExecutor.execute(() -> taskDao.delete(task));
    }

}
