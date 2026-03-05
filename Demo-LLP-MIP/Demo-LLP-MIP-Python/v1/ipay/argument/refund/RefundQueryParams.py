class RefundQueryParams:
    def __init__(self):
        self.mch_id = None
        self.refund_seqno = None
        self.platform_refundno = None
        self.refund_date = None

    def to_dict(self):
        data = {
            "mch_id": self.mch_id,
            "refund_seqno": self.refund_seqno,
            "platform_refundno": self.platform_refundno,
            "refund_date": self.refund_date
        }
        return {k: v for k, v in data.items() if v}