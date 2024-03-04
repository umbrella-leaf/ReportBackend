package com.report.controllers;

import com.report.dao.dto.PageResult;
import com.report.dao.dto.QueryCond;
import com.report.pojo.ReportInfo;
import com.report.service.ReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "报告信息管理")
@RestController
@RequestMapping("/reports")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @ApiOperation(value = "查看报告信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", required = true, dataTypeClass = Integer.class, defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "页大小", required = true, dataTypeClass = Integer.class, defaultValue = "20")
    })
    @GetMapping("/get")
    public PageResult getReportInfo(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size) {
        Page<ReportInfo> result = reportService.findReportInfos(page - 1, size);
        return new PageResult((int) result.getTotalElements(), result.getContent());
    }

    @ApiOperation(value = "查找全部用户昵称")
    @GetMapping("/get_all_nicknames")
    public PageResult getAllNicknames() {
        List<String> result = reportService.findAllNicknames();
        return new PageResult(result.size(), result);
    }

    @ApiOperation(value = "按照给定条件查询报告信息")
    @PostMapping("/get_by_cond")
    public PageResult getReportInfoByCond(@RequestBody QueryCond queryCond,
                                          @RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "20") int size) {
        Page<ReportInfo> result = reportService.findReportInfosByCond(
                page - 1, size,
                queryCond.getStart(),
                queryCond.getEnd(),
                queryCond.getNickname(),
                queryCond.getKeyword()
        );
        return new PageResult((int)result.getTotalElements(), result.getContent());
    }
}
