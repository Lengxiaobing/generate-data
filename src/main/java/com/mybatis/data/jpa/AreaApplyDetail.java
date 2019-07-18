package com.mybatis.data.jpa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

/**
 *
 * TABLE:area_apply_detail
 *
 * @mbg.generated 该代码为自动生成，请不要修改
 *
 * DATE: 2018-11-08 10:32
 */
@Entity
@Table(name="area_apply_detail")
public class AreaApplyDetail implements Serializable {
    /**
     * 主键ID
     * area_apply_detail.seq_id
     */
    @Id
    @Column(columnDefinition = "bigint not null Comment '主键ID'")
    private Long seqId;

    /**
     * 申请ID
     * area_apply_detail.apply_id
     */
    @Column(columnDefinition = "bigInt Comment '申请ID'")
    private Long applyId;

    /**
     * 变更类型 1 增加 2 减少
     * area_apply_detail.change_type
     */
    @Column(columnDefinition = "int Comment '变更类型 1 增加 2 减少'")
    private Integer changeType;

    /**
     * 负责区域(省ID)
     * area_apply_detail.province_id
     */
    @Column(columnDefinition = "bigInt Comment '负责区域(省ID)'")
    private Long provinceId;

    /**
     * 负责区域(市ID)
     * area_apply_detail.city_id
     */
    @Column(columnDefinition = "bigInt Comment '负责区域(市ID)'")
    private Long cityId;

    /**
     * 负责区域(区ID)
     * area_apply_detail.area_id
     */
    @Column(columnDefinition = "bigInt Comment '负责区域(区ID)'")
    private Long areaId;

    /**
     * 负责区域(街道ID)
     * area_apply_detail.street_id
     */
    @Column(columnDefinition = "bigInt Comment '负责区域(街道ID)'")
    private Long streetId;

    /**
     * 负责区域(省)
     * area_apply_detail.province
     */
    @Column(columnDefinition = "varchar(256) Comment '负责区域(省)'")
    private String province;

    /**
     * 负责区域(市)
     * area_apply_detail.city
     */
    @Column(columnDefinition = "varchar(256) Comment '负责区域(市)'")
    private String city;

    /**
     * 负责区域(区)
     * area_apply_detail.area
     */
    @Column(columnDefinition = "varchar(256) Comment '负责区域(区)'")
    private String area;

    /**
     * 负责区域(街道)
     * area_apply_detail.street
     */
    @Column(columnDefinition = "varchar(256) Comment '负责区域(街道)'")
    private String street;

    /**
     * TABLE： area_apply_detail
     *
     * @mbg.generated
     *
     * DATE: 2018-11-08 10:32
     */
}
