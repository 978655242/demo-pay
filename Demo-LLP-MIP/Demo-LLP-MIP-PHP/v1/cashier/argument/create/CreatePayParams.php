<?php


class CreatePayParams {
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
    public $return_url;
    public $share_flag;
    public $secured_flag;
    public $goods_info;
    public $risk_info;
    public $device_info;
    public $store_info;
    public $payee_infos;
    public $style;
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

//    public function to_dict() {
//        $data = array(
//            "mch_id" => $this->mch_id,
//            "sub_mchid" => $this->sub_mchid,
//            "user_id" => $this->user_id,
//            "busi_type" => $this->busi_type,
//            "txn_seqno" => $this->txn_seqno,
//            "txn_time" => $this->txn_time,
//            "order_amount" => $this->order_amount,
//            "order_info" => $this->order_info,
//            "pay_expire" => $this->pay_expire,
//            "notify_url" => $this->notify_url,
//            "return_url" => $this->return_url,
//            "share_flag" => $this->share_flag,
//            "secured_flag" => $this->secured_flag,
//            "extend_info" => $this->extend_info
//        );
//
//        if (!empty($this->goods_info)) {
//            $data["goods_info"] = array_map(function($goods) {
//                return $goods->to_dict();
//            }, $this->goods_info);
//        }
//        if (!empty($this->risk_info)) {
//            $data["risk_info"] = $this->risk_info->to_dict();
//        }
//        if (!empty($this->device_info)) {
//            $data["device_info"] = $this->device_info->to_dict();
//        }
//        if (!empty($this->store_info)) {
//            $data["store_info"] = $this->store_info->to_dict();
//        }
//        if (!empty($this->payee_infos)) {
//            $data["payee_infos"] = array_map(function($payee) {
//                return $payee->to_dict();
//            }, $this->payee_infos);
//        }
//        if (!empty($this->style)) {
//            $data["style"] = $this->style->to_dict();
//        }
//
//        $data = array_filter($data, function($value) {
//            return !is_null($value);
//        });
//        return array_filter($data, function($value) {
//            return $value;
//        });
//    }
}
?>