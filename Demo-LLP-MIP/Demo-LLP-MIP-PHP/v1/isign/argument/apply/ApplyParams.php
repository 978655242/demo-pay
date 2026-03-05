<?php


class ApplyParams
{
    public $mch_id;
    public $sub_mchid;
    public $user_id;
    public $txn_seqno;
    public $txn_time;
    public $card_info;

    public function __construct()
    {
        $this->mch_id = null;
        $this->sub_mchid = null;
        $this->user_id = null;
        $this->txn_seqno = null;
        $this->txn_time = null;
        $this->card_info = null;  // 假设 CardInfo 为另一个类
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