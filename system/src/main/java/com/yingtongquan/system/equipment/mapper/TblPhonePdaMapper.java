package com.yingtongquan.system.equipment.mapper;

import com.yingtongquan.system.equipment.entity.TblPhonePdaPo;
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
public interface TblPhonePdaMapper extends BaseMapper<TblPhonePdaPo> {

    /**
     * @Date 2020/6/14 15:48
     * @Author 胖
     * 添加手机
     **/
    Boolean addShopPhoneEquipment(TblPhonePdaPo phonePdaPo);

    /**
     * @Date 2020/6/14 17:25
     * @Author 胖
     * 修改手机设备
     **/
    Boolean updatePhoneEquipment(Integer state,Integer id);

    /**
     * @Date 2020/6/14 17:56
     * @Author 胖
     * 删除手机设备
     **/
    Boolean deletePhoneEquipment(Integer equipmentId);
}
