from v1.info.CardInfo import CardInfo


class CancelParams:
    def __init__(self):
        self.mch_id = None
        self.sub_mchid = None
        self.user_id = None
        self.card_info = None  # 假设 CardInfo 为另一个类，这里只传agree_no，其他字段无需传值

    def to_dict(self):
        return {
            "mch_id": self.mch_id,
            "sub_mchid": self.sub_mchid,
            "user_id": self.user_id,
            "card_info": {"agree_no": self.card_info.agree_no} if self.card_info is not None else None
        }