package com.infun.bi.mybatis.mapper.master2;

import com.infun.bi.mybatis.domain.YfOrders;
import com.infun.bi.mybatis.domain.YfOrdersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YfOrdersMapper {
    int countByExample(YfOrdersExample example);

    int deleteByExample(YfOrdersExample example);

    int deleteByPrimaryKey(String id);

    int insert(YfOrders record);

    int insertSelective(YfOrders record);

    List<YfOrders> selectByExample(YfOrdersExample example);

    YfOrders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YfOrders record, @Param("example") YfOrdersExample example);

    int updateByExample(@Param("record") YfOrders record, @Param("example") YfOrdersExample example);

    int updateByPrimaryKeySelective(YfOrders record);

    int updateByPrimaryKey(YfOrders record);

    int updateByOrderState(YfOrders yfOrders);

    YfOrders selectByOrderSheetId(YfOrders yfOrders);
}