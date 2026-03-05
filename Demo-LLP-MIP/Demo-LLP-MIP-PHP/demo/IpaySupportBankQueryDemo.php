<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\ipay\argument\supportbank\SupportBankQueryParams.php');

$params = new SupportBankQueryParams();
$params->mch_id = $MchId;
$params->pay_type = "QUICK_PAY";
$params->card_type = "DEBIT_CARD";
$params->biz_scene = "TOKEN_SIGN";

$url = "https://test.lianlianpay-inc.com/query/v1/ipay/supportbankquery";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);