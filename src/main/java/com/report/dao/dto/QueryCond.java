package com.report.dao.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(description = "数据传输对象-查询条件")
public class QueryCond {
    @ApiModelProperty(value = "昵称", example = "三螺旋DNA")
    private String nickname;

    @ApiModelProperty(value = "开始时间", example = "2023-04-01")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start;

    @ApiModelProperty(value = "结束时间", example = "2023-04-04")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end;

    @ApiModelProperty(value = "关键字", example = "")
    private String keyword;
}
