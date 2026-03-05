class RefundMethodInfo:
    def __init__(self):
        self.pay_type = None  # 支付方式，枚举列表详见4.2支付方式枚举，例如：WECHAT_JSAPI
        self.amount = None  # 退款金额，该支付方式对应的金额，单位为元