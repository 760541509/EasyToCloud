package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-30
*/
@Mapper
@Repository
public interface TblGoodsSkuSpecValueMapper extends BaseMapper<TblGoodsSkuSpecValuePo> {

    Boolean addInfo(TblGoodsSkuSpecValuePoAddPa info);

    Boolean addBatchInfo(List<TblGoodsSkuSpecValuePoAddPa> info);

    Boolean updateInfo(TblGoodsSkuSpecValuePoUpPa info);

    Boolean deleteByInfo(TblGoodsSkuSpecValuePoDelPa info);

    TblGoodsSkuSpecValuePo getByInfo(TblGoodsSkuSpecValuePoGetPa info);

    List<TblGoodsSkuSpecValuePo> getListByInfo(TblGoodsSkuSpecValuePoGetListPa info);

}
