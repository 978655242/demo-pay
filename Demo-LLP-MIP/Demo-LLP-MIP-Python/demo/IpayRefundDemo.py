import logging
log = logging.getLogger('IpayRefundDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from utils.LLianPayDateUtils import LLianPayDateUtils
from v1.ipay.argument.refund.RefundParams import RefundParams

params=RefundParams()
params.mch_id = MchId
params.txn_seqno = "OEoIfl0c17VQxwtDkVarKlqpZfhypPWS"
params.refund_time=LLianPayDateUtils.get_timestamp()
params.refund_seqno="20231129104025"
params.txn_date="20231129"
params.refund_reason="退款申请test"
params.refund_amount=0.04
params.notify_url="https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm"


url = "https://test.lianlianpay-inc.com/mch/v1/ipay/refund"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)