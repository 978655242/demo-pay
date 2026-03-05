class QueryParams:
    def __init__(self):
        self.mch_id = None
        self.sub_mchid = None
        self.user_id = None

    def to_dict(self):
        return {
            "mch_id": self.mch_id,
            "sub_mchid": self.sub_mchid,
            "user_id": self.user_id
        }