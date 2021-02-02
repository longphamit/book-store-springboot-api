package com.web.bookstore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class AccountEntity {
	@Id
	@Column(name ="username")
	private String username;
	@Column(name ="password")
	private String password;
	@Column(name ="name")
	private String name;
	@Column(name ="email")
	private String email;
	@Column(name ="phone")
	private String phone;
	@Column(name="gender")
	private String gender;
	@Column(name="isActive")
	private boolean isActive;
	@Column(name="isNotBlocked")
	private boolean isNotBlocked;
	@Column(name="lastLogin")
	private Date lastLogin;
	@Column(name="role")
	private String role;
	@Column(name="player_id")
	private String player_id;
	@Column(name="avatar")
	private String avatar;
	
	
	
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getGender() {
		return gender;
	}
	public boolean isActive() {
		return isActive;
	}
	public boolean isNotBlocked() {
		return isNotBlocked;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public String getRole() {
		return role;
	}
	public String getPlayer_id() {
		return player_id;
	}
	public String getAvatar() {
		return avatar;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public void setNotBlocked(boolean isNotBlocked) {
		this.isNotBlocked = isNotBlocked;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setPlayer_id(String player_id) {
		this.player_id = player_id;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
