package com.xtt.web.log;

import com.xtt.lib.enums.LogDetailEnum;
import com.xtt.lib.enums.OperationUnit;
import com.xtt.lib.enums.Platform;

import java.lang.annotation.*;

/**
 * @Description LogAnnotation
 * @Author Monster
 * @Date 2021/3/16 15:27
 * @Version 1.0
 */
// 表明该注解可以应用的java元素类型
@Target(ElementType.METHOD)
// 表明该注解的生命周期
@Retention(RetentionPolicy.RUNTIME)
// 表明该注解标记的元素可以被Javadoc 或类似的工具文档化
@Documented
public @interface LogAnnotation {
    /**
     * 方法描述
     */
    LogDetailEnum detail() default LogDetailEnum.UNKNOWN;

    /**
     * 操作类型(enum):主要是select,insert,update,delete
     */
    LogDetailEnum operationType() default LogDetailEnum.UNKNOWN;

    /**
     * 被操作的模块
     */
    OperationUnit operationUnit() default OperationUnit.UNKNOWN;

    //用户Id
    String userId() default "null";
    //公司Id
    String companyId() default "null";
    //平台标识
    Platform platformNO() default Platform.IDS_CLOUD;
}
