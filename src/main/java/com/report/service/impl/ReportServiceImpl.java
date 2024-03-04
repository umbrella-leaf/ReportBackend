package com.report.service.impl;

import com.report.dao.ReportInfoDao;
import com.report.pojo.ReportInfo;
import com.report.service.ReportService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportInfoDao reportInfoDao;

    public ReportServiceImpl(ReportInfoDao reportInfoDao) {
        this.reportInfoDao = reportInfoDao;
    }

    @Override
    public Page<ReportInfo> findReportInfos(int page, int size) {
        return reportInfoDao.findReportInfos(PageRequest.of(page, size));
    }

    @Override
    public List<String> findAllNicknames() {
        return reportInfoDao.findAllNicknames();
    }

    @Override
    public Page<ReportInfo> findReportInfosByCond(int page, int size, Date begin, Date end, String nickname, String keyword) {
        boolean rangeQuery = begin != null && end != null;
        boolean equalQuery = !rangeQuery && begin != null;
        boolean nicknameBlank = nickname == null || nickname.isBlank();
        boolean keywordBlank = keyword == null || keyword.isBlank();
        if (!keywordBlank) keyword = "%" + keyword.strip() + "%";
        return reportInfoDao.findReportInfosByCond(PageRequest.of(page, size), rangeQuery, equalQuery,
                                                    nicknameBlank, keywordBlank, begin, end, nickname, keyword);
    }
}
