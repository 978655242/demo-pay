from v1.info.GoodsInfo import GoodsInfo
from v1.info.DeviceInfo import DeviceInfo
from v1.info.PayMethodInfo import PayMethodInfo
from v1.info.DivideInfo import DivideInfo
from v1.info.StoreInfo import StoreInfo
from v1.info.RiskInfo import RiskInfo
from v1.info.Style import Style

class CreatePayParams:
    def __init__(self):
        self.mch_id = None
        self.sub_mchid = None
        self.user_id = None
        self.busi_type = None
        self.txn_seqno = None
        self.txn_time = None
        self.order_amount = None
        self.order_info = None
        self.pay_expire = None
        self.notify_url = None
        self.return_url = None
        self.share_flag = None
        self.secured_flag = None
        self.goods_info = None
        self.risk_info = None  # 假设 RiskInfo 为另一个类
        self.device_info = None  # 假设 DeviceInfo 为另一个类
        self.store_info = None  # 假设 StoreInfo 为另一个类
        self.payee_infos = None
        self.style = None  # 假设 Style 为另一个类
        self.extend_info = None
    def to_dict(self):
        data= {
            "mch_id": self.mch_id,
            "sub_mchid": self.sub_mchid,
            "user_id": self.user_id,
            "busi_type": self.busi_type,
            "txn_seqno": self.txn_seqno,
            "txn_time": self.txn_time,
            "order_amount": self.order_amount,
            "order_info": self.order_info,
            "pay_expire": self.pay_expire,
            "notify_url": self.notify_url,
            "return_url": self.return_url,
            "share_flag": self.share_flag,
            "secured_flag": self.secured_flag,
            # "goods_info": [goods.__dict__ for goods in self.goods_info],
            # "risk_info": self.risk_info.__dict__,
            # "device_info": self.device_info.__dict__,
            # "store_info": self.store_info.__dict__,
            # "payee_infos": [payee.__dict__ for payee in self.payee_infos],
            # "style": self.style.__dict__,
            "extend_info": self.extend_info
        }
        if self.goods_info is not None:
            data["goods_info"] = [goods.__dict__ for goods in self.goods_info]
        if self.risk_info is not None:
            data["risk_info"] = self.risk_info.__dict__
        if self.device_info is not None:
            data["device_info"] = self.device_info.__dict__
        if self.store_info is not None:
            data["store_info"] = self.store_info.__dict__
        if self.payee_infos is not None:
            data["payee_infos"] = [payee.__dict__ for payee in self.payee_infos]
        if self.style is not None:
            data["style"] = self.style.__dict__

        data = {k: v for k, v in data.items() if v is not None}
        return {k: v for k, v in data.items() if v}