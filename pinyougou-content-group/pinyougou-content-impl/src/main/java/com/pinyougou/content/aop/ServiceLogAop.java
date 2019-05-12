package com.pinyougou.content.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pinyougou.model.BusinessException;
import com.pinyougou.model.ServiceResult;

/**
 * 日志记录
 * 
 * @Author: lei.zhang
 * @Email: lei.zhang@rograndec.com
 * @CreateDate: 2019/4/1
 * @Version: 1.0
 */
public class ServiceLogAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("rawtypes")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {
        ServiceResult result = new ServiceResult();
        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Method currentMethod = point.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes());

        //获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        String methodName = currentMethod.getName();

        try {
            // 执行业务
            Object obj = point.proceed(point.getArgs());
            if (obj instanceof ServiceResult) {
                result = (ServiceResult) obj;
            } else {
                log.warn("[" + className + "][" + methodName + "]:返回对象错误，不是ServiceResult");
                return obj;
            }
        } catch (BusinessException be) {
            result.setError(be.getCode() != null ? be.getCode() : "", be.getMessage());
            log.warn("[" + className.toString() + "][" + methodName + "]:" + be.getMessage(), be);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("请求服务器数据失败，请稍后再试");
            log.error("[" + className.toString() + "][" + methodName + "]:发生异常:", e);
        }
        return result;
    }

}