<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\isign\argument\query\QueryParams.php');

$params = new QueryParams();
$params->mch_id = $MchId;
$params->user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08";

$url = "https://test.lianlianpay-inc.com/query/v1/isign/query";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);