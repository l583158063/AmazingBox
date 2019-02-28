package com.soul.amazingbox;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/17.
 */
public class ABoxConstants {
    public static final Map<String, String> keyMaps = new HashMap<String, String>();
    public static final String AUTOLOGINFILE = "autoLogin";

    public static class AutologinClass {
        public static final String AUTOLOGIN_USERNAME = "username";
        public static final String AUTOLOGIN_USERPSW = "password";
        public static final String AUTOLOGIN_FLAG = "flag";
    }

    static {
        keyMaps.put("00000", "处理成功");
        keyMaps.put("00001", "数据库操作失败");
        keyMaps.put("10001", "TOKEN不存在或长度不足");
        keyMaps.put("10002", "TOKEN已失效");
        keyMaps.put("10003", "TOKEN中的SN号不正");
        keyMaps.put("10004", "签名不存在");
        keyMaps.put("10005", "时间戳不存在");
        keyMaps.put("10006", "签名不正确");
        keyMaps.put("20000", "请求超时");
        keyMaps.put("20001", "用户名或密码不存在");
        keyMaps.put("20002", "用户不存在或已暂停使用");
        keyMaps.put("20003", "登录失败次数过多");
        keyMaps.put("20004", "用户名或密码不正确");
        keyMaps.put("20005", "本地用户权限不足");
        keyMaps.put("20101", "服务器端URL或酒店名或房间号或APIKEY不存在");
        keyMaps.put("20201", "红外KEY不存在");
        keyMaps.put("20202", "红外码值不存在");
        keyMaps.put("20203", "红外设备不存在");
        keyMaps.put("20204", "红外码库导入失败");
        keyMaps.put("20205", "红外发射失败");
        keyMaps.put("20206", "红外设备已离线");
        keyMaps.put("20301", "参数不正_CMD0不存在");
        keyMaps.put("20302", "参数不正_CMD1不存在");
        keyMaps.put("20303", "参数不正_PAYLOAD不存在");
        keyMaps.put("20304", "窗帘设备不存在");
        keyMaps.put("20305", "窗帘设备控制失败");
        keyMaps.put("20306", "窗帘设备已离线");
        keyMaps.put("20501", "参数不正_插座状态不存在");
        keyMaps.put("20502", "插座设备不存在");
        keyMaps.put("20503", "插座设备控制失败");
        keyMaps.put("20504", "插座设备已离线");
        keyMaps.put("20601", "参数不正_开关状态不存在");
        keyMaps.put("20602", "参数不正_开关类型不存在(标识几开开关)");
        keyMaps.put("20603", "开关设备不存在");
        keyMaps.put("20604", "开关设备控制失败");
        keyMaps.put("20605", "开关设备已掉线");
        keyMaps.put("20701", "参数不正_射灯操作类型不存在");
        keyMaps.put("20702", "参数不正_射灯操作类型不正确");
        keyMaps.put("20703", "参数不正_射灯开关状态不存在");
        keyMaps.put("20704", "参数不正_射灯色调饱和度不存在");
        keyMaps.put("20705", "参数不正_射灯亮度不存在");
        keyMaps.put("20706", "射灯设备不存在");
        keyMaps.put("20707", "射灯设备控制失败");
        keyMaps.put("20801", "参数不正_设备名称不存在");
        keyMaps.put("20802", "端末设备不存在");
        keyMaps.put("20803", "端末状态属性不存在");
        keyMaps.put("20804", "参数不正_报警时长不正确");
        keyMaps.put("20805", "端末设备已离线");
        keyMaps.put("20806", "设备控制失败");
    }
}
