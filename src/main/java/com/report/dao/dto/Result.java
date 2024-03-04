package com.report.dao.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "数据传输对象-通用结果")
public class Result {
    @ApiModelProperty(value = "操作结果")
    private boolean success;
    @ApiModelProperty(value = "操作消息")
    private String message;
}
