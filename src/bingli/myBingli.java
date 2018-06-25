package bingli;

public class myBingli {
	private String yonghu;
	private String leixing;
	private String yiyuan;
	private String keshi;
	private String doctor;
	private String jutibingli;
	private String yishengjianyi;
	public myBingli(String yonghu,String leixing,String yiyuan,String doctor,String keshi,String juti,String jianyi){
		this.doctor=doctor;
		this.jutibingli=juti;
		this.keshi=keshi;
		this.leixing=leixing;
		this.yishengjianyi=jianyi;
		this.yiyuan=yiyuan;
		this.yonghu=yonghu;
	}
	public myBingli(String yonghu, String leixing, String yiyuan,
			String doctor, String keshi) {
		// TODO Auto-generated constructor stub
		this.doctor=doctor;
		this.keshi=keshi;
		this.leixing=leixing;
		this.yiyuan=yiyuan;
		this.yonghu=yonghu;
	}
	public String getYonghu() {
		return yonghu;
	}
	public void setYonghu(String yonghu) {
		this.yonghu = yonghu;
	}
	public String getLeixing() {
		return leixing;
	}
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	public String getYiyuan() {
		return yiyuan;
	}
	public void setYiyuan(String yiyuan) {
		this.yiyuan = yiyuan;
	}
	public String getKeshi() {
		return keshi;
	}
	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public String getJutibingli() {
		return jutibingli;
	}
	public void setJutibingli(String jutibingli) {
		this.jutibingli = jutibingli;
	}
	public String getYishengjianyi() {
		return yishengjianyi;
	}
	public void setYishengjianyi(String yishengjianyi) {
		this.yishengjianyi = yishengjianyi;
	}
	

}
