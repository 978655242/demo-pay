<?php


class RefundQueryParams
{
    public $mch_id;
    public $refund_seqno;
    public $platform_refundno;
    public $refund_date;

    public function __construct()
    {
        $this->mch_id = null;
        $this->refund_seqno = null;
        $this->platform_refundno = null;
        $this->refund_date = null;
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