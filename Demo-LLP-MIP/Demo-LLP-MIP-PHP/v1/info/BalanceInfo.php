<?php
class BalanceInfo {
    public $user_id; // 余额支付 userid，用户在商户系统中的唯一编号，需要包装 mch_id+user_id 唯一
    public $user_type; // 用户类型: MCH-商户 USER-用户
    public $password; // 支付密码，余额支付默认需要支付密码
    public $random_key; // 密码随机因子 key，随机因子获取接口返回

    public function __construct() {
        $this->user_id = null;
        $this->user_type = null;
        $this->password = null;
        $this->random_key = null;
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