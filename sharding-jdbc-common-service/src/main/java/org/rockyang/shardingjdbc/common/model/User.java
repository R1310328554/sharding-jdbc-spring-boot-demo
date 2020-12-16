package org.rockyang.shardingjdbc.common.model;

/**
 * @author l.k
 */
public final class User {

	private Long userId;

	private String username;

	private String password;

	public User() {
	}

	public User(Long userId) {
		this.userId = userId;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(Long userId, String username, String password) {
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
