from v1.info.CardInfo import CardInfo


class ApplyParams:
    def __init__(self):
        self.mch_id = None
        self.sub_mchid = None
        self.user_id = None
        self.txn_seqno = None
        self.txn_time = None
        self.card_info = None  # 假设 CardInfo 为另一个类

    def to_dict(self):
        return {
            "mch_id": self.mch_id,
            "sub_mchid": self.sub_mchid,
            "user_id": self.user_id,
            "txn_seqno": self.txn_seqno,
            "txn_time": self.txn_time,
            "card_info": self.card_info.__dict__ if self.card_info is not None else None
        }