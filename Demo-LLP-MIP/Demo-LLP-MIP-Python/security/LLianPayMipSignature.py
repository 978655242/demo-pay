import logging
log = logging.getLogger('LLianPayMipSignature')
log.setLevel(logging.INFO)
import hashlib
from Crypto.Signature import PKCS1_v1_5
from Crypto.Hash import MD5
from Crypto.Cipher import PKCS1_v1_5 as Cipher_PKCS1_v1_5
from Crypto.PublicKey import RSA
from config.LLianPayConstant import MerchantPrivateKey
from config.LLianPayConstant import LLianPayPublicKey
from security.Base64 import *

# 定义一个LLianPayMipSignature类，实现连连账户+签名功能
class LLianPayMipSignature:
    def __init__(self):
        pass

    @staticmethod
    def getInstance():
        return LLianPayMipSignature()

    # 签名处理，默认使用LLianPayConstant中配置的私钥MerchantPrivateKey
    def sign(self, sign_str, prikeyvalue=None):
        if prikeyvalue is None:
            prikeyvalue = MerchantPrivateKey
        logging.info(sign_str)
        hash_value = hashlib.md5(sign_str.encode('utf-8')).hexdigest()
        log.info("签名处理中，签名源内容：%s，对应MD5值：%s" % (sign_str, hash_value))
        return self.RSA_sign(prikeyvalue, hash_value)

    # RSA签名
    def RSA_sign(self, prikeyvalue, hash_value):
        try:
            # prikeyvalue 是私钥的值
            # 已确认相同
            prikeyvalue_bytes = Base64.get_bytes_from_base64(prikeyvalue)

            # 使用私钥值创建RSA私钥对象
            private_key = RSA.import_key(prikeyvalue_bytes)
            # 用私钥对信息生成数字签名
            signer = PKCS1_v1_5.new(private_key)
            hash_value = MD5.new(hash_value.encode('utf-8'))
            signature = signer.sign(hash_value)

            # 将签名结果进行Base64编码
            signed_base64 = base64.b64encode(signature).decode('utf-8')

            # 返回Base64编码后的签名结果
            return signed_base64
        except Exception as e:
            log.error("签名失败,%s" % e)

    # 签名验证，默认使用LLianPayConstant中配置的公钥LLianPayPublicKey
    def checkSign(self, sign_str, signed_str, pubkeyvalue=None):
        if pubkeyvalue is None:
            pubkeyvalue = LLianPayPublicKey
        hash_value = hashlib.md5(sign_str.encode('utf-8')).hexdigest()
        log.info("签名验证中，源串：%s，对应MD5值：%s" % (sign_str, hash_value))
        return self.RSA_checksign(pubkeyvalue, hash_value, signed_str)

    # RSA签名验证
    def RSA_checksign(self, pubkeyvalue, hash_value, signed_str):
        try:
            # 将Base64编码的公钥值转换为字节形式
            pubkeyvalue_bytes = base64.b64decode(pubkeyvalue)
            public_key = RSA.importKey(pubkeyvalue_bytes)
            cipher = PKCS1_v1_5.new(public_key)
            h = MD5.new(hash_value.encode('utf-8'))
            signature = base64.b64decode(signed_str)
            return cipher.verify(h, signature)
        except Exception as e:
            log.error("签名验证异常,%s" % e)

    # 测试环境使用连连公钥加密密码
    def localEncrypt(self, sourceStr):
        try:
            public_key = RSA.import_key(LLianPayPublicKey)
            cipher_rsa = Cipher_PKCS1_v1_5.new(public_key)
            encrypt_bytes = cipher_rsa.encrypt(sourceStr.encode('utf-8'))
            encryptStr = base64.b64encode(encrypt_bytes).decode('utf-8')
            log.info("本地RSA加密，源串：%s，加密后值：%s" % (sourceStr, encryptStr))
            return encryptStr
        except Exception as e:
            log.error("本地RSA加密异常,%s" % e)