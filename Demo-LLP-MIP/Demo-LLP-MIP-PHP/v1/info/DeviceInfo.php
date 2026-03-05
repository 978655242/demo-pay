<?php
class DeviceInfo {
    public $device_id; // 设备标识码
    public $device_type; // 设备类型: SMQ-扫码枪 BOX-收款盒子 POS-POS机 PC-个人电脑 PAD-平板电脑 PHONE-手机
    public $device_ip; // 设备IP
    public $device_gps; // 设备GPS
    public $device_imei; // 设备IMEI
    public $device_imsi; // 设备IMSI
    public $device_iccid; // 设备ICCID
    public $device_wifimac; // 设备WIFIMAC
    public $device_mac; // 设备MAC

    public function __construct() {
        $this->device_id = null;
        $this->device_type = null;
        $this->device_ip = null;
        $this->device_gps = null;
        $this->device_imei = null;
        $this->device_imsi = null;
        $this->device_iccid = null;
        $this->device_wifimac = null;
        $this->device_mac = null;
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