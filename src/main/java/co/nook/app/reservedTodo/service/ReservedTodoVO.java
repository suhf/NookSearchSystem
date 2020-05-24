package co.nook.app.reservedTodo.service;

import java.util.Date;

public class ReservedTodoVO{
	private int rTodoNo;
	private int userNo;
	private int rUserNo;
	private String rIsAlways;
	private String rContent;
	private String Day;
	private int rMinCount;
	private int rMaxCount;
	private String rNPCName;
	private String rIsEvent;
	private String rEventStartDate;
	private int rEventStartHour;
	private String rEventEndDate;
	private int rEventEndHour;
	private String rSpecialFunction;
	private String rSpecialData1;
	private String rSpecialData2;
	private String rSpecialData3;
	private String rSpecialData4;
	private Date rReservedDate;

	public int getrTodoNo(){
		return rTodoNo;
	}

	public void setrTodoNo(int rTodoNo){
		this.rTodoNo = rTodoNo;
	}

	public int getUserNo(){
		return userNo;
	}

	public void setUserNo(int userNo){
		this.userNo = userNo;
	}

	public int getrUserNo(){
		return rUserNo;
	}

	public void setrUserNo(int rUserNo){
		this.rUserNo = rUserNo;
	}

	public String getrIsAlways(){
		return rIsAlways;
	}

	public void setrIsAlways(String rIsAlways){
		this.rIsAlways = rIsAlways;
	}

	public String getrContent(){
		return rContent;
	}

	public void setrContent(String rContent){
		this.rContent = rContent;
	}

	public String getDay(){
		return Day;
	}

	public void setDay(String day){
		Day = day;
	}

	public int getrMinCount(){
		return rMinCount;
	}

	public void setrMinCount(int rMinCount){
		this.rMinCount = rMinCount;
	}

	public int getrMaxCount(){
		return rMaxCount;
	}

	public void setrMaxCount(int rMaxCount){
		this.rMaxCount = rMaxCount;
	}

	public String getrNPCName(){
		return rNPCName;
	}

	public void setrNPCName(String rNPCName){
		this.rNPCName = rNPCName;
	}

	public String getrIsEvent(){
		return rIsEvent;
	}

	public void setrIsEvent(String rIsEvent){
		this.rIsEvent = rIsEvent;
	}

	public String getrEventStartDate(){
		return rEventStartDate;
	}

	public void setrEventStartDate(String rEventStartDate){
		this.rEventStartDate = rEventStartDate;
	}

	public int getrEventStartHour(){
		return rEventStartHour;
	}

	public void setrEventStartHour(int rEventStartHour){
		this.rEventStartHour = rEventStartHour;
	}

	public String getrEventEndDate(){
		return rEventEndDate;
	}

	public void setrEventEndDate(String rEventEndDate){
		this.rEventEndDate = rEventEndDate;
	}

	public int getrEventEndHour(){
		return rEventEndHour;
	}

	public void setrEventEndHour(int rEventEndHour){
		this.rEventEndHour = rEventEndHour;
	}

	public String getrSpecialFunction(){
		return rSpecialFunction;
	}

	public void setrSpecialFunction(String rSpecialFunction){
		this.rSpecialFunction = rSpecialFunction;
	}

	public String getrSpecialData1(){
		return rSpecialData1;
	}

	public void setrSpecialData1(String rSpecialData1){
		this.rSpecialData1 = rSpecialData1;
	}

	public String getrSpecialData2(){
		return rSpecialData2;
	}

	public void setrSpecialData2(String rSpecialData2){
		this.rSpecialData2 = rSpecialData2;
	}

	public String getrSpecialData3(){
		return rSpecialData3;
	}

	public void setrSpecialData3(String rSpecialData3){
		this.rSpecialData3 = rSpecialData3;
	}

	public String getrSpecialData4(){
		return rSpecialData4;
	}

	public void setrSpecialData4(String rSpecialData4){
		this.rSpecialData4 = rSpecialData4;
	}

	public Date getrReservedDate(){
		return rReservedDate;
	}

	public void setrReservedDate(Date rReservedDate){
		this.rReservedDate = rReservedDate;
	}
}
