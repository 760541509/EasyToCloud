package com.yingtongquan.employees.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.shop.entity.TblLogisticsCompanyPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-21
*/
@Mapper
@Repository
public interface TblLogisticsCompanyMapper extends BaseMapper<TblLogisticsCompanyPo> {

    /**
     * @Date 2020/5/23 14:02
     * @Author 胖
     * 添加店铺物流公司表
     **/
    Boolean addShopLogisticsCompany(TblLogisticsCompanyPo logisticsCompanyPo);

    /**
     * @Date 2020/5/23 14:05
     * @Author 胖
     * 删除店铺物流表
     **/
    Boolean deleteShopLogisticsCompany(Integer id);

    /**
     * @Date 2020/5/23 14:06
     * @Author 胖
     * 修改店铺物流表
     **/
    Boolean updateShopLogisticsCompany(TblLogisticsCompanyPo logisticsCompanyPo);

    /**
     * @Date 2020/5/23 14:06
     * @Author 胖
     * 查询店铺物流表
     **/
    List<TblLogisticsCompanyPo> queryAllShopLogisticsCompany(Integer shopId);

}
