<?php
class PayeeInfo {
    public $payee_uid; // 收款方用户id，当收款方类型是用户时，必填
    public $payee_accttype; // 收款方账户类型
    public $payee_type; // 收款方类型
    public $payee_amount; // 收款方金额，单位元，保留二位小数
    public $payee_memo; // 收款方备注

    public function __construct() {
        $this->payee_uid = null;
        $this->payee_accttype = null;
        $this->payee_type = null;
        $this->payee_amount = null;
        $this->payee_memo = null;
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