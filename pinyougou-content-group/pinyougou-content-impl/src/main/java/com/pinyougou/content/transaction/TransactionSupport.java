package com.pinyougou.content.transaction;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public abstract class TransactionSupport {

    @Resource
    private DataSourceTransactionManager transactionManager;

    /**
     * 创建一个事务
     * @param transactionManager  事务管理器
     * @param propagationBehavior 事务传播级别
     * @return
     * @author jianghong.huang
     * @date 2018/4/3
     */
    public TransactionStatus createTransactionStatus(int propagationBehavior) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(propagationBehavior);
        return transactionManager.getTransaction(def);
    }

    /**
     * 提交事务
     * @param transactionStatus
     * @author jianghong.huang
     * @date 2018/4/9
     */
    public void commitTransaction(TransactionStatus transactionStatus) {
        if (transactionStatus != null) {
            this.transactionManager.commit(transactionStatus);
        }
    }

    /**
     * 回滚事务
     * @param transactionStatus
     * @author jianghong.huang
     * @date 2018/4/9
     */
    public void rollbackTransaction(TransactionStatus transactionStatus) {
        if (transactionStatus != null) {
            this.transactionManager.rollback(transactionStatus);
        }
    }

    public void registerSynchronization(TransactionSynchronization TransactionSynchronizationAfterThing) {
        TransactionSynchronizationManager.registerSynchronization(TransactionSynchronizationAfterThing);
    }
}
