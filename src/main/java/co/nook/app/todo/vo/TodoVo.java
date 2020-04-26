package co.nook.app.todo.vo;

public class TodoVo{
	int uNo;
	int userno;
	String uContent;
	String uDay;
	String uNpc;
	String uCheck;
	String uSub1;
	String uSub2;

	public int getuNo(){
		return uNo;
	}

	public void setuNo(int uNo){
		this.uNo = uNo;
	}

	public int getUserno(){
		return userno;
	}

	public void setUserno(int userno){
		this.userno = userno;
	}

	public String getuContent(){
		return uContent;
	}

	public void setuContent(String uContent){
		this.uContent = uContent;
	}

	public String getuDay(){
		return uDay;
	}

	public void setuDay(String uDay){
		this.uDay = uDay;
	}

	public String getuNpc(){
		return uNpc;
	}

	public void setuNpc(String uNpc){
		this.uNpc = uNpc;
	}

	public String getuCheck(){
		return uCheck;
	}

	public void setuCheck(String uCheck){
		this.uCheck = uCheck;
	}

	public String getuSub1(){
		return uSub1;
	}

	public void setuSub1(String uSub1){
		this.uSub1 = uSub1;
	}

	public String getuSub2(){
		return uSub2;
	}

	public void setuSub2(String uSub2){
		this.uSub2 = uSub2;
	}
}
