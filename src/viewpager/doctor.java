package viewpager;

public class doctor {
private int id;
private String name;
private String hospital;
private String zhuzhi;
public doctor(int id,String a,String b,String c){
	name=a;
	hospital=b;
	zhuzhi=c;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getHospital() {
	return hospital;
}
public void setHospital(String hospital) {
	this.hospital = hospital;
}
public String getJianjie() {
	return zhuzhi;
}
public void setJianjie(String jianjie) {
	this.zhuzhi = jianjie;
}

}
