import logging
log = logging.getLogger('IsignCardBinDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from v1.isign.argument.cardbin.CardBinParams import CardBinParams

params=CardBinParams()
params.mch_id = MchId
params.card_no="3568855594328587"

url = "https://test.lianlianpay-inc.com/query/v1/isign/cardbin"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)