<?php
class LLianPayDateUtils {
    const DefaultPattern = "YmdHis";

    public function __construct() {}

    public static function get_timestamp() {
        $shanghai_tz = new DateTimeZone('Asia/Shanghai');
        $now = new DateTime('now', $shanghai_tz);
        return LLianPayDateUtils::format($now, LLianPayDateUtils::DefaultPattern);
    }

    public static function format($date, $pattern) {
        return $date->format($pattern);
    }
}


?>