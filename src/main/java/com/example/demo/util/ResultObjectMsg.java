package com.example.demo.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: leesanghyuk
 * Date: 2019-05-15 16:38
 * Description:返回类型包装工具类
 */
public class ResultObjectMsg<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private T obj;
    private String menu_name;
    private String type;
    private String des;
    private String remarks;
    private Map<String, Object> par = new HashMap();

    public Map<String, Object> getPar() {
        return this.par;
    }

    public void setPar(Map<String, Object> par) {
        this.par.putAll(par);
    }

    public void setPar(String key, Object value) {
        this.getPar().put(key, value);
    }

    public String getDes() {
        return this.des;
    }

    public ResultObjectMsg<T> setDes(String des) {
        this.des = des;
        return this;
    }

    public ResultObjectMsg(int code, String msg, T obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

    public ResultObjectMsg(String msg) {
        this.code = -1;
        this.msg = msg;
        this.obj = null;
    }

    public ResultObjectMsg() {
        this.code = 0;
        this.msg = "ok";
    }

    public ResultObjectMsg(T t) {
        this.code = 0;
        this.msg = "ok";
        this.obj = t;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.code, this.msg, this.menu_name, this.type, this.des);
    }

    public String toJsonString() {
        return String.format("{\"code\":\"%s\",\"msg\":\"%s\"}", this.code, this.msg);
    }

    public T getObj() {
        return this.obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getCode() {
        return this.code;
    }

    public ResultObjectMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultObjectMsg<T> createOkMsg(String msg) {
        this.code = 0;
        this.msg = msg;
        return this;
    }

    public ResultObjectMsg<T> createErrorMsg(String msg) {
        this.code = -1;
        this.msg = msg;
        return this;
    }

    public ResultObjectMsg<T> createOkMsg() {
        this.code = 0;
        this.msg = "ok";
        return this;
    }

    public ResultObjectMsg<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public ResultObjectMsg<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getMenu_name() {
        return this.menu_name;
    }

    public ResultObjectMsg<T> setMenu_name(String menu_name) {
        this.menu_name = menu_name;
        return this;
    }

    public String getType() {
        return this.type;
    }

    public ResultObjectMsg<T> setType(String type) {
        this.type = type;
        return this;
    }

    public ResultObjectMsg<T> setTypeCreate() {
        this.type = "create";
        return this;
    }

    public ResultObjectMsg<T> setTypeUpdate() {
        this.type = "update";
        return this;
    }

    public ResultObjectMsg<T> setTypeSave() {
        this.type = "save";
        return this;
    }

    public ResultObjectMsg<T> setTypeDelete() {
        this.type = "delete";
        return this;
    }

    public ResultObjectMsg<T> setTypeSelect() {
        this.type = "select";
        return this;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}