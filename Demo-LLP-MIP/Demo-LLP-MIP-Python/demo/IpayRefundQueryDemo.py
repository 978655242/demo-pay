import logging
log = logging.getLogger('IpayRefundQueryDemo')
log.setLevel(logging.INFO)
import json
from client.LLianPayClient import LLianPayClient
from config.LLianPayConstant import MchId
from v1.ipay.argument.refund.RefundQueryParams import RefundQueryParams

# 这部分验签失败，是因为python里转json字符串，不同属性间都有空格，而返回json都无空格，所以手动去了
# 但在这个请求中，返回json竟然是“{"ret_code":"9901","ret_msg":"未查询到记录:商户号:[302207190000043504], 外部订单号:[20231122184428]"}”，外部订单号前单独多了个空格
# 在python转换这个json的时候，会变成"{'ret_code': '9901', 'ret_msg': '未查询到记录:商户号:[302207190000043504], 外部订单号:[20231122184428]'}" 不同对象和键值对之间都有空格

params=RefundQueryParams()
params.mch_id = MchId
params.refund_seqno="20231122184428"

url = "https://test.lianlianpay-inc.com/query/v1/ipay/refundquery"

params_dict = params.to_dict()
params_json = json.dumps(params_dict)
params_json = params_json.replace(" ", "")
result = LLianPayClient().send_request(url, params_json)
log.info(result)