import logging
log = logging.getLogger('IpayCreatePayDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from utils.LLianPayDateUtils import LLianPayDateUtils
from v1.ipay.argument.create.CreatePayParams import CreatePayParams
from v1.info.DeviceInfo import DeviceInfo
from v1.info.PayMethodInfo import PayMethodInfo
from v1.info.DivideInfo import DivideInfo
from v1.info.StoreInfo import StoreInfo

params=CreatePayParams()
params.mch_id = MchId
params.user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08"
params.busi_type = "100001"
params.pay_expire = 30
params.share_flag = "IMMEDIATE"
params.txn_seqno = "SOgKCGouScflQDsTw6I8Nm11DzTZEn5n"
params.txn_time = LLianPayDateUtils.get_timestamp()
params.order_amount = 0.01
params.divide_notify_url="https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm"
params.notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm"

device_info=DeviceInfo()
device_info.device_gps = "45.03"
device_info.device_iccid = "测试iccid"
device_info.device_imsi = "测试imsi"
device_info.device_imei = "测试imei"
device_info.device_ip = "10.2.1.3"
device_info.device_type = "SMQ"
device_info.device_wifimac = "测试wifimac"
device_info.device_mac = "测试mac"
params.device_info=device_info

params.extend_info="{\\\"wx_data\\\": {\\\"openid\\\": \\\"ogqG96TPm8Siu4iVVdI395AfiZi0\\\",\\\"appid\\\": \\\"wx391faca608e28bd9\\\"}}"

pay_method_info=PayMethodInfo()
pay_method_info.pay_type="WECHAT_JSAPI"
pay_method_info.amount="0.01"
params.pay_method_infos=[pay_method_info]

params.order_info="订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%"

divide_info_1=DivideInfo()
divide_info_1.divide_uid = "402311160000084546"
divide_info_1.divide_memo = "test1"
divide_info_1.divide_amount = 2

divide_info_2=DivideInfo()
divide_info_2.divide_uid = "402311160000084525"
divide_info_2.divide_memo = "说明2"
divide_info_2.divide_amount = 3

divide_info_3=DivideInfo()
divide_info_3.divide_uid = "402311160000084519"
divide_info_3.divide_memo = "3"
divide_info_3.divide_amount = 5

#params.divide_infos=divide_info_3

store_info=StoreInfo()
store_info.store_name = "测试店铺名称·啓垚"
store_info.area_code = "310018"
store_info.store_id = "20231122111617"
store_info.cashier_no = "测试店铺收银员·啓垚"
store_info.store_addr = "测试店铺地址·啓垚"
#params.store_info=store_info

url = "https://test.lianlianpay-inc.com/mch/v1/ipay/createpay"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)

log.info(result)