/*
* 接口文档，所有接口都写在这，调用的时候
*
* */
const apiUrls = {
    login_user: {
        register: '/management/login-user/register',
        login: "/management/login-user/login",
        adminLogin: "/management/login-user/adminLogin",
        logout: "/management/login-user/logout",
        getUserType: "/management/login-user/getUserType",
        changePassword: "/management/login-user/changePassword",
        delUser: "/management/login-user/delUser"
    },
    goods:{
        addGood: "/management/goods/addGood",
        modGood: "/management/goods/modGood",
        delGood: "/management/goods/delGood",
        selectAllGoods: "/management/goods/selectAllGoods",
        selectCustomerGoods: "/management/goods/selectCustomerGoods",
        getAllTrueGoods: "/management/goods/selectAllTrueGoods",
        delGoodById: "/management/goods/delGoodByManager"
    },
    goodType: {
        getGoodTypes: "/management/goods-type/getGoodTypes"
    },
    carType: {
        getCarTypes: "/management/car-type/getCarTypes"
    },
    driverIntention: {
        addIntention: "/management/driver-intention/addIntention",
        deleteIntention: "/management/driver-intention/deleteIntention",
        selectDriverIntention: "/management/driver-intention/selectDriverIntention",
        selectCustomerIntention: "/management/driver-intention/selectCustomerIntention",
    },
    orders: {
        addOrders: "/management/orders/addOrders",
        delOrders: "/management/orders/delOrders",
        modifyOrders: "/management/orders/modifyOrders",
        checkOrders: "/management/orders/checkOrders",
        selectDriverOrders: "/management/orders/selectDriverOrders",
        selectCustomerOrders: "/management/orders/selectCustomerOrders",
        selectAllOrders: "/management/orders/selectAllOrders"
    },
    customer: {
        modCustomerInfo: "/management/customer/modCustomerInfo",
        getCustomerInfo: "/management/customer/getCustomerInfo",
        getCustomerInfoById: "/management/customer/getCustomerInfoById",
    },
    driver: {
        modDriverInfo: "/management/driver/modDriverInfo",
        getDriverInfo: "/management/driver/getDriverInfo",
        getDriverInfoById: "/management/driver/getDriverInfoById",
    },
    account: {
        queryMoney: "/management/account/queryMoney",
        modMoney: "/management/account/modMoney",
        addMoney: "/management/account/addMoney",
        modMoneyById: "/management/account/modMoneyById",
        getAllAccount: "/management/account/getAllAccount"
    },
    tradingRecord: {
        addRecord: "/management/trading-record/addRecord",
        selectTradingRecord: "/management/trading-record/selectTradingRecord",
        selectAllTradingRecord: "/management/trading-record/selectAllTradingRecord",
        delTradeRecordById: "/management/trading-record/delTradingRecord"
    },
    message: {
        addMessage: "/management/message/addMessage",
        delMessage: "/management/message/delMessage",
        delMessageById: "/management/message/delMessageById",
        selectMessage: "/management/message/selectMessage",
        countUnreadMessage: "/management/message/countUnreadMessage",
    }

}