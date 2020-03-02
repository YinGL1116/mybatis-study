package com.envision.domain;

public class Account {

    private int accountId;
    private String accountName;
    private float accountMoney;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public float getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(float accountMoney) {
        this.accountMoney = accountMoney;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountMoney=" + accountMoney +
                '}';
    }
}
