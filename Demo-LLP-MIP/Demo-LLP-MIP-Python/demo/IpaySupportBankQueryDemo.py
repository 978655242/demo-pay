import logging
log = logging.getLogger('IpaySupportBankQueryDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from v1.ipay.argument.supportbank.SupportBankQueryParams import SupportBankQueryParams

params=SupportBankQueryParams()
params.mch_id = MchId
params.pay_type="QUICK_PAY"
params.card_type="DEBIT_CARD"
params.biz_scene="TOKEN_SIGN"

url = "https://test.lianlianpay-inc.com/query/v1/ipay/supportbankquery"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)