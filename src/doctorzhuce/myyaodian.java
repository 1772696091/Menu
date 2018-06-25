package doctorzhuce;

public class myyaodian {
private int imageid;
private String mingcheng;
private String dizhi;
public myyaodian(int a,String b,String c){
	imageid=a;
	mingcheng=b;
	dizhi=c;
}
public int getImageid() {
	return imageid;
}
public void setImageid(int imageid) {
	this.imageid = imageid;
}
public String getMingcheng() {
	return mingcheng;
}
public void setMingcheng(String mingcheng) {
	this.mingcheng = mingcheng;
}
public String getDizhi() {
	return dizhi;
}
public void setDizhi(String dizhi) {
	this.dizhi = dizhi;
}

}
