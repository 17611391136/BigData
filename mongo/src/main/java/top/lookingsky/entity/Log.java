package top.lookingsky.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by 李明 on 2018/1/30.
 */
@Document(collection = "coll")
public class Log {
    @Id
    private String id;
    private String name;
    private String time;
    private String operation;

    public Log() {
    }

    @PersistenceConstructor
    public Log(String id, String name, String time, String operation) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.operation = operation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
