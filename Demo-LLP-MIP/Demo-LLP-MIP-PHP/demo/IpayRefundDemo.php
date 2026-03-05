<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\ipay\argument\refund\RefundParams.php');

$params = new RefundParams();
$params->mch_id = $MchId;
$params->txn_seqno = "OEoIfl0c17VQxwtDkVarKlqpZfhypPWS";
$params->refund_time = LLianPayDateUtils::get_timestamp();
$params->refund_seqno = "20231129104025";
$params->txn_date = "20231129";
$params->refund_reason = "退款申请test";
$params->refund_amount = 0.04;
$params->notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm";

$url = "https://test.lianlianpay-inc.com/mch/v1/ipay/refund";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);
