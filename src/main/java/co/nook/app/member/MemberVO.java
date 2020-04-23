package co.nook.app.member;

public class MemberVO{
	int member_no;
	String id;
	String pw;

	public int getMember_no(){
		return member_no;
	}

	public void setMember_no(int member_no){
		this.member_no = member_no;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getPw(){
		return pw;
	}

	public void setPw(String pw){
		this.pw = pw;
	}
}
