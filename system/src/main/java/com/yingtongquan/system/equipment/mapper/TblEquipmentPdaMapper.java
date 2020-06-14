package com.yingtongquan.system.equipment.mapper;

import com.yingtongquan.system.equipment.entity.TblEquipmentPdaPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-06-14
*/
@Mapper
public interface TblEquipmentPdaMapper extends BaseMapper<TblEquipmentPdaPo> {

    /**
     * @Date 2020/6/14 15:55
     * @Author 胖
     * 添加店铺PDA
     **/
    Boolean addShopPDA(TblEquipmentPdaPo equipmentPdaPo);

    /**
     * @Date 2020/6/14 17:26
     * @Author 胖
     * 修改店铺PDA
     **/
    Boolean updateShopPDA(Integer equipmentId,Integer state);

    /**
     * @Date 2020/6/14 17:58
     * @Author 胖
     * 删除店铺PDA
     **/
    Boolean deleteShopPDA(Integer equipmentId);

}
