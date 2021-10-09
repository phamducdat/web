package com.IT.IT4409.model;

import com.IT.IT4409.entity.JobPost;

import java.util.List;

public class AjaxResponseBody {
    String msg;
    List<JobPost> links;
    String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<JobPost> getLinks() {
        return links;
    }

    public void setLinks(List<JobPost> links) {
        this.links = links;
    }
}
