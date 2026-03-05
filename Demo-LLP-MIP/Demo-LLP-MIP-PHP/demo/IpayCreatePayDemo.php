<?php

require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\client\LLianPayClient.php');
require_once 'D:\file\lianlian\code\Demo-LLP-MIP-PHP\config\LLianPayConstant.php';
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\utils\LLianPayDateUtils.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\ipay\argument\create\CreatePayParams.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\GoodsInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\DeviceInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\PayMethodInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\DivideInfo.php');
require_once('D:\file\lianlian\code\Demo-LLP-MIP-PHP\v1\info\StoreInfo.php');

$params = new CreatePayParams();
$params->mch_id = $MchId;
$params->user_id = "pWDslsPANCa4rimg0byYcXR4F8avAF08";
$params->busi_type = "100001";
$params->pay_expire = 30;
$params->share_flag = "IMMEDIATE";
$params->txn_seqno = "SOgKCGouScflQDsTw6I8Nm11DzTZEn5n";
$params->txn_time = LLianPayDateUtils::get_timestamp();
$params->order_amount = 0.01;
$params->divide_notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm";
$params->notify_url = "https://test.lianlianpay-inc.com/llpaytest/mpspNotifyReceive_test.htm";

$device_info = new DeviceInfo();
$device_info->device_gps = "45.03";
$device_info->device_iccid = "测试iccid";
$device_info->device_imsi = "测试imsi";
$device_info->device_imei = "测试imei";
$device_info->device_ip = "10.2.1.3";
$device_info->device_type = "SMQ";
$device_info->device_wifimac = "测试wifimac";
$device_info->device_mac = "测试mac";
$params->device_info = $device_info;

$params->extend_info = "{\"wx_data\": {\"openid\": \"ogqG96TPm8Siu4iVVdI395AfiZi0\",\"appid\": \"wx391faca608e28bd9\"}}";

$pay_method_info = new PayMethodInfo();
$pay_method_info->pay_type = "WECHAT_JSAPI";
$pay_method_info->amount = "0.01";
$params->pay_method_infos = [$pay_method_info];

$params->order_info = "订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%订单描述·啓垚abc#$%";

$divide_info_1 = new DivideInfo();
$divide_info_1->divide_uid = "402311160000084546";
$divide_info_1->divide_memo = "test1";
$divide_info_1->divide_amount = 2;

$divide_info_2 = new DivideInfo();
$divide_info_2->divide_uid = "402311160000084525";
$divide_info_2->divide_memo = "说明2";
$divide_info_2->divide_amount = 3;

$divide_info_3 = new DivideInfo();
$divide_info_3->divide_uid = "402311160000084519";
$divide_info_3->divide_memo = "3";
$divide_info_3->divide_amount = 5;

// $params->divide_infos = $divide_info_3;

$store_info = new StoreInfo();
$store_info->store_name = "测试店铺名称·啓垚";
$store_info->area_code = "310018";
$store_info->store_id = "20231122111617";
$store_info->cashier_no = "测试店铺收银员·啓垚";
$store_info->store_addr = "测试店铺地址·啓垚";
// $params->store_info = $store_info;

$url = "https://test.lianlianpay-inc.com/mch/v1/ipay/createpay";

$params_json = $params->to_dict();
$result = (new LLianPayClient)->sendRequest($url, $params_json);
echo "\n响应结果：" . print_r($result, true);
?>