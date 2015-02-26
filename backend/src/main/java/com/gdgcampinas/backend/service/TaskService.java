package com.gdgcampinas.backend.service;

import com.gdgcampinas.backend.entity.TaskBean;

import java.util.List;

/**
 * Created by thales on 2/21/15.
 */
public interface TaskService {
    List<TaskBean> list();
    void removeAll();
    void insert(TaskBean taskBean);
}
