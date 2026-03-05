<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\ipay\argument\close\CloseParams.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';

$params = new CloseParams();
$params->mch_id = $MchId;
$params->txn_seqno = "SOgKCGouScflQDsTw6I8Nm11DzTZEn5n";
$url = "https://test.lianlianpay-inc.com/mch/v1/ipay/close";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);