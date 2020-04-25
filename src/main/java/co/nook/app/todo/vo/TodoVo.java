package co.nook.app.todo.vo;

public class TodoVo{
	int uNo;
	int userno;
	String uContent;
	String uDay;
	String uNpc;
	String uCheck;

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
}
