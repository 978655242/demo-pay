class RiskInfo:
    def __init__(self):
        self.ip_addr = None  # 交易地址
        self.longitude = None  # 经度信息
        self.latitude = None  # 纬度信息
        self.cell_id = None  # 基站地址
        self.user_register_time = None  # 商户端用户注册时间，格式：YYYYMMDDH24MISS，14位数字，精确到秒
        self.user_login_method = None  # 用户本次登录验证方式