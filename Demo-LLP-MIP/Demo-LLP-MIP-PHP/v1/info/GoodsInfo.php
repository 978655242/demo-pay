<?php
class GoodsInfo {
    public $goods_id; // 商品ID
    public $goods_name; // 商品名称

    public function __construct($goods_id, $goods_name) {
        $this->goods_id = $goods_id;
        $this->goods_name = $goods_name;
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