package com.web.bookstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Account")
public class AccountEntity implements Serializable,UserDetails {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name ="username")
	private String userName;
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
	@Column(name="isNotlocked")
	private boolean isNotBlocked;
	@Column(name="lastLogin")
	private Date lastLogin;
	@Column(name="role")
	private String role;
	@Column(name="player_id")
	private String player_id;
	@Column(name="avatar")
	private String avatar;
	
	
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
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
	@Override
	public String getUsername() {
		
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority>  collectionGrant= new  ArrayList<SimpleGrantedAuthority>();
		collectionGrant.add(new SimpleGrantedAuthority(getRole()));
		return collectionGrant;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
