package service;

import java.math.BigDecimal;

import pojo.CashAccount;
import repository.TradeAccountRepository;

public class CashAccountService implements TradeAccountService {

    private TradeAccountRepository repository;

    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount account = (CashAccount) repository.retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().add(amount));
        repository.updateTradeAccount(account);

    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        CashAccount account = (CashAccount) repository.retrieveTradeAccount(id);
        account.setCashBalance(account.getCashBalance().subtract(amount));
        repository.updateTradeAccount(account);

    }
    
    public CashAccountService(TradeAccountRepository repository){
        this.repository = repository;
    }

    public void createTradeAccount(CashAccount cashAccount) {
        this.repository.createTradeAccount(cashAccount);
    }

    public CashAccount retrieveTradeAccount(String id) {
        return (CashAccount) this.repository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(CashAccount cashAccount) {
        this.repository.updateTradeAccount(cashAccount);
    }

    public void deleteTradeAccount(String id) {
        this.repository.deleteTradeAccount(id);
    }

}
