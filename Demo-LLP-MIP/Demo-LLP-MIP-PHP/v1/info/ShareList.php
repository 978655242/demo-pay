<?php
class ShareList {
    public $share_uid; // 分账方用户
    public $share_amount; // 分账金额
    public $share_percent; // 分账比例
    public $share_memo; // 分账说明

    public function __construct() {
        $this->share_uid = null;
        $this->share_amount = null;
        $this->share_percent = null;
        $this->share_memo = null;
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