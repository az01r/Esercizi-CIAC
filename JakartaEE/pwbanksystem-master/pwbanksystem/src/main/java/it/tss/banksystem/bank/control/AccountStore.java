/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.bank.control;

import it.tss.banksystem.bank.boundary.BankException;
import it.tss.banksystem.bank.boundary.dto.AccountList;
import it.tss.banksystem.bank.boundary.dto.AccountUpdate;
import it.tss.banksystem.bank.boundary.dto.AccountView;
import it.tss.banksystem.bank.entity.Account;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Paolo
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class AccountStore {

    @PersistenceContext
    private EntityManager em;

    public Optional<Account> find(Long id) {
        Account found = em.find(Account.class, id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    public List<Account> search() {
        return em.createQuery("select e from Account e where e.deleted=false order by e.user.usr", Account.class)
                .getResultList();
    }

    public List<Account> findByUser(Long userId) {
        return em.createQuery("select e from Account e where e.user.id= :userId", Account.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public Optional<AccountView> findView(Long id) {
        return find(id).map(AccountView::new);
    }

    public AccountList searchView() {
        AccountList result = new AccountList();
        result.data = search().stream().map(AccountView::new).collect(Collectors.toList());
        result.total = result.data.size();
        return result;
    }

    public AccountList findByUserView(Long userId) {
        AccountList result = new AccountList();
        result.data = findByUser(userId).stream().map(AccountView::new).collect(Collectors.toList());
        result.total = result.data.size();
        return result;
    }

    public Account create(Account account) {
        return em.merge(account);
    }

    /**
     * Update only overDraft property
     *
     * @param account
     * @param a
     * @return
     */
    public Account update(Account account, AccountUpdate a) {
        account.setOverDraft(a.overDraft);
        return em.merge(account);
    }

    public void delete(Long id) {
        Account found = em.find(Account.class, id);
        found.setDeleted(true);
        em.merge(found);
    }

    public double totalDeposit() {
        return em.createQuery("select e from Account e where e.deleted=false ", Account.class)
                .getResultStream()
                .mapToDouble(Account::getBalance)
                .sum();
    }

    /*
    public double totalDeposit() {
        return (double)(em.createQuery("SELECT SUM(balance) FROM Account e WHERE e.deleted=FALSE", Double.class).getSingleResult());         
    }
    */

    public void deposit(Long accountId, Double amount) {
        Account account = find(accountId).orElseThrow(() -> new BankException("Account inesistente"));
        account.setBalance(account.getBalance() + amount);
        em.merge(account);
    }

    public void withdrawal(Long accountId, Double amount) {
        Account account = find(accountId).orElseThrow(() -> new BankException("Account inesistente"));
        checkWithdrawal(account, amount);
        account.setBalance(account.getBalance() - amount);
        em.merge(account);
    }

    public void transfer(Long accountId, Long transferId, Double amount) {
        Account account = find(accountId).orElseThrow(() -> new BankException("Account inesistente"));
        checkWithdrawal(account, amount);
        Account transfer = find(transferId).orElseThrow(() -> new BankException("Transfer Account inesistente"));
        account.setBalance(account.getBalance() - amount);
        transfer.setBalance(transfer.getBalance() + amount);
        em.merge(account);
        em.merge(transfer);
    }

    private void checkWithdrawal(Account account, Double amount) {
        if (account.getBalance() + account.getOverDraft() < amount) {
            throw new BankException("Saldo insufficiente");
        }
    }
}
