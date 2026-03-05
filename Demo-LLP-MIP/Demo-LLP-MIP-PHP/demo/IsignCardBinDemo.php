<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\isign\argument\cardbin\CardBinParams.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\CardInfo.php');

$params = new CardBinParams();
$params->mch_id = $MchId;
$params->card_no = "3568855594328587";

$url = "https://test.lianlianpay-inc.com/query/v1/isign/cardbin";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);