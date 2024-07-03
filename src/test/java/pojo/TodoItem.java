package pojo;

import com.google.gson.annotations.SerializedName;
import io.cucumber.java.ParameterType;

import java.util.Objects;

/**
 * POJO to represent JSON structure for jsonplaceholder.typicode.com/todos/1" response
 */

//using @SerialisedName annotation to avoid using getters and setters
//This annotation maps the JSON keys to the corresponding fields in your Java class

public class TodoItem{

    public TodoItem(int userId, int id, String title, boolean completed){
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.completed = completed;
    }

@SerializedName("userId")
    private int userId;

@SerializedName("id")
    private int id;

@SerializedName("title")
    private String title;

@SerializedName("completed")
    private boolean completed;

@Override
    public String toString(){
    return "pojo.TodoItem{" +
            "userId=" + userId +
            ", id=" + id +
            ", title='" + title + '\'' +
            ", completed=" + completed +
            '}';
}


    // Override equals and hashCode for proper comparison

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (userId != todoItem.userId) return false;
        if (id != todoItem.id) return false;
        if (completed != todoItem.completed) return false;
        return Objects.equals(title, todoItem.title);
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (completed ? 1 : 0);
        return result;
    }

}