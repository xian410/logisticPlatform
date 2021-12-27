package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.exception.CustomException;
import com.example.demo.management.entity.Account;
import com.example.demo.management.entity.constact.Common;
import com.example.demo.management.entity.request.AddTradingRecordRequest;
import com.example.demo.management.entity.request.GetAccountRequest;
import com.example.demo.management.entity.response.AllAccountResponse;
import com.example.demo.management.entity.response.SelectGoodListResponse;
import com.example.demo.management.mapper.AccountMapper;
import com.example.demo.management.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.management.service.TradingRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 账户信息表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Resource
    AccountMapper accountMapper;

    @Resource
    TradingRecordService tradingRecordService;

    @Override
    public void modMoney(String loginId, Float money) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class)
                                                    .eq(Account::getLoginId, loginId));
        if (account == null) {
            throw new CustomException(1, "账号不存在");
        }

        float m = account.getMoney();
        m  += money;
        account.setMoney(m);
        accountMapper.updateById(account);
    }

    @Override
    public void addMoney(String loginId, Float money) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class)
                .eq(Account::getLoginId, loginId));
        if (account == null) {
            throw new CustomException(1, "账号不存在");
        }

        float m = account.getMoney();
        if (money < 0) {
            throw new CustomException(1, "充值不能为负");
        }

        m  += money;
        account.setMoney(m);

        accountMapper.updateById(account);

        //增加交易记录
        AddTradingRecordRequest addTradingRecordRequest = new AddTradingRecordRequest();
        addTradingRecordRequest.setLoginId(loginId);
        addTradingRecordRequest.setStatus(Common.INVEST);
        //没用订单编号，订单默认为0
        //来源为系统，默认为0
        addTradingRecordRequest.setFees(money);
        tradingRecordService.addRecord(addTradingRecordRequest);


    }

    @Override
    public Float queryMoney(String loginId) {
        Account account = accountMapper.selectOne(Wrappers.lambdaQuery(Account.class)
                .eq(Account::getLoginId, loginId));
        if (account == null) {
            throw new CustomException(1, "账号不存在");
        }
        return account.getMoney();
    }

    @Override
    public IPage<AllAccountResponse> queryAll(GetAccountRequest getAccountRequest) {
        IPage<AllAccountResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(getAccountRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(getAccountRequest.getPageRequest().getSize());
        //根据姓名模糊查询司机
        IPage<AllAccountResponse> customer = accountMapper.queryAllCustomer(queryPageRequest, getAccountRequest);
        List<AllAccountResponse> customerRecords = customer.getRecords();
        Collection<AllAccountResponse> s = customerRecords;
        IPage<AllAccountResponse> driver = accountMapper.queryAll(queryPageRequest, getAccountRequest);
        List<AllAccountResponse> driverRecords = driver.getRecords();
        driverRecords.addAll(s);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (AllAccountResponse record : driverRecords) {
            if ("1".equals(record.getType())) {
                record.setType("司机");
            }
            else {
                record.setType("货主");
            }
            String data = dtf.format(record.getTime());
            record.setTime1(data);
        }
        return driver;
    }

    @Override
    public void modMoneyById(String loginId, Float money) {
        Account account = new Account();
        account.setMoney(money);
        accountMapper.update(account, new UpdateWrapper<Account>().eq("login_id", loginId));
    }
}
