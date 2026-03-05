<?php
class TokenApplyParams
{
    public $mch_id = null;
    public $sub_mchid = null;
    public $user_id = null;
    public $txn_seqno = null;
    public $txn_time = null;
    public $notify_url = null;
    public $return_url = null;
    public $risk_info = null;  // 请咨询技术对接按需传递
    public $device_info = null;
    public $card_info = null;

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