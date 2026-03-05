<?php
class StoreInfo {
    public $store_id; // 门店号
    public $store_name; // 门店名称
    public $area_code; // 行政区编码
    public $store_addr; // 门店地址
    public $cashier_no; // 收银员编号

    public function __construct() {
        $this->store_id = null;
        $this->store_name = null;
        $this->area_code = null;
        $this->store_addr = null;
        $this->cashier_no = null;
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