package accounts;

import java.io.Serializable;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class is container for account types (user, admin)
 */
public class Account<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private T account;
	
	public Account(T account) {
		this.account = account;
	}
	
	/**
	 * Desc: Method gets account
	 * Param: 
	 * Return: Acct of type T (user, admin)
	*/
	public T getAccount() {
		return account;
	}
	
	public String toString()
	   {
	      return "\nUSER\n" + account;
	   }
	
	
}