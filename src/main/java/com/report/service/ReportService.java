package com.report.service;

import com.report.pojo.ReportInfo;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface ReportService {
    Page<ReportInfo> findReportInfos(int page, int size);
    List<String> findAllNicknames();
    Page<ReportInfo> findReportInfosByCond(int page, int size, Date begin, Date end, String nickname, String keyword);
}
