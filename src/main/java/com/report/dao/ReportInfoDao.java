package com.report.dao;

import com.report.pojo.ReportInfo;
import com.report.utils.annotations.MyCustomQueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ReportInfoDao extends JpaRepository<ReportInfo, Integer>, JpaSpecificationExecutor<ReportInfo> {

//    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
    @MyCustomQueryHint
    @Query("select r from ReportInfo r")
    Page<ReportInfo> findReportInfos(Pageable pageable);

    @MyCustomQueryHint
    @Query("select distinct(r.nickname) from ReportInfo r")
    List<String> findAllNicknames();

    @MyCustomQueryHint
    @Query("select r from ReportInfo r where " +
            "((:start is null) or (:rangeQuery = true and DATE(r.send_time) between :start and :end) or " +
            "(:equalQuery = true and DATE(r.send_time) = :start)) and " +
            "(:nicknameBlank = true or r.nickname = :nickname) and " +
            "(:keywordBlank = true or r.message like :keyword)")
    Page<ReportInfo> findReportInfosByCond(Pageable pageable,
                                           @Param("rangeQuery") boolean rangeQuery,
                                           @Param("equalQuery") boolean equalQuery,
                                           @Param("nicknameBlank") boolean nicknameBlank,
                                           @Param("keywordBlank") boolean keywordBlank,
                                           @Param("start") Date start,
                                           @Param("end") Date end,
                                           @Param("nickname") String nickname,
                                           @Param("keyword") String keyword);
}
