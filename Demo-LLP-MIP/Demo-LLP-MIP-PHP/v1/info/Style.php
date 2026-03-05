<?php
class Style {
    public $bg_color; // 支付页面的背景颜色，默认值为 #ff5001
    public $font_color; // 支付页面字体颜色，默认值为 #ff5001

    public function __construct() {
        $this->bg_color = null;
        $this->font_color = null;
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