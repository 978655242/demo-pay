<?php
class RiskInfo {
    public $ip_addr; // 交易地址
    public $longitude; // 经度信息
    public $latitude; // 纬度信息
    public $cell_id; // 基站地址
    public $user_register_time; // 商户端用户注册时间，格式：YYYYMMDDH24MISS，14位数字，精确到秒
    public $user_login_method; // 用户本次登录验证方式

    public function __construct() {
        $this->ip_addr = null;
        $this->longitude = null;
        $this->latitude = null;
        $this->cell_id = null;
        $this->user_register_time = null;
        $this->user_login_method = null;
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