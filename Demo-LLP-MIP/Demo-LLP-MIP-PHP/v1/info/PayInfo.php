<?php
class PayInfo {
    public $bank_code; // 付款银行
    public $pay_mode; // 付款方式
    public $card_type; // 付款卡类型
    public $payer_type; // 付款方类型
    public $payer_uid; // 付款方用户id

    public function __construct() {
        $this->bank_code = null;
        $this->pay_mode = null;
        $this->card_type = null;
        $this->payer_type = null;
        $this->payer_uid = null;
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