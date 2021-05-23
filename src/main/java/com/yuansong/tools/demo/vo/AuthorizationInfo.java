package com.yuansong.tools.demo.vo;

public class AuthorizationInfo {
	private String authorizerAppid; 
	private String authorizerAccessToken;
	private String authorizerRefreshToken;
	private String expiresTime;
	private String updateTime;
	public String getAuthorizerAppid() {
		return authorizerAppid;
	}
	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}
	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}
	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}
	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}
	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}
	public String getExpiresTime() {
		return expiresTime;
	}
	public void setExpiresTime(String expiresTime) {
		this.expiresTime = expiresTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
