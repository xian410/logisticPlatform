package com.example.demo.management.mapper;

import com.example.demo.management.entity.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 货主信息表 Mapper 接口
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    /**
     * 获取货主名字
     * @param loginId
     * @return
     */
    String getCustomerName(@Param("loginId") String loginId);
}
