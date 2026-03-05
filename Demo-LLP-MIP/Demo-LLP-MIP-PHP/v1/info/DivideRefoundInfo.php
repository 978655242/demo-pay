<?php
class DivideRefundInfo {
    public $divide_uid; // 分账方用户id
    public $divide_refund_amount; // 分账金额，以元为单位，Number(8,2)

    public function __construct() {
        $this->divide_uid = null;
        $this->divide_refund_amount = null;
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