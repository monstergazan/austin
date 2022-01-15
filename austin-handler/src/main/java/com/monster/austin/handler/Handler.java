package com.monster.austin.handler;

import com.monster.austin.domain.TaskInfo;

public interface Handler {
    boolean doHandler(TaskInfo taskInfo);
}
