<?php


class VerifyParams
{
    public $mch_id = null;
    public $sub_mchid = null;
    public $user_id = null;
    public $token = null;
    public $verify_code = null;

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