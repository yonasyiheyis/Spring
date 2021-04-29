package cs544.exercise16_1.bank.dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cs544.exercise16_1.bank.domain.Account;
import cs544.exercise16_1.bank.domain.AccountEntry;
import cs544.exercise16_1.bank.domain.Customer;

public class AccountDAO implements IAccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();
	private SessionFactory sessionF = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, Customer.class, AccountEntry.class));

	public void saveAccount(Account account) {
		// System.out.println("AccountDAO: saving account with accountnr
		// ="+account.getAccountnumber());
		accountlist.add(account); // add the new
		
		Transaction tx = sessionF.getCurrentSession().beginTransaction();
		sessionF.getCurrentSession().saveOrUpdate(account);
		tx.commit();
		
//		Session session = null;
//		Transaction tx = null;
//		try {
//			session = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, Customer.class, AccountEntry.class)).openSession();
//			tx = session.beginTransaction();
//			session.saveOrUpdate(account);
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
	}

	public void updateAccount(Account account) {
		// System.out.println("AccountDAO: update account with accountnr
		// ="+account.getAccountnumber());
		Account accountexist = loadAccount(account.getAccountnumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}
		//---------------------------------------------------------------------------------------
		Transaction tx = sessionF.getCurrentSession().beginTransaction();
		sessionF.getCurrentSession().saveOrUpdate(account);
		tx.commit();
		//------------------------------------------------------------------------------------------
//		Session session = null;
//		Transaction tx = null;
//		try {
//			session = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, Customer.class, AccountEntry.class)).openSession();
//			tx = session.beginTransaction();
//			session.saveOrUpdate(account);
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}

	}

	public Account loadAccount(long accountnumber) {
		// System.out.println("AccountDAO: loading account with accountnr
		// ="+accountnumber);
//		for (Account account : accountlist) {
//			if (account.getAccountnumber() == accountnumber) {
//				return account;
//			}
//		}
		//----------------------------------------------------------------------------------------------
		Account acc = null;
		Transaction tx = sessionF.getCurrentSession().beginTransaction();
		acc = (Account) sessionF.getCurrentSession().get(Account.class, accountnumber);
		tx.commit();
		//----------------------------------------------------------------------------------------------
//		Session session = null;
//		Transaction tx = null;
//		Account acc = null;
//		try {
//			session = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, Customer.class, AccountEntry.class)).openSession();
//			tx = session.beginTransaction();
//			acc =  (Account) session.get(Account.class, accountnumber);
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
		return acc;
	}

	public Collection<Account> getAccounts() {
		List<Account> accList = new ArrayList<>();
		Transaction tx = sessionF.getCurrentSession().beginTransaction();
		accList = sessionF.getCurrentSession().createQuery("from Account").list();
		tx.commit();
		return accList;
		//----------------------------------------------------------------------------------------------
//		Session session = null;
//		Transaction tx = null;
//		List<Account> accList = new ArrayList<>();
//		try {
//			session = HibernateUtils.getSessionFactory(Arrays.asList(Account.class, Customer.class, AccountEntry.class)).openSession();
//			tx = session.beginTransaction();
//			accList = session.createQuery("from Account").list();
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			session.close();
//		}
//		return accList;
	}

}
