class BalanceInfo:
    def __init__(self):
        self.user_id = None  # 余额支付 userid，用户在商户系统中的唯一编号，需要包装 mch_id+user_id 唯一
        self.user_type = None  # 用户类型: MCH-商户 USER-用户
        self.password = None  # 支付密码，余额支付默认需要支付密码
        self.random_key = None  # 密码随机因子 key，随机因子获取接口返回