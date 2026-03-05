<?php
class CardInfo {
    public $agree_no; // 您通过签约绑卡所生成协议号。如果是签约申请时，无该字段
    public $card_no; // 需加密传输，该字段与agree_no只需传一个
    public $id_type; // ID_CARD
    public $id_no; // 需加密传输，该字段与agree_no只需传一个
    public $acct_name; // 需加密传输，该字段与agree_no只需传一个
    public $bind_phone; // 需加密传输，该字段与agree_no只需传一个
    public $bank_code; // 银行编码
    public $card_type; // CREDIT_CARD-贷记卡, DEBIT_CARD-借记卡, PUBLIC_CARD-对公卡

    public function __construct() {
        $this->agree_no = null;
        $this->card_no = null;
        $this->id_type = null;
        $this->id_no = null;
        $this->acct_name = null;
        $this->bind_phone = null;
        $this->bank_code = null;
        $this->card_type = null;
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