package com.IT.IT4409.model;

public class JobSearchCriteria {

    private String key;

    private String operation;

    private Object value;

    private boolean isOrPredicate;

    public JobSearchCriteria(String key, String operation, Object value, boolean isOrPredicate) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.isOrPredicate = isOrPredicate;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isOrPredicate() {
        return this.isOrPredicate;
    }
}
