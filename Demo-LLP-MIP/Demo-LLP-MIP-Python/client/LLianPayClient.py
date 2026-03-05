import logging
log = logging.getLogger('LLianPayClient')
log.setLevel(logging.INFO)
import requests
from config.LLianPayConstant import MchId
from security.LLianPayMipSignature import LLianPayMipSignature
from utils.LLianPayDateUtils import LLianPayDateUtils

class LLianPayClient:
    def __init__(self):
        self.log = logging.getLogger('LLianPayClient')

    def send_request(self, url, body):
        if url is None or url == "":
            raise RuntimeError("请求URL非法")
        return self.send_request_with_signature(url, body, LLianPayMipSignature().sign(body))

    def send_request_with_signature(self, url, body, sign):
        if url is None or url == "":
            raise RuntimeError("请求URL非法")

        log.info("请求URL：" + url)
        log.info("请求签名值：" + sign)
        log.info("请求参数：" + body)

        headers = {
            "Content-Type": "application/json;charset=utf-8",
            "Signature-Type": "RSA",
            "Signature-Data": sign,
            "mch_id": MchId,
            "timestamp": LLianPayDateUtils.get_timestamp()  # 获取当前时间戳
        }

        try:
            response = requests.post(url, data=body, headers=headers)
            response.raise_for_status()  # 检查请求是否成功，如果失败抛出异常
            response_data = response.json()  # 如果响应是JSON格式，可以用json()方法直接获取响应内容
            log.info("响应结果：" + str(response_data))

            if 'Signature-Data' in response.headers:
                signature_data = response.headers['Signature-Data']
                log.info(f"响应签名：Signature-Data 的值为: {signature_data}")
                checkSign = LLianPayMipSignature().checkSign(str(response_data).replace(" ", "").replace("'", '"'),
                                                             signature_data)
                if (checkSign):
                    log.info("响应验签通过！")
                else:
                    log.error("返回响应验证签名异常，请核实！")

            # 在此可以添加对响应数据的处理逻辑
            return response_data
        except requests.exceptions.RequestException as e:
            log.error("请求异常：", str(e))
            raise  # 将异常继续往上抛，显示详细的请求异常信息
