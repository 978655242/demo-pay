import logging
log = logging.getLogger('IsignCancelDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from v1.isign.argument.cancel.CancelParams import CancelParams
from v1.info.CardInfo import CardInfo

params=CancelParams()
params.mch_id = MchId
params.sub_mchid="302210180000021525"
params.user_id="1111111111111111111111111111111111112117"

card_info =CardInfo()
card_info.agree_no="202311168958722900"
params.card_info=card_info

url = "https://test.lianlianpay-inc.com/mch/v1/isign/cancel"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)