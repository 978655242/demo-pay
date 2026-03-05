<?php
class RefundMethodInfo {
    public $pay_type; // 支付方式，枚举列表详见4.2支付方式枚举，例如：WECHAT_JSAPI
    public $amount; // 退款金额，该支付方式对应的金额，单位为元

    public function __construct() {
        $this->pay_type = null;
        $this->amount = null;
    }

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