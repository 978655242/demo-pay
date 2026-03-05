<?php

require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\vendor\autoload.php';
use phpseclib\Crypt\RSA;
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\vendor\phpseclib\phpseclib\phpseclib\Crypt\RSA.php';
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\security\Base64.php';

class LLianPayMipSignature {
    public function sign($sign_str, $prikeyvalue=null) {
        if ($prikeyvalue === null) {
            include 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
            $prikeyvalue = $MerchantPrivateKey;
        }
        echo $sign_str . "\n";
        $hash_value = hash('md5', $sign_str);
        echo "签名处理中，签名源内容：" . $sign_str . "，对应MD5值：" . $hash_value;
        return $this->RSA_sign($prikeyvalue, $hash_value);
    }

    function RSA_sign($prikeyvalue, $sign_str) {
        try {
            $prikeyDer = base64_decode($prikeyvalue);
            $pem = "-----BEGIN PRIVATE KEY-----\n" . chunk_split(base64_encode($prikeyDer), 64, "\n") . "-----END PRIVATE KEY-----";

            $pkeyid = openssl_pkey_get_private($pem);
            if (!$pkeyid) {
                throw new Exception("Failed to extract private key");
            }

            // 用私钥对信息生成数字签名
            openssl_sign($sign_str, $signature, $pkeyid, OPENSSL_ALGO_MD5);
            openssl_free_key($pkeyid);

            return base64_encode($signature);
        } catch (Exception $e) {
            error_log("签名失败," . $e->getMessage());
        }
        return null;
    }

    public function checkSign($sign_str, $signed_str, $pubkeyvalue=null) {
        if ($pubkeyvalue === null) {
            include 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
            $pubkeyvalue = $LLianPayPublicKey;
        }

        $hash_value = hash('md5', $sign_str);
        echo "\n签名验证中，源串：" . $sign_str . "，对应MD5值：" . $hash_value;
        return $this->RSA_checksign($pubkeyvalue, $hash_value, $signed_str);
    }

    function RSA_checksign($pubkeyvalue, $hash_value, $signed_str) {
        try {
            // 将Base64编码的公钥值转换为字节形式
            $pubkeyvalue_bytes = base64_decode($pubkeyvalue);
            $public_key = openssl_pkey_get_public("-----BEGIN PUBLIC KEY-----\n" . chunk_split(base64_encode($pubkeyvalue_bytes), 64, "\n") . "-----END PUBLIC KEY-----");
            if ($public_key === false) {
                throw new Exception("Failed to extract public key");
            }

            // 创建一个用于验证签名的 OpenSSL key 对象
            $rsaObj = openssl_verify($hash_value, base64_decode($signed_str), $public_key, OPENSSL_ALGO_MD5);
            if ($rsaObj == 1) {
                return true;
            } elseif ($rsaObj == 0) {
                return false;
            } else {
                throw new Exception("An error occurred while verifying the signature");
            }
        } catch (Exception $e) {
            error_log("签名验证异常," . $e->getMessage());
        }
        return false;
    }

    public function localEncrypt($sourceStr) {
        try {
            $rsa = new RSA();
            $publicKey = LLianPayPublicKey;
            $rsa->loadKey(Base64::decode($publicKey));
            $rsa->setEncryptionMode(RSA::ENCRYPTION_PKCS1);
            $encryptStr = $rsa->encrypt($sourceStr);
            $encryptStrBase64 = base64_encode($encryptStr);
            echo "本地RSA加密，源串：" . $sourceStr . "，加密后值：" . $encryptStr;
            return $encryptStrBase64;
        } catch (Exception $e) {
            echo "本地RSA加密异常, " . $e;
        }
    }
}
?>