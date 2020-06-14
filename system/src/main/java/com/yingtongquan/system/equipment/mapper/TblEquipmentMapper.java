package com.yingtongquan.system.equipment.mapper;

import com.yingtongquan.system.equipment.entity.TblEquipmentPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.system.equipment.pojo.DeleteEquipment;
import com.yingtongquan.system.equipment.pojo.UpdateEquipment;
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
public interface TblEquipmentMapper extends BaseMapper<TblEquipmentPo> {

    /**
     * @Date 2020/6/12 17:41
     * @Author 胖
     * 通过UserId查询员工ID
     **/
    Integer queryStaffId(Integer userId);

    /**
     * @Date 2020/6/14 15:42
     * @Author 胖
     * 添加门店设备表
     **/
    Boolean addShopEquipment(TblEquipmentPo equipmentPo);

    /**
     * @Date 2020/6/14 17:21
     * @Author 胖
     * 修改设备表
     **/
    Boolean updateShopEquipment(UpdateEquipment updateEquipment);

    /**
     * @Date 2020/6/14 17:55
     * @Author 胖
     * 删除设备
     **/
    Boolean deleteShopEquipment(DeleteEquipment deleteEquipment);

}
