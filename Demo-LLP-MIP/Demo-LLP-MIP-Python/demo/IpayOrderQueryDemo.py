import logging
log = logging.getLogger('IpayOrderQueryDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from v1.ipay.argument.order.OrderQueryParams import OrderQueryParams
from config.LLianPayConstant import MchId

params=OrderQueryParams()
params.mch_id = MchId
params.txn_seqno = "SOgKCGouScflQDsTw6I8Nm11DzTZEn5n"

url = "https://test.lianlianpay-inc.com/query/v1/ipay/orderquery"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)