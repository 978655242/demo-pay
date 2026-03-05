class CardInfo:
    def __init__(self):
        self.agree_no = None  # 您通过签约绑卡所生成协议号。如果是签约申请时，无该字段
        self.card_no = None  # 需加密传输，该字段与agree_no只需传一个
        self.id_type = None  # ID_CARD
        self.id_no = None  # 需加密传输，该字段与agree_no只需传一个
        self.acct_name = None  # 需加密传输，该字段与agree_no只需传一个
        self.bind_phone = None  # 需加密传输，该字段与agree_no只需传一个
        self.bank_code = None  # 银行编码
        self.card_type = None  # CREDIT_CARD-贷记卡, DEBIT_CARD-借记卡, PUBLIC_CARD-对公卡