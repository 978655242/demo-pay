<?php
class Base64 {
    public static function get_base64($s) {
        if ($s === null) {
            return null;
        }
        return self::get_base64_from_bytes(mb_convert_encoding($s, 'UTF-8'));
    }

    public static function get_base64_from_bytes($b) {
        $rb = base64_encode($b);
        if ($rb === null) {
            return null;
        }
        return mb_convert_encoding($rb, 'UTF-8');
    }

    public static function get_from_base64($s) {
        if ($s === null) {
            return null;
        }
        $b = self::get_bytes_from_base64($s);
        if ($b === null) {
            return null;
        }
        return mb_convert_encoding($b, 'UTF-8');
    }

    public static function get_bytes_from_base64($s) {
        if ($s === null) {
            return null;
        }
        $b = base64_decode(mb_convert_encoding($s, 'UTF-8'));
        return $b;
    }
}
?>