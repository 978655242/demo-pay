<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\isign\argument\cancel\CancelParams.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\CardInfo.php');

$params = new CancelParams();
$params->mch_id = $MchId;
$params->sub_mchid = "302210180000021525";
$params->user_id = "1111111111111111111111111111111111112117";

$card_info = new CardInfo();
$card_info->agree_no = "202311168958722900";
$params->card_info = $card_info;

$url = "https://test.lianlianpay-inc.com/mch/v1/isign/cancel";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);