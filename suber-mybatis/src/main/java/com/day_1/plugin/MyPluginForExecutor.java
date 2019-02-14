package com.day_1.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

/**
 * @author wangyongchao
 * @date 2019/2/14  17:01
 */


/**
 * MyBatis 允许你在已映射语句执行过程中的某一点进行拦截调用。默认情况下，MyBatis 允许使用插件来拦截的方法调用包括：
 * <p>
 * Executor (update, query, flushStatements, commit, rollback,
 * getTransaction, close, isClosed)
 * ParameterHandler (getParameterObject, setParameters)
 * ResultSetHandler (handleResultSets, handleOutputParameters)
 * StatementHandler (prepare, parameterize, batch, update, query)
 * ---------------------
 * 作者：Ricky_Fung
 * 来源：CSDN
 * 原文：https://blog.csdn.net/top_code/article/details/55520948
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 */
@Intercepts(@Signature(type = Executor.class,method = "update",args ={MappedStatement.class, Object.class} ))
public class MyPluginForExecutor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
