package domain;

public class User {
	private int shell;
	private String username;
	private String password;
	private int id;
	private String lastTime;
	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getShell() {
		return shell;
	}

	public void setShell(int shell) {
		this.shell = shell;
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
		return "User [shell=" + shell + ", username=" + username + ", password=" + password + ", id=" + id
				+ ", lastTime=" + lastTime + "]";
	}

}
