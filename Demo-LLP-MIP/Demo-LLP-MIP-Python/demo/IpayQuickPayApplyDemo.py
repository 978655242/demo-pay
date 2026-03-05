import logging
log = logging.getLogger('IpayQuickPayApplyDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from utils.LLianPayDateUtils import LLianPayDateUtils
from v1.ipay.argument.quick.QuickPayParams import QuickPayParams
from v1.info.CardInfo import CardInfo
from v1.info.PayMethodInfo import PayMethodInfo
from v1.info.StoreInfo import StoreInfo

params=QuickPayParams()
params.mch_id = MchId
params.txn_seqno = "SOgKCGouScflQDsTw6I8Nm11DzTZEn5n"
params.user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08"
params.busi_type = "100001"
params.order_amount = 0.01
params.pay_expire = 30
params.notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm"
params.txn_time=LLianPayDateUtils.get_timestamp()

card_info=CardInfo()
params.card_info=card_info

pay_method_info=PayMethodInfo()
pay_method_info.pay_type="QUICK_PAY"
pay_method_info.amount="0.01"
params.pay_method_infos=[pay_method_info]

store_info=StoreInfo()
store_info.store_name = "测试店铺名称·啓垚"
store_info.area_code = "310018"
store_info.store_id = "store001"
store_info.cashier_no = "测试店铺收银员·啓垚"
store_info.store_addr = "测试店铺地址·啓垚"
params.store_info=store_info

url = "https://test.lianlianpay-inc.com/mch/v1/ipay/quickpayapply"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)