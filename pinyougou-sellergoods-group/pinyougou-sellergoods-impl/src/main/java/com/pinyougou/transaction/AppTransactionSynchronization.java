package com.pinyougou.transaction;

import org.springframework.transaction.support.TransactionSynchronizationAdapter;

import com.pinyougou.model.itf.IRule;

/**
 * @Version: 1.0
 * @Author: jiabin.zhang 张佳宾
 * @Email: jiabin.zhang@rograndec.com
 * @CreateDate 2019/5/23
 */
public class AppTransactionSynchronization extends TransactionSynchronizationAdapter {

    private Object obj;

    private IRule  rule;

    public AppTransactionSynchronization(Object obj, IRule rule) {
        this.obj = obj;
        this.rule = rule;
    }

    @Override
    public void afterCommit() {
        rule.process(obj);
    }
}
