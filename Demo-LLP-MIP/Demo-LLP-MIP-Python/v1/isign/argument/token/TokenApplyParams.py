from v1.info.CardInfo import CardInfo
from v1.info.DeviceInfo import DeviceInfo
from v1.info.RiskInfo import RiskInfo


class TokenApplyParams:
    def __init__(self):
        self.mch_id = None
        self.sub_mchid = None
        self.user_id = None
        self.txn_seqno = None
        self.txn_time = None
        self.notify_url = None
        self.return_url = None
        self.risk_info = None  # 请咨询技术对接按需传递
        self.device_info = None
        self.card_info = None

    def to_dict(self):
        return {
            "mch_id": self.mch_id,
            "sub_mchid": self.sub_mchid,
            "user_id": self.user_id,
            "txn_seqno": self.txn_seqno,
            "txn_time": self.txn_time,
            "notify_url": self.notify_url,
            "return_url": self.return_url,
            "risk_info": self.risk_info.__dict__ if self.risk_info is not None else None,
            "device_info": self.device_info.__dict__ if self.device_info is not None else None,
            "card_info": self.card_info.__dict__ if self.card_info is not None else None
        }