package com.example.demo.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.management.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.management.entity.request.GetAccountRequest;
import com.example.demo.management.entity.response.AllAccountResponse;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 账户信息表 Mapper 接口
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface AccountMapper extends BaseMapper<Account> {


    IPage<AllAccountResponse> queryAll(IPage<AllAccountResponse> queryPageRequest,
                                       @Param("getAccountRequest") GetAccountRequest getAccountRequest);

    IPage<AllAccountResponse> queryAllCustomer(IPage<AllAccountResponse> queryPageRequest,
                                               @Param("getAccountRequest") GetAccountRequest getAccountRequest);
}
