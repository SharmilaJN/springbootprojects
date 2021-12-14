package com.harman.dto;

public class ErrorMsg {

	private String msg;
	private String errcode;
	
	
	public ErrorMsg(String msg, String errcode) {
		super();
		this.msg = msg;
		this.errcode = errcode;
	}
	public void setMsg(String msg ) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	
	

}
