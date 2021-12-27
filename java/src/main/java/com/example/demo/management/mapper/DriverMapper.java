package com.example.demo.management.mapper;

import com.example.demo.management.entity.Driver;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 司机信息表 Mapper 接口
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface DriverMapper extends BaseMapper<Driver> {
    /**
     * 获取司机名字
     * @param loginId
     * @return
     */
    String getDriverName(@Param("loginId") String loginId);
}
