package com.ixanq.entity;
//简历类
public class Resum {
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private String master;//学历
	private String tel;//手机
	private String email;
	private String politicalStatus;//政治面貌
	private String lastWork;//上一份工作
	private String workBackground;//工作经验
	private String salary;//期望工资
	private String hobbies;//兴趣爱好

	public Resum() {
	}

	public Resum(Integer id, String name, String gender, Integer age, String master, String tel, String email, String politicalStatus, String lastWork, String workBackground, String salary, String hobbies) {

		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.master = master;
		this.tel = tel;
		this.email = email;
		this.politicalStatus = politicalStatus;
		this.lastWork = lastWork;
		this.workBackground = workBackground;
		this.salary = salary;
		this.hobbies = hobbies;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getLastWork() {
		return lastWork;
	}

	public void setLastWork(String lastWork) {
		this.lastWork = lastWork;
	}

	public String getWorkBackground() {
		return workBackground;
	}

	public void setWorkBackground(String workBackground) {
		this.workBackground = workBackground;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Resum{" +
				"id=" + id +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				", master='" + master + '\'' +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				", politicalStatus='" + politicalStatus + '\'' +
				", lastWork='" + lastWork + '\'' +
				", workBackground='" + workBackground + '\'' +
				", salary='" + salary + '\'' +
				", hobbies='" + hobbies + '\'' +
				'}';
	}
}
