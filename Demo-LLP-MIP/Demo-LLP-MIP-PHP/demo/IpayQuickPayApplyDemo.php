<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\ipay\argument\quick\QuickPayParams.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\ipay\argument\create\CreatePayParams.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\CardInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\DeviceInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\PayMethodInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\DivideInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\StoreInfo.php');

$params = new QuickPayParams();
$params->mch_id = $MchId;
$params->txn_seqno = "SOgKCGouScflQDsTw6I8Nm11DzTZEn5n";
$params->user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08";
$params->busi_type = "100001";
$params->order_amount = 0.01;
$params->pay_expire = 30;
$params->notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm";
$params->txn_time = LLianPayDateUtils::get_timestamp();

$card_info = new CardInfo();
$params->card_info = $card_info;

$pay_method_info = new PayMethodInfo();
$pay_method_info->pay_type = "QUICK_PAY";
$pay_method_info->amount = "0.01";
$params->pay_method_infos = array($pay_method_info);

$store_info = new StoreInfo();
$store_info->store_name = "测试店铺名称·啓垚";
$store_info->area_code = "310018";
$store_info->store_id = "store001";
$store_info->cashier_no = "测试店铺收银员·啓垚";
$store_info->store_addr = "测试店铺地址·啓垚";
$params->store_info = $store_info;

$url = "https://test.lianlianpay-inc.com/mch/v1/ipay/quickpayapply";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);

