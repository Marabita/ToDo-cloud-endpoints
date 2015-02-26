/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.gdgcampinas.backend.endpoint;

import com.gdgcampinas.backend.entity.TaskBean;
import com.gdgcampinas.backend.service.TaskService;
import com.gdgcampinas.backend.service.TaskServiceImpl;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.List;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(name = "taskApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.gdgcampinas.com", ownerName = "backend.gdgcampinas.com", packagePath = ""))
public class TaskEndpoint {

    private TaskService taskService;

    public TaskEndpoint() {
        taskService = new TaskServiceImpl();
    }

    //POST https://<project_id>.appspot.com/_ah/api/taskApi/v1/tasks
    @ApiMethod(name = "storeTask", path = "tasks", httpMethod = ApiMethod.HttpMethod.POST)
    public void storeTask(TaskBean taskBean) {
        taskService.insert(taskBean);
    }


    //GET https://<project_id>.appspot.com/_ah/api/taskApi/v1/tasks
    @ApiMethod(name = "getTasks", path = "tasks", httpMethod = ApiMethod.HttpMethod.GET)
    public List<TaskBean> getTasks() {
        return taskService.list();
    }


    //DELETE https://<project_id>.appspot.com/_ah/api/taskApi/v1/tasks
    @ApiMethod(name = "clearTasks", path = "tasks", httpMethod = ApiMethod.HttpMethod.DELETE)
    public void clearTasks() {
        taskService.removeAll();
    }
}
