package pojo;

import com.google.gson.annotations.SerializedName;

/**
 * POJO to represent JSON structure for jsonplaceholder.typicode.com/todos/1" response
 */

//using @SerialisedName annotation to avoid using getters and setters
//This annotation maps the JSON keys to the corresponding fields in your Java class

public class TodoItem{

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
}