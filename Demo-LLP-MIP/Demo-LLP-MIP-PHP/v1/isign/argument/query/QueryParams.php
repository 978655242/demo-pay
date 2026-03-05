<?php


class QueryParams
{
    public $mch_id;
    public $sub_mchid;
    public $user_id;

    public function __construct()
    {
        $this->mch_id = null;
        $this->sub_mchid = null;
        $this->user_id = null;
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