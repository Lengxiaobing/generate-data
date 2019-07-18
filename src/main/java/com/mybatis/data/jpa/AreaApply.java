package com.mybatis.data.jpa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * TABLE:area_apply
 *
 * @mbg.generated 该代码为自动生成，请不要修改
 *
 * DATE: 2018-11-07 21:53
 */
@Entity
@Table(name="area_apply")
public class AreaApply implements Serializable {
    /**
     * 申请ID
     * area_apply.apply_id
     */
    @Id
    @Column(columnDefinition = "bigint not null Comment '申请ID'")
    private Long applyId;

    /**
     * 班组ID
     * area_apply.team_id
     */
    @Column(columnDefinition = "bigInt Comment '班组ID'")
    private Long teamId;

    /**
     * 申请时间
     * area_apply.create_time
     */
    @Column(columnDefinition = "datetime Comment '申请时间'")
    private Date createTime;

    /**
     * 申请变更人
     * area_apply.create_by
     */
    @Column(columnDefinition = "bigInt Comment '申请变更人'")
    private Long createBy;

    /**
     * 申请备注
     * area_apply.remark
     */
    @Column(columnDefinition = "varchar(256) Comment '申请备注'")
    private String remark;

    /**
     * 申请状态 0 待客服审核 1 客服已审核 2 审核通过 3 审核失败 4 取消申请
     * area_apply.apply_state
     */
    @Column(columnDefinition = "int Comment '申请状态 0 待客服审核 1 客服已审核 2 审核通过 3 审核失败 4 取消申请'")
    private Integer applyState;

    /**
     * 客服审核意见
     * area_apply.audit_suggest
     */
    @Column(columnDefinition = "varchar(256) Comment '客服审核意见'")
    private String auditSuggest;

    /**
     * 系统管理员审核意见
     * area_apply.sm_audit_suggest
     */
    @Column(columnDefinition = "varchar(256) Comment '系统管理员审核意见'")
    private String smAuditSuggest;

    /**
     * TABLE： area_apply
     *
     * @mbg.generated
     *
     * DATE: 2018-11-07 21:53
     */
}
