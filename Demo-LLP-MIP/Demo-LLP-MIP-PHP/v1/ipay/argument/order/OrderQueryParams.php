<?php
class OrderQueryParams {
    public $mch_id;  // 商户编号是商户在平台上开设的商户号码，为18位数字
    public $txn_seqno;  // 商户支付订单号，商户系统唯一订单号，与平台支付订单号、渠道订单号三者取一
    public $platform_txno;  // 平台支付订单号，连连订单唯一编号，与商户支付订单号、渠道订单号三者取一
    public $chnl_txno;  // 渠道订单号，渠道订单唯一编号，与平台支付订单号、商户支付订单号三者取一
    public $chnl_req_serialId;  // 上游渠道请求流水号，上游渠道请求微信/支付宝/数字人民币的订单号，与平台支付订单号、商户支付订单号三者取一
    public $txn_date;  // 交易日期，支付交易发生日期，格式：YYYYMMDD

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