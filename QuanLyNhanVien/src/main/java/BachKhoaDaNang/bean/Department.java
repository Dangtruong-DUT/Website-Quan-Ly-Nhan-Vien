package BachKhoaDaNang.bean;


public class Department extends AbstractBean<Department> {
	private String idpb;
	private String tenpb;
	private String mota;
	public String getIdpb() {
		return idpb;
	}
	public void setIdpb(String idpb) {
		this.idpb = idpb;
	}
	public String getTenpb() {
		return tenpb;
	}
	public void setTenpb(String tenpb) {
		this.tenpb = tenpb;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
}
