package com.example.demo.entity.base;

import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> implements Serializable {
    public abstract ID getId();

    public abstract void setId(ID sid);
}
