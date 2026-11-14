package com.smart.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name="USER")
public class User {
@Id 
@GeneratedValue(strategy = GenerationType.AUTO)    
private int id;

@NotBlank(message = "Name field is required !!")
@Size(min = 2,max = 20,message = "min 2 and max 20 characters are allowed only !!")
private String name;
@Column(unique=true)
@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Invalid Email !!")
private String email;

@Pattern(regexp = "^(?=.*?[0-9])(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[^0-9A-Za-z]).{8,32}$",message = "Invalid Password . Please Fill Strong Password (8 to 32 characters, requires uppercase, lowercase, number, and special character):")

private String password;
private String role;
private boolean enabled;
private String imageUrl;
@Column(length = 500)

@NotBlank(message = "About field is required !!")
@Size(min = 10,max = 500,message = "min 10 and max 500 characters are allowed only !!")
private String about;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user" ) 
private List<Contact> contacts=new ArrayList<>();
 public User(){
    super();
 }
 public int getId() {
    return id;
 }
 public void setId(int id) {
    this.id = id;
 }
 public String getName() {
    return name;
 }
 public void setName(String name) {
    this.name = name;
 }
 public String getEmail() {
    return email;
 }
 public void setEmail(String email) {
    this.email = email;
 }
 public String getPassword() {
    return password;
 }
 public void setPassword(String password) {
    this.password = password;
 }
 public String getRole() {
    return role;
 }
 public void setRole(String role) {
    this.role = role;
 }
 public boolean isEnabled() {
    return enabled;
 }
 public void setEnabled(boolean enabled) {
    this.enabled = enabled;
 }
 public String getImageUrl() {
    return imageUrl;
 }
 public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
 }
 public String getAbout() {
    return about;
 }
 public void setAbout(String about) {
    this.about = about;
 }
 public List<Contact> getContacts() {
   return contacts;
 }
 public void setContacts(List<Contact> contacts) {
   this.contacts = contacts;
 }
 @Override
 public String toString() {
   return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
         + ", enabled=" + enabled + ", imageUrl=" + imageUrl + ", about=" + about + ", contacts=" + contacts + "]";
 }
 
 

 
}
