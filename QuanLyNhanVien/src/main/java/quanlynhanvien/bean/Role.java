package quanlynhanvien.bean;

public class Role extends AbstractBean<Role> {

	private String code="ADMIN";
	private String name ="Chi Pheo";
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
