class PayeeRefundInfo:
    def __init__(self):
        self.payee_uid = None  # 收款方用户id，当收款方类型是用户时，必填
        self.payee_accttype = None  # 收款方账户类型
        self.payee_type = None  # 收款方类型
        self.payee_amount = None  # 收款方金额，单位元，保留二位小数
        self.payee_memo = None  # 收款方备注