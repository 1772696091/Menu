package viewpager;

public class wenzhang {
	int id;
String title;
String neirong;
int huifu;
public wenzhang(int a,String arg0,String arg1,int arg2){
	title=arg0;
	neirong=arg1;
	huifu=arg2;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getNeirong() {
	return neirong;
}
public void setNeirong(String neirong) {
	this.neirong = neirong;
}
public int getHuifu() {
	return huifu;
}
public void setHuifu(int huifu) {
	this.huifu = huifu;
}

}
