package com.gdgcampinas.backend.service;


import com.gdgcampinas.backend.dao.TaskDAO;
import com.gdgcampinas.backend.dao.TaskDAOImpl;
import com.gdgcampinas.backend.entity.TaskBean;

import java.util.List;

/**
 * Created by thales on 2/21/15.
 */
public class TaskServiceImpl implements TaskService {

    private TaskDAO taskDAO;

    public TaskServiceImpl() {
        taskDAO = new TaskDAOImpl();
    }

    @Override
    public List<TaskBean> list() {
        return taskDAO.listAll();
    }

    @Override
    public void removeAll() {
        taskDAO.delete(list());
    }

    @Override
    public void insert(TaskBean taskBean) {
        taskDAO.insert(taskBean);
    }
}
