package cn.yfkj.wxapp.utils.project;

/**
 * @author: maochangan
 * @Date: 2018/7/19 16:15
 * @Description: 编码和信息
 */
public enum SerResultCode {
    //业务编码信息
    SUCCESS("业务操作成功", 1),
    FAIL("业务操作失败", 0),
    ERROR("系统异常", -1),
    ADMIN_LOIGN("用户名密码错误", -1),
    NO_DATA("无数据", 10000),
    DATA_EXIT("数据存在", 10001),
    MSG("通道信息未配置" , -100000),

    GET_AR_THEME("获取主题详情", 1000),
    GET_THEME_LIST("获取ar主题列表", 1001),
    ADD_AR_THEME("添加ar主题", 1002),
    UPDATE_AR_THEME("修改主题信息", 1003),
    UPDATE_AR_THRMR_STATUS("修改主题状态", 1004),

    GET_IDENTIFY_LIST("获取识别图列表", 2000),
    GET_IDENTIFY("获取识别图明细", 2001),
    SET_IDENTIFY_STATUS("修改识别图状态", 2002),
    DEL_IDENTIFY("删除识别图", 2003),
    ADD_IDENTIFY("添加识别图", 2004),
    EDIT_IDENTIFY("修改识别图", 2005),

    GET_CONTENT_LIST("获取展示内容", 3000),
    GET_CONTENT_INFO("获取展示内容详情", 3001),
    SET_CONTENT_STATUS("设置展示内容状态", 3002),
    DEL_CONTENT("删除展示内容", 3003),
    ADD_CONTENT("新增展示内容", 3004),
    EIDT_CONTENT("修改展示内容", 3005),

    ACTIVITY_LIST("获取活动列表" , 4000),
    ACTIVITY_INFO("获取活动详情", 4001),
    SET_ACTIVITY_STATUS("修改活动状态",4002),
    DEL_ACTIVITY("删除活动", 4003),
    ADD_ACTIVITY("添加活动", 4004),
    EDIT_ACTIVITY("修改活动",4005),
    CHANGE_ACTIVITY_IDENTIFY("修改识别图",4006),
    GET_ACTIVITY_IDENTIFY("获取活动配置列表" , 4007),
    GET_ACTIVITY_IDENTIFY_INFO("获取活动配置详情" , 4008),


    DELETE_AR_THEME("删除主题", 1005),
    AR_THEME_VIEW("预览主题库", 1006),
    UPLOAD_FILE("上传文件", 1100);


    private int code;

    private String msg;


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    SerResultCode(String value, int code) {
        this.code = code;
        this.msg = value;
    }
}