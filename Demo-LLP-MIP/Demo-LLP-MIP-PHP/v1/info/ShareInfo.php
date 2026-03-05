<?php
class ShareInfo {
    public $share_flag; // 分账标识
    public $share_type; // 分账类型
    public $share_list = []; // 分账列表信息

    public function __construct() {
        $this->share_flag = null;
        $this->share_type = null;
        $this->share_list = [];
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