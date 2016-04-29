package com.pronto.dao.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.pronto.dao.CoreDAO;
import com.pronto.entities.account.Account;

public class UserRealm extends AuthorizingRealm {
	protected final Session session;

	@Inject
	protected CoreDAO dao;

	public UserRealm(Session session) {

		super(new MemoryConstrainedCacheManager());

		this.session = session;

		setName("localaccounts");
		setAuthenticationTokenClass(UsernamePasswordToken.class);

		setCredentialsMatcher(new HashedCredentialsMatcher(Sha1Hash.ALGORITHM_NAME));

		setPermissionResolver(new WildcardPermissionResolver());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		if (principals == null)
			throw new AuthorizationException("PrincipalCollection was null, which should not happen");

		if (principals.isEmpty())
			return null;

		if (principals.fromRealm(getName()).size() <= 0)
			return null;

		String username = (String) principals.fromRealm(getName()).iterator().next();

		if (username == null)
			return null;
		Account user = findByUsername(username);

		if (user == null)
			return null;

		Set<String> roles = new HashSet<String>();

		// roles.add(user.getCurrentRole().getName());

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

		authorizationInfo.addRoles(roles);

		// Set<String> permissions = new HashSet<String>();
		//
		// List<Permission> list = dao.getPermissionList(user.getCurrentRole());
		//
		// for (Permission permission : list) {
		//
		// permissions.add(permission.getPermissionName());
		// }
		//
		// authorizationInfo.addStringPermissions(permissions);

		return authorizationInfo;
	}

	private Account findByUsername(String username) {
		return (Account) session.createCriteria(Account.class).add(Restrictions.eq("username", username))
				.uniqueResult();
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		String username = upToken.getUsername();

		// Null username is invalid
		if (username == null) {
			throw new AccountException("Null usernames are not allowed by this realm.");
		}

		Account user = findByUsername(username);

		// if (user.isAccountLocked()) {
		// throw new LockedAccountException("Account [" + username + "] is
		// locked.");
		// }

		return new SimpleAuthenticationInfo(username, user.getPassword(), new SimpleByteSource(user.getPasswordSalt()),
				getName());
	}
}
