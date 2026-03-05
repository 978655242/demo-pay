import logging
log = logging.getLogger('IsignQueryDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from v1.isign.argument.query.QueryParams import QueryParams

params=QueryParams()
params.mch_id = MchId
params.user_id="pWDslsPANCa4rimg0byYcXR4F8avAF08"

url = "https://test.lianlianpay-inc.com/query/v1/isign/query"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)