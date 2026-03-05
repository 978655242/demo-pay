<?php




class CreatePayParams
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
    public $share_flag;
    public $divide_notify_url;
    public $secured_flag;
    public $goods_info;
    public $risk_info;
    public $device_info;
    public $store_info;
    public $payee_infos;
    public $pay_method_infos;
    public $balance_info;
    public $divide_infos;
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

