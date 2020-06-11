package com.yingtongquan.employees.brand.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.brand.entity.TblGoodsBrandPo;
import com.yingtongquan.employees.brand.entity.TblGoodsBrandPo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-23
*/
@Mapper
@Repository
public interface TblGoodsBrandMapper extends BaseMapper<TblGoodsBrandPo> {

    Boolean addInfo(TblGoodsBrandPoAddPa info);

    Boolean addBatchInfo(List<TblGoodsBrandPoAddPa> info);

    Boolean updateInfo(TblGoodsBrandPoUpPa info);

    Boolean deleteByInfo(TblGoodsBrandPoDelPa info);

    TblGoodsBrandPo getByInfo(TblGoodsBrandPoGetPa info);

    List<TblGoodsBrandPo> getListByInfo(TblGoodsBrandPoGetListPa info);

    List<TblGoodsBrandPo> getListByShopId(Integer fkShopId);

}
