class DeviceInfo:
    def __init__(self):
        self.device_id = None  # 设备标识码
        self.device_type = None  # 设备类型: SMQ-扫码枪 BOX-收款盒子 POS-POS机 PC-个人电脑 PAD-平板电脑 PHONE-手机
        self.device_ip = None  # 设备IP
        self.device_gps = None  # 设备GPS
        self.device_imei = None  # 设备IMEI
        self.device_imsi = None  # 设备IMSI
        self.device_iccid = None  # 设备ICCID
        self.device_wifimac = None  # 设备WIFIMAC
        self.device_mac = None  # 设备MAC