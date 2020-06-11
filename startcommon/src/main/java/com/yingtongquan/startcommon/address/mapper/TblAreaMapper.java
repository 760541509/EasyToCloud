package com.yingtongquan.startcommon.address.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.startcommon.address.entity.TblAreaPo;
import com.yingtongquan.startcommon.address.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * <p>
 * 地区码表 Mapper 接口
 * </p>
 *
 * @author Pang
 * @since 2020-05-11
 */
@Mapper
@Repository
public interface TblAreaMapper extends BaseMapper<TblAreaPo> {

    /**
     * @Date 2020/5/11 9:55
     * @Author 胖虎
     * 查询所有省级单位
     **/
    List<TblAreaPo> queryAllProvincial();

    /**
     * @Date 2020/5/11 9:58
     * @Author 胖虎
     * 查询省级下面所有市级单位
     **/
    List<TblAreaPo> queryAllCitiesBelowTheProvincialLevel(Integer parentId);

    /**
     * @Date 2020/5/11 10:03
     * @Author 胖虎
     * 查询市级下面所有的区/县
     **/
    List<TblAreaPo> queryAllDistrictsBelowCityLevel(Integer parentId);

    /**
     * @Date 2020/5/11 11:57
     * @Author 胖虎
     * 逆向查询市和省
     **/
    Address queryCityAndProvincial(Integer areaId);

}
