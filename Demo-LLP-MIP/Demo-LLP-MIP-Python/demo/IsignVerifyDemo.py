import logging
log = logging.getLogger('IsignVerifyDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from v1.isign.argument.verify.VerifyParams import VerifyParams

params=VerifyParams()
params.mch_id = MchId
params.user_id="pWDslsPANCa4rimg0byYcXR4F8avAF08"
params.token="LLianpay-test-token"
params.verify_code="lianlian-code"

url = "https://test.lianlianpay-inc.com/mch/v1/isign/verify"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)