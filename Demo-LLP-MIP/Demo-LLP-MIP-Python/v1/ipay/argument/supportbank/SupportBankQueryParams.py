class SupportBankQueryParams:
    def __init__(self):
        self.mch_id = None
        self.pay_type = None
        self.bank_code = None
        self.card_type = None
        self.biz_scene = None

    def to_dict(self):
        return {
            "mch_id": self.mch_id,
            "pay_type": self.pay_type,
            "bank_code": self.bank_code,
            "card_type": self.card_type,
            "biz_scene": self.biz_scene
        }