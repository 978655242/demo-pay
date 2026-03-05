<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\isign\argument\verify\VerifyParams.php');

$params = new VerifyParams();
$params->mch_id = $MchId;
$params->user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08";
$params->token = "LLianpay-test-token";
$params->verify_code = "lianlian-code";

$url = "https://test.lianlianpay-inc.com/mch/v1/isign/verify";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);