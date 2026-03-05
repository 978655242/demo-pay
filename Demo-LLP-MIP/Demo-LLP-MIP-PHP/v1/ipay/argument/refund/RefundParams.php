<?php




class RefundParams
{
    public $mch_id;
    public $refund_seqno;
    public $refund_time;
    public $txn_seqno;
    public $txn_date;
    public $refund_reason;
    public $refund_amount;
    public $notify_url;
    public $refund_method_infos;
    public $payee_refund_infos;
    public $divide_refund_infos;

    public function __construct()
    {
        $this->mch_id = null;
        $this->refund_seqno = null;
        $this->refund_time = null;
        $this->txn_seqno = null;
        $this->txn_date = null;
        $this->refund_reason = null;
        $this->refund_amount = null;
        $this->notify_url = null;
        $this->refund_method_infos = null;
        $this->payee_refund_infos = null;
        $this->divide_refund_infos = null;
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