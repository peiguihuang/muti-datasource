package com.infun.bi.mybatis.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YfBrandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YfBrandExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNull() {
            addCriterion("brand_name is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameIsNotNull() {
            addCriterion("brand_name is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEqualTo(String value) {
            addCriterion("brand_name =", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotEqualTo(String value) {
            addCriterion("brand_name <>", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThan(String value) {
            addCriterion("brand_name >", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name >=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThan(String value) {
            addCriterion("brand_name <", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLessThanOrEqualTo(String value) {
            addCriterion("brand_name <=", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameLike(String value) {
            addCriterion("brand_name like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotLike(String value) {
            addCriterion("brand_name not like", value, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameIn(List<String> values) {
            addCriterion("brand_name in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotIn(List<String> values) {
            addCriterion("brand_name not in", values, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameBetween(String value1, String value2) {
            addCriterion("brand_name between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameNotBetween(String value1, String value2) {
            addCriterion("brand_name not between", value1, value2, "brandName");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnIsNull() {
            addCriterion("brand_name_en is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnIsNotNull() {
            addCriterion("brand_name_en is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnEqualTo(String value) {
            addCriterion("brand_name_en =", value, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnNotEqualTo(String value) {
            addCriterion("brand_name_en <>", value, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnGreaterThan(String value) {
            addCriterion("brand_name_en >", value, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name_en >=", value, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnLessThan(String value) {
            addCriterion("brand_name_en <", value, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnLessThanOrEqualTo(String value) {
            addCriterion("brand_name_en <=", value, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnLike(String value) {
            addCriterion("brand_name_en like", value, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnNotLike(String value) {
            addCriterion("brand_name_en not like", value, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnIn(List<String> values) {
            addCriterion("brand_name_en in", values, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnNotIn(List<String> values) {
            addCriterion("brand_name_en not in", values, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnBetween(String value1, String value2) {
            addCriterion("brand_name_en between", value1, value2, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameEnNotBetween(String value1, String value2) {
            addCriterion("brand_name_en not between", value1, value2, "brandNameEn");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymIsNull() {
            addCriterion("brand_name_acronym is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymIsNotNull() {
            addCriterion("brand_name_acronym is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymEqualTo(String value) {
            addCriterion("brand_name_acronym =", value, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymNotEqualTo(String value) {
            addCriterion("brand_name_acronym <>", value, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymGreaterThan(String value) {
            addCriterion("brand_name_acronym >", value, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name_acronym >=", value, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymLessThan(String value) {
            addCriterion("brand_name_acronym <", value, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymLessThanOrEqualTo(String value) {
            addCriterion("brand_name_acronym <=", value, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymLike(String value) {
            addCriterion("brand_name_acronym like", value, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymNotLike(String value) {
            addCriterion("brand_name_acronym not like", value, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymIn(List<String> values) {
            addCriterion("brand_name_acronym in", values, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymNotIn(List<String> values) {
            addCriterion("brand_name_acronym not in", values, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymBetween(String value1, String value2) {
            addCriterion("brand_name_acronym between", value1, value2, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andBrandNameAcronymNotBetween(String value1, String value2) {
            addCriterion("brand_name_acronym not between", value1, value2, "brandNameAcronym");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeIsNull() {
            addCriterion("international_brand_type is null");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeIsNotNull() {
            addCriterion("international_brand_type is not null");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeEqualTo(String value) {
            addCriterion("international_brand_type =", value, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeNotEqualTo(String value) {
            addCriterion("international_brand_type <>", value, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeGreaterThan(String value) {
            addCriterion("international_brand_type >", value, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeGreaterThanOrEqualTo(String value) {
            addCriterion("international_brand_type >=", value, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeLessThan(String value) {
            addCriterion("international_brand_type <", value, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeLessThanOrEqualTo(String value) {
            addCriterion("international_brand_type <=", value, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeLike(String value) {
            addCriterion("international_brand_type like", value, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeNotLike(String value) {
            addCriterion("international_brand_type not like", value, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeIn(List<String> values) {
            addCriterion("international_brand_type in", values, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeNotIn(List<String> values) {
            addCriterion("international_brand_type not in", values, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeBetween(String value1, String value2) {
            addCriterion("international_brand_type between", value1, value2, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andInternationalBrandTypeNotBetween(String value1, String value2) {
            addCriterion("international_brand_type not between", value1, value2, "internationalBrandType");
            return (Criteria) this;
        }

        public Criteria andBrandLogoIsNull() {
            addCriterion("brand_logo is null");
            return (Criteria) this;
        }

        public Criteria andBrandLogoIsNotNull() {
            addCriterion("brand_logo is not null");
            return (Criteria) this;
        }

        public Criteria andBrandLogoEqualTo(String value) {
            addCriterion("brand_logo =", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoNotEqualTo(String value) {
            addCriterion("brand_logo <>", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoGreaterThan(String value) {
            addCriterion("brand_logo >", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoGreaterThanOrEqualTo(String value) {
            addCriterion("brand_logo >=", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoLessThan(String value) {
            addCriterion("brand_logo <", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoLessThanOrEqualTo(String value) {
            addCriterion("brand_logo <=", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoLike(String value) {
            addCriterion("brand_logo like", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoNotLike(String value) {
            addCriterion("brand_logo not like", value, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoIn(List<String> values) {
            addCriterion("brand_logo in", values, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoNotIn(List<String> values) {
            addCriterion("brand_logo not in", values, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoBetween(String value1, String value2) {
            addCriterion("brand_logo between", value1, value2, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandLogoNotBetween(String value1, String value2) {
            addCriterion("brand_logo not between", value1, value2, "brandLogo");
            return (Criteria) this;
        }

        public Criteria andBrandDescIsNull() {
            addCriterion("brand_desc is null");
            return (Criteria) this;
        }

        public Criteria andBrandDescIsNotNull() {
            addCriterion("brand_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBrandDescEqualTo(String value) {
            addCriterion("brand_desc =", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotEqualTo(String value) {
            addCriterion("brand_desc <>", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescGreaterThan(String value) {
            addCriterion("brand_desc >", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescGreaterThanOrEqualTo(String value) {
            addCriterion("brand_desc >=", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLessThan(String value) {
            addCriterion("brand_desc <", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLessThanOrEqualTo(String value) {
            addCriterion("brand_desc <=", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLike(String value) {
            addCriterion("brand_desc like", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotLike(String value) {
            addCriterion("brand_desc not like", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescIn(List<String> values) {
            addCriterion("brand_desc in", values, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotIn(List<String> values) {
            addCriterion("brand_desc not in", values, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescBetween(String value1, String value2) {
            addCriterion("brand_desc between", value1, value2, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotBetween(String value1, String value2) {
            addCriterion("brand_desc not between", value1, value2, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andSiteUrlIsNull() {
            addCriterion("site_url is null");
            return (Criteria) this;
        }

        public Criteria andSiteUrlIsNotNull() {
            addCriterion("site_url is not null");
            return (Criteria) this;
        }

        public Criteria andSiteUrlEqualTo(String value) {
            addCriterion("site_url =", value, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlNotEqualTo(String value) {
            addCriterion("site_url <>", value, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlGreaterThan(String value) {
            addCriterion("site_url >", value, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlGreaterThanOrEqualTo(String value) {
            addCriterion("site_url >=", value, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlLessThan(String value) {
            addCriterion("site_url <", value, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlLessThanOrEqualTo(String value) {
            addCriterion("site_url <=", value, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlLike(String value) {
            addCriterion("site_url like", value, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlNotLike(String value) {
            addCriterion("site_url not like", value, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlIn(List<String> values) {
            addCriterion("site_url in", values, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlNotIn(List<String> values) {
            addCriterion("site_url not in", values, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlBetween(String value1, String value2) {
            addCriterion("site_url between", value1, value2, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSiteUrlNotBetween(String value1, String value2) {
            addCriterion("site_url not between", value1, value2, "siteUrl");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNull() {
            addCriterion("sort_order is null");
            return (Criteria) this;
        }

        public Criteria andSortOrderIsNotNull() {
            addCriterion("sort_order is not null");
            return (Criteria) this;
        }

        public Criteria andSortOrderEqualTo(Integer value) {
            addCriterion("sort_order =", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotEqualTo(Integer value) {
            addCriterion("sort_order <>", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThan(Integer value) {
            addCriterion("sort_order >", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort_order >=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThan(Integer value) {
            addCriterion("sort_order <", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(Integer value) {
            addCriterion("sort_order <=", value, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderIn(List<Integer> values) {
            addCriterion("sort_order in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotIn(List<Integer> values) {
            addCriterion("sort_order not in", values, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderBetween(Integer value1, Integer value2) {
            addCriterion("sort_order between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andSortOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}