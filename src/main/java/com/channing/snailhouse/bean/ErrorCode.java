package com.channing.snailhouse.bean;

public class ErrorCode {
    public static final ErrorCode INVALID_PARAM = new ErrorCode("1001", "非法参数");
    public static final ErrorCode SHP_ERROR = new ErrorCode("1002", "shp错误");
    public static final ErrorCode NOTIFY_ERROR = new ErrorCode("1003", "通知发生错误");
    public static final ErrorCode AUTH_INVALID = new ErrorCode("1004", "暂无权限访问");
    public static final ErrorCode HOSP_ERROR = new ErrorCode("1005", "医院端错误");
    public static final ErrorCode BIG_FILE = new ErrorCode("2001", "文件过大");
    public static final ErrorCode FILE_UPLOAD_FAILED = new ErrorCode("2002", "文件上传失败");
    public static final ErrorCode APPLY_VERSION_FAILED = new ErrorCode("2003", "应用版本失败");
    public static final ErrorCode LOG_ZIP_FILE_ERROR = new ErrorCode("2004", "日志文件压缩错误");
    public static final ErrorCode SHP_TASK_FILE_PARSE_ERROR = new ErrorCode("2005", "shp任务文件格式错误,请检查");
    public static final ErrorCode CANCEL_DELIVERY_FAILED = new ErrorCode("4019", "当前送货单已入库，无法取消！");
    public static final ErrorCode HOSP_CALL_FAILED = new ErrorCode("2006", "院内系统调用错误！");
    public static final ErrorCode SHP_TEMPLATE_FILE_PARSE_ERROR = new ErrorCode("2007", "shp模板文件格式错误,请检查");
    public static final ErrorCode GET_HOSP_VERSION_FAILED = new ErrorCode("2008", "请获取新版院端升级包，医院端不支持此升级");
    public static final ErrorCode REFRESH_DOWNLOAD_STATUS =new ErrorCode("2009", "刷新下载状态失败");
    public static final ErrorCode NOT_SUPPORTED = new ErrorCode("2010", "gateway版本太低，请升级");
    public static final ErrorCode HOSP_MODEL_NOT_CONFIG = new ErrorCode("2011", "医院模式未配置");
    public static final ErrorCode HOSP_MODEL_CONFIG_NOT_RESTART = new ErrorCode("2012", "医院模式配置后请重启服务");
    public static final ErrorCode NOT_SUPPORTED_VERSION_ROLLBACK = new ErrorCode("2011", "系统暂不支持版本回退,请检查配置文件版本号");
    public static final ErrorCode TEMPLATE_ZIP_FILE_ERROR = new ErrorCode("2012", "模板文件压缩错误");
    /** 给运维平台接口相关的错误码 **/
    public static final ErrorCode TABLE_NAME_NO_POWER = new ErrorCode("3001", "该表没有对应的权限");
    public static final ErrorCode TABLE_NAME_GET_ERROR = new ErrorCode("3002", "获取解密表名异常!");
    public static final ErrorCode TABLE_DATA_OPERATOR_ERROR = new ErrorCode("3003", "数据库表相关操作异常!");
    public static final ErrorCode OPERATOR_NOT_SUPPORTED = new ErrorCode("3004", "操作符号不支持!");

    //触发器，业务接口sql
    public static final ErrorCode TRIGGLE_NOT_EXIST = new ErrorCode("4000", "触发器不存在!");
    public static final ErrorCode TRIGGLE_ADD_ERROR_NAME_EXIST = new ErrorCode("4001", "新增触发器失败，名称已存在!");
    public static final ErrorCode TRIGGLE_UPDATE_ERROR_NAME_EXIST = new ErrorCode("4002", "修改触发器失败，名称已存在!");
    public static final ErrorCode EXECSQL_NOT_EXIST = new ErrorCode("4004", "业务接口SQL不存在!");
    public static final ErrorCode EXECSQL_ADD_ERROR_NAME_EXIST = new ErrorCode("4005", "新增业务接口SQL失败，名称已存在!");
    public static final ErrorCode EXECSQL_UPDATE_ERROR_NAME_EXIST = new ErrorCode("4006", "修改业务接口SQL失败，名称已存在!");

    public static final ErrorCode EXECSQL_SQL_FAILED = new ErrorCode("4007", "查询数据失败!");
    public static final ErrorCode SQL_QUERY_NOT_ALLOW_MODIFY = new ErrorCode("4008", "此功能只能查询数据!");

    private String code;
    private String msg;

    public ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
