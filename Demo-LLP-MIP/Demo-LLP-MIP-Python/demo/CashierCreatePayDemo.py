import logging
log = logging.getLogger('CashierCreatePayDemo')
log.setLevel(logging.INFO)
from v1.cashier.argument.create.CreatePayParams import CreatePayParams
from config.LLianPayConstant import MchId
from utils.LLianPayDateUtils import LLianPayDateUtils
from v1.info.GoodsInfo import GoodsInfo
import json
from client.LLianPayClient import LLianPayClient

params = CreatePayParams()
params.mch_id = MchId
params.user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08"
params.busi_type = "100001"
params.pay_expire = 30
params.share_flag = "IMMEDIATE"
params.txn_seqno = "SOgKCGouScflQDsTw6I8Nm11DzTZEn5n"
params.txn_time = LLianPayDateUtils.get_timestamp()
params.order_amount = 0.01

params.notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm"
params.goods_info = [GoodsInfo("100001", "test-100001")]

url = "https://test.lianlianpay-inc.com/mch/v1/cashier/createpay"


params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)

log.info(result)
