import logging
log = logging.getLogger('IpayCloseDemo')
log.setLevel(logging.INFO)
import json
from v1.ipay.argument.close.CloseParams import CloseParams
from config.LLianPayConstant import MchId
from client.LLianPayClient import LLianPayClient

params=CloseParams()
params.mch_id=MchId
params.txn_seqno="SOgKCGouScflQDsTw6I8Nm11DzTZEn5n"
url = "https://test.lianlianpay-inc.com/mch/v1/ipay/close"
params_json=json.dumps(params.__dict__)
params_json=params_json.replace(" ","")
result= LLianPayClient().send_request(url,params_json)

log.info(result)
