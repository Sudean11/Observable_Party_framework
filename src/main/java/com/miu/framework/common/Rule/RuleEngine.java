package com.miu.framework.common.Rule;

import com.miu.framework.common.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private List<Rule> rules = new ArrayList<>();

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public boolean validate(Account account, double amount) {
        for (Rule rule : rules) {
            if (!rule.isSatisfied(account, amount)) {
                System.out.println(rule.getErrorMessage());
                return false;
            }
        }
        return true;
    }
}
