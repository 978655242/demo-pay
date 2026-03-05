<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\ipay\argument\refund\RefundQueryParams.php');

$params = new RefundQueryParams();
$params->mch_id = $MchId;
$params->refund_seqno = "20231122184428";

$url = "https://test.lianlianpay-inc.com/query/v1/ipay/refundquery";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);