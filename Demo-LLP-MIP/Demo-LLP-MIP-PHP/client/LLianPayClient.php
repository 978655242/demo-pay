<?php
//require 'vendor/autoload.php'; // 如果使用 Composer 管理依赖，则需要引入自动加载文件

use GuzzleHttp\Client;
use GuzzleHttp\Exception\RequestException;

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\security\LLianPayMipSignature.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php');

class LLianPayClient {
    protected $log;

    public function __construct() {
        
    }

    public function sendRequest($url, $body) {
        if ($url === null || $url === "") {
            throw new \RuntimeException("请求URL非法");
        }
        return $this->sendRequestWithSignature($url, $body, (new LLianPayMipSignature)->sign($body));
    }

    public function sendRequestWithSignature($url, $body, $sign) {
        if ($url === null || $url === "") {
            throw new \RuntimeException("请求URL非法");
        }
        echo "\n请求URL：" . $url;
        echo "\n请求签名值：" . $sign;
        echo "\n请求参数：" . $body;
        require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php');
        $headers = [
            "Content-Type" => "application/json;charset=utf-8",
            "Signature-Type" => "RSA",
            "Signature-Data" => $sign,
            "mch_id" => "302207190000043504",
            "timestamp" => LLianPayDateUtils::get_timestamp() // 获取当前时间戳
        ];
        try {
            $caCertPath = 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\security\cacert.pem';
            $client = new Client([
                'verify' => $caCertPath
            ]);
            $response = $client->post($url, [
                'headers' => $headers,
                'body' => $body
            ]);
            $statusCode = $response->getStatusCode();
            $responseBody = $response->getBody()->getContents();
            $responseData = json_decode($responseBody, true);
            echo "\n响应结果：" . print_r($responseData, true);

            if (isset($response->getHeaders()['Signature-Data'])) {
                $signatureData = $response->getHeader('Signature-Data')[0];
                echo "\n响应签名：Signature-Data 的值为: " . $signatureData;

                $checkSign = (new LLianPayMipSignature)->checkSign(str_replace(" ", "", json_encode($responseData,320)), $signatureData);
                if ($checkSign) {
                    echo "\n响应验签通过！";
                } else {
                    echo "\n返回响应验证签名异常，请核实！";
                }
            }

            // 在此可以添加对响应数据的处理逻辑
            return $responseData;
        } catch (RequestException $e) {
            echo "\n请求异常：" . $e->getMessage();
            throw $e; // 将异常继续往上抛，显示详细的请求异常信息
        }
    }
}

// 使用示例
//$client = new LLianPayClient();
//$response = $client->sendRequest("http://example.com/api", json_encode(["name" => "John", "email" => "john@example.com"]));
//var_dump($response);
?>