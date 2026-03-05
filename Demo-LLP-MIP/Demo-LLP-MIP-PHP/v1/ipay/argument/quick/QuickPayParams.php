<?php


class QuickPayParams
{
    public $mch_id;
    public $sub_mchid;
    public $user_id;
    public $busi_type;
    public $txn_seqno;
    public $txn_time;
    public $order_amount;
    public $order_info;
    public $pay_expire;
    public $notify_url;
    public $secured_flag;
    public $card_info;  // 假设 CardInfo 为另一个类
    public $goods_info;  // 假设 GoodsInfo 为另一个类
    public $risk_info;  // 假设 RiskInfo 为另一个类
    public $device_info;  // 假设 DeviceInfo 为另一个类
    public $store_info;  // 假设 StoreInfo 为另一个类
    public $payee_infos;  // 假设 PayeeInfo 为另一个类
    public $pay_method_infos;  // 假设 PayMethodInfo 为另一个类
    public $balance_info;  // 假设 BalanceInfo 为另一个类
    public $extend_info;

    public function to_dict() {
        $data = [];
        foreach ($this as $key => $value) {
            if ($value !== null) {
                $data[$key] = $value;
            }
        }
        return json_encode($data);
    }
}

