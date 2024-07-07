package com.dev.KafkaConsumer.service;
import java.util.Objects;

public class MyObject{
    private int id;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObject myObject = (MyObject) o;
        return id == myObject.id && Objects.equals(msg, myObject.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, msg);
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }
}