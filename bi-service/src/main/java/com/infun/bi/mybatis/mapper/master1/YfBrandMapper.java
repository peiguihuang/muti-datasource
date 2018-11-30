package com.infun.bi.mybatis.mapper.master1;

import com.infun.bi.mybatis.domain.YfBrand;
import com.infun.bi.mybatis.domain.YfBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YfBrandMapper {
    int countByExample(YfBrandExample example);

    int deleteByExample(YfBrandExample example);

    int deleteByPrimaryKey(String id);

    int insert(YfBrand record);

    int insertSelective(YfBrand record);

    List<YfBrand> selectByExample(YfBrandExample example);

    YfBrand selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YfBrand record, @Param("example") YfBrandExample example);

    int updateByExample(@Param("record") YfBrand record, @Param("example") YfBrandExample example);

    int updateByPrimaryKeySelective(YfBrand record);

    int updateByPrimaryKey(YfBrand record);
}