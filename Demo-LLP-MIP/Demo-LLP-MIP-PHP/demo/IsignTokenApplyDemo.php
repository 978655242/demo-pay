<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\isign\argument\token\TokenApplyParams.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\CardInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\DeviceInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\PayMethodInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\DivideInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\RiskInfo.php');

$params = new TokenApplyParams();
$params->mch_id = $MchId;
$params->user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08";
$params->txn_seqno = "73737325600885115759292954374295";
$params->txn_time = LLianPayDateUtils::get_timestamp();
$params->notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm";
$params->return_url = "https://www.lianlianpay.com/";

$device_info = new DeviceInfo();
$device_info->device_id = "123456";
$params->device_info = $device_info;

$risk_info = new RiskInfo();
$risk_info->latitude = "411.33";
$risk_info->user_login_method = "FACE";
$risk_info->user_register_time = "20230703212500";
$risk_info->cell_id = "33.11,123.33";
$risk_info->ip_addr = "192.168.110.28";
$risk_info->longitude = "311.22";
$params->risk_info = $risk_info;

$card_info = new CardInfo();
$card_info->acct_name = "iYkhkM/u45juNS/IydQk0VsUxUv5sbdFn0AV6YMuCEjTg7PyBYcj3D3w7PSP1DwYaGqLUDsj0TL+HXCvL7uWRClVLZZBDAySVSNEdPzfHPvrEqAFedcwgDa6mOcNoc7tKt7q6NQpzP+uFpmnU1b6Fw8y570cJ5VzEvQq1tBx4xg=";
$card_info->id_no = "VKjhGKFwaIdFlSHROo4/vsLNFggq5awTKmRNVcO1ao3644dATArLxnGUkwJa2rR1U6bz9z0py19Z5Vo19MVqW76wiTyX4S0ijrI0w9aknPHb5NgxjeNAYxl+nE2PwUa6/7xc/QIuGxlh7II3JjM0DiYaT60Xc8Cwn3Ss3hntJE8=";
$card_info->id_type = "IDCARD";
$card_info->bind_phone = "cpsuiF1LPzdEMrBqZ1Z0CsaXnR9N9iSGHOZlN5kfTsJc93AO4V9sPlMVOQrWVzyvxknQvJbPgNTsGV0FE2SgPyzX0uG5Z01Mgo62RvdvcGVc0ejj3+GaeOTSaddnftB9TLdp+ucVpVHEg30wNRPqceXYld/qzJ3L4F8B5l39eR8=";
$params->card_info = $card_info;

$url = "https://test.lianlianpay-inc.com/mch/v1/isign/tokenapply";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);