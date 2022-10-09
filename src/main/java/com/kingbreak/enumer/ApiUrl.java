package com.kingbreak.enumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author li
 * @date 2021/9/22
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ApiUrl {

    DEVICE_CONTROL("/api/pms/v1/deviceControl", "道闸控制"),
    BATCH_ADD("/api/resource/v1/vehicle/batch/add", "批量添加车辆"),
    CHARGE_DELETION("/api/pms/v1/car/charge/deletion", "取消包期"),
    CAR_CHARGE("/api/pms/v1/car/charge", "车辆充值"),
    ALARMCAR_ADDITION("/api/pms/v1/alarmCar/addition", "车辆布控"),
    ALARMCAR_DELETION("/api/pms/v1/alarmCar/deletion", "取消车辆布控"),
    CROSSRECORDS_PAGE("/api/pms/v1/crossRecords/page", "查询过车记录"),
    IMAGE("/api/pms/v1/image", "查询车辆抓拍图片"),
    DEVICE_STATUS("/api/nms/v1/online/encode_device/get", "设备状态"),
    LED_CONTROL("/api/pms/v1/device/led/control", "电子屏控制"),
    VOICE_CONTROL("/api/pms/v1/device/voice/control", "设备播报控制"),


    ;


    private String url;
    private String content;
}
