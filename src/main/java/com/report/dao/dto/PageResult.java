package com.report.dao.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "数据传输对象-分页结果")
public class PageResult {
    @ApiModelProperty(value = "总条数")
    Integer total;
    @ApiModelProperty(value = "结果集")
    List rows;
}
