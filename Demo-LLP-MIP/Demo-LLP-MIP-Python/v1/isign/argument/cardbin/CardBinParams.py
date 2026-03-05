class CardBinParams:
    def __init__(self):
        self.mch_id = None
        self.sub_mchid = None
        self.card_no = None

    def to_dict(self):
        return {
            "mch_id": self.mch_id,
            "sub_mchid": self.sub_mchid,
            "card_no": self.card_no
        }