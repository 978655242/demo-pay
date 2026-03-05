from datetime import datetime

class LLianPayDateUtils:
    DefaultPattern = "%Y%m%d%H%M%S"

    def __init__(self):
        pass

    @staticmethod
    def get_timestamp():
        return LLianPayDateUtils.format(datetime.now(), LLianPayDateUtils.DefaultPattern)

    @staticmethod
    def format(date, pattern):
        return date.strftime(pattern)