<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\cashier\argument\create\CreatePayParams.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\GoodsInfo.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';

$params = new CreatePayParams();
$params->mch_id = $MchId;
$params->user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08";
$params->busi_type = "100001";
$params->pay_expire = 30;
$params->share_flag = "IMMEDIATE";
$params->txn_seqno = "SOgKCGouScflQDsTw6I8Nm11DzTZEn5n";
$params->txn_time = LLianPayDateUtils::get_timestamp();
$params->order_amount = 0.01;
$params->notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm";
$params->goods_info = array(new GoodsInfo("100001", "test-100001"));

$url = "https://test.lianlianpay-inc.com/mch/v1/cashier/createpay";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);
?>