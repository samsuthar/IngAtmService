package com.backbase.assignment.model;

import java.util.List;

/**
 * Created by rahuja on 23/07/16.
 */
public class Response<E> {

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    private List<E> list;
}
