package BachKhoaDaNang.bean;

public class Account  extends AbstractBean<Account> {
	private String userName;
	private String passWord;
	private String idNV;
	private String role;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getIdNV() {
		return idNV;
	}
	public void setIdNV(String idNV) {
		this.idNV = idNV;
	}
}
