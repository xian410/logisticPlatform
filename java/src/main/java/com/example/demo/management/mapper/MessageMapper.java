package com.example.demo.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.management.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.management.entity.request.AddMessageRequest;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.response.SelectMessageResponse;
import com.example.demo.management.entity.response.SelectTradingRecordResponse;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 消息表 Mapper 接口
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-12-02
 */
public interface MessageMapper extends BaseMapper<Message> {
    /**
     * 查看消息
     */
    IPage<SelectMessageResponse> selectMessages(IPage<SelectMessageResponse> queryPageRequest,
                                                           @Param("loginId") String loginId);
}
