package com.day_1.plugin;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author wangyongchao
 * @date 2019/2/14  16:36
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
@Intercepts(@Signature(method ="prepare", args ={ Connection.class, Integer.class}, type =StatementHandler.class))

public class MyPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //statementHandler.prepare(null, 10);
        BoundSql boundSql = statementHandler.getBoundSql();
        String sql = boundSql.getSql();
        System.out.println(("mybatis intercept sql:{}" + sql));
        System.out.println("param:"+statementHandler.getParameterHandler().getParameterObject());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String dialect = properties.getProperty("dialect");
        System.out.println(("mybatis intercept dialect:{}" + dialect));
    }

}
