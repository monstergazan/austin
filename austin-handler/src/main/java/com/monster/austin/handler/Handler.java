package com.monster.austin.handler;

import com.monster.austin.pojo.TaskInfo;

public interface Handler {
    boolean doHandler(TaskInfo taskInfo);
}
