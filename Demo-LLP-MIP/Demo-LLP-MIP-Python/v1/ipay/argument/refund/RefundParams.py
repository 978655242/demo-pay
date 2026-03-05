from v1.info.RefundMethodInfo import RefundMethodInfo
from v1.info.PayeeRefundInfo import PayeeRefundInfo
from v1.info.DivideRefundInfo import DivideRefundInfo


class RefundParams:
    def __init__(self):
        self.mch_id = None
        self.refund_seqno = None
        self.refund_time = None
        self.txn_seqno = None
        self.txn_date = None
        self.refund_reason = None
        self.refund_amount = None
        self.notify_url = None
        self.refund_method_infos = None  # 假设 RefundMethodInfo 为另一个类
        self.payee_refund_infos = None  # 假设 PayeeRefundInfo 为另一个类
        self.divide_refund_infos = None  # 假设 DivideRefundInfo 为另一个类

    def to_dict(self):
        data = {
            "mch_id": self.mch_id,
            "refund_seqno": self.refund_seqno,
            "refund_time": self.refund_time,
            "txn_seqno": self.txn_seqno,
            "txn_date": self.txn_date,
            "refund_reason": self.refund_reason,
            "refund_amount": self.refund_amount,
            "notify_url": self.notify_url
        }

        if self.refund_method_infos is not None:
            data["refund_method_infos"] = [info.__dict__ for info in self.refund_method_infos]
        if self.payee_refund_infos is not None:
            data["payee_refund_infos"] = [info.__dict__ for info in self.payee_refund_infos]
        if self.divide_refund_infos is not None:
            data["divide_refund_infos"] = [info.__dict__ for info in self.divide_refund_infos]

        return {k: v for k, v in data.items() if v}