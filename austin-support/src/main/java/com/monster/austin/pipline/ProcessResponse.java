package com.monster.austin.pipline;

import lombok.Builder;

/**
 * @cription 流程处理的结果
 */
@Builder
public class ProcessResponse {

    /** 返回值编码 */
    private final String code;

    /** 返回值描述 */
    private final String description;

}
