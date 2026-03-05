<?php



/**
 * 支付订单关闭 请求参数
 */
class CloseParams
{
    /**
     * 商户编号是商户在平台上开设的商户号码，为18位数字
     */
    public $mch_id;

    /**
     * 商户系统唯一订单号，与平台支付订单号二者取一
     */
    public $txn_seqno;

    /**
     * 连连订单唯一编号，与商户支付订单号二者取一
     */
    public $platform_txno;

    /**
     * 支付交易发生日期，格式：YYYYMMDD
     */
    public $txn_date;

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