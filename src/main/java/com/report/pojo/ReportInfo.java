package com.report.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@EntityListeners(value = AuditingEntityListener.class)
@Entity
@Table(name = "report_message_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(value = "报告信息对象", description = "外挂频道报告信息的实体对象")
public class ReportInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "昵称")
    @Column(nullable = false)
    private String nickname;

    @ApiModelProperty(value = "头像地址")
    @Column(nullable = false)
    private String avatar_url;

    @ApiModelProperty(value = "信息")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @ApiModelProperty(value = "附件地址")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String appendix;

    @ApiModelProperty(value = "发送时间")
    @Column(nullable = false, updatable = false)
    private String send_time;
}
