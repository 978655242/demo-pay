<?php


class SupportBankQueryParams
{
    public $mch_id;
    public $pay_type;
    public $bank_code;
    public $card_type;
    public $biz_scene;

    public function __construct()
    {
        $this->mch_id = null;
        $this->pay_type = null;
        $this->bank_code = null;
        $this->card_type = null;
        $this->biz_scene = null;
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