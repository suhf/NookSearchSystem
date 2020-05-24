package co.nook.app.user.service;


public class UserVO{
	int userNo;
	String id;
	String password;
	String salt;
	String hemisphere;
	String CharacterName;
	String IslandName;
	String friendCode;

	public int getUserNo(){
		return userNo;
	}

	public void setUserNo(int userNo){
		this.userNo = userNo;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getSalt(){
		return salt;
	}

	public void setSalt(String salt){
		this.salt = salt;
	}

	public String getHemisphere(){
		return hemisphere;
	}

	public void setHemisphere(String hemisphere){
		this.hemisphere = hemisphere;
	}

	public String getCharacterName(){
		return CharacterName;
	}

	public void setCharacterName(String characterName){
		CharacterName = characterName;
	}

	public String getIslandName(){
		return IslandName;
	}

	public void setIslandName(String islandName){
		IslandName = islandName;
	}

	public String getFriendCode(){
		return friendCode;
	}

	public void setFriendCode(String friendCode){
		this.friendCode = friendCode;
	}
}
