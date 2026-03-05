class OrderQueryParams:
    def __init__(self):
        self.mch_id = None  # 商户编号是商户在平台上开设的商户号码，为18位数字
        self.txn_seqno = None  # 商户支付订单号，商户系统唯一订单号，与平台支付订单号、渠道订单号三者取一
        self.platform_txno = None  # 平台支付订单号，连连订单唯一编号，与商户支付订单号、渠道订单号三者取一
        self.chnl_txno = None  # 渠道订单号，渠道订单唯一编号，与平台支付订单号、商户支付订单号三者取一
        self.chnl_req_serialId = None  # 上游渠道请求流水号，上游渠道请求微信/支付宝/数字人民币的订单号，与平台支付订单号、商户支付订单号三者取一
        self.txn_date = None  # 交易日期，支付交易发生日期，格式：YYYYMMDD

    def to_dict(self):
        data = {
            "mch_id": self.mch_id,
            "txn_seqno": self.txn_seqno,
            "platform_txno": self.platform_txno,
            "chnl_txno": self.chnl_txno,
            "chnl_req_serialId": self.chnl_req_serialId,
            "txn_date": self.txn_date
        }
        return {k: v for k, v in data.items() if v is not None}