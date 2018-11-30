package com.infun.bi.mybatis.domain;

import java.util.Date;

public class YfBrand {
    private String id;

    private String categoryId;

    private String brandName;

    private String brandNameEn;

    private String brandNameAcronym;

    private String internationalBrandType;

    private String brandLogo;

    private String brandDesc;

    private String siteUrl;

    private Integer sortOrder;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private Integer version;

    private Integer isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandNameEn() {
        return brandNameEn;
    }

    public void setBrandNameEn(String brandNameEn) {
        this.brandNameEn = brandNameEn == null ? null : brandNameEn.trim();
    }

    public String getBrandNameAcronym() {
        return brandNameAcronym;
    }

    public void setBrandNameAcronym(String brandNameAcronym) {
        this.brandNameAcronym = brandNameAcronym == null ? null : brandNameAcronym.trim();
    }

    public String getInternationalBrandType() {
        return internationalBrandType;
    }

    public void setInternationalBrandType(String internationalBrandType) {
        this.internationalBrandType = internationalBrandType == null ? null : internationalBrandType.trim();
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo == null ? null : brandLogo.trim();
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc == null ? null : brandDesc.trim();
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl == null ? null : siteUrl.trim();
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}