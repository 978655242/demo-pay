<?php




class CancelParams
{
    public $mch_id;
    public $sub_mchid;
    public $user_id;
    public $card_info;

    public function __construct()
    {
        $this->mch_id = null;
        $this->sub_mchid = null;
        $this->user_id = null;
        $this->card_info = null;  // 假设 CardInfo 为另一个类，这里只传agree_no，其他字段无需传值
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