package com.ixanq.entity;
//简历类
public class ResumeForManager {
	private Integer id;
	private Integer advertiseId;//招聘信息
	private String visitorName;
	private String name;
	private String gender;
	private Integer age;
	private String politicalStatus;//政治面貌
	private String tel;//手机
	private String email;
	private String lastWork;//上一份工作
	private String salary;//期望工资	private Integer age;
	private Integer departmentId;
	private Integer workPositionId;
	private String master;//学历
	private String workBackground;//工作经验
	private String hobbies;//兴趣爱好
	private String status;//状态 读/未读

	public ResumeForManager() {
	}

	public ResumeForManager(Integer advertiseId, String visitorName, String name, String gender, Integer age, String politicalStatus, String tel, String email, String lastWork, String salary, Integer departmentId, Integer workPositionId, String master, String workBackground, String hobbies, String status) {

		this.advertiseId = advertiseId;
		this.visitorName = visitorName;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.politicalStatus = politicalStatus;
		this.tel = tel;
		this.email = email;
		this.lastWork = lastWork;
		this.salary = salary;
		this.departmentId = departmentId;
		this.workPositionId = workPositionId;
		this.master = master;
		this.workBackground = workBackground;
		this.hobbies = hobbies;
		this.status = status;
	}

	public ResumeForManager(Integer id, Integer advertiseId, String visitorName, String name, String gender, Integer age, String politicalStatus, String tel, String email, String lastWork, String salary, Integer departmentId, Integer workPositionId, String master, String workBackground, String hobbies, String status) {

		this.id = id;
		this.advertiseId = advertiseId;
		this.visitorName = visitorName;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.politicalStatus = politicalStatus;
		this.tel = tel;
		this.email = email;
		this.lastWork = lastWork;
		this.salary = salary;
		this.departmentId = departmentId;
		this.workPositionId = workPositionId;
		this.master = master;
		this.workBackground = workBackground;
		this.hobbies = hobbies;
		this.status = status;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdvertiseId() {
		return advertiseId;
	}

	public void setAdvertiseId(Integer advertiseId) {
		this.advertiseId = advertiseId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
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

	public String getPoliticalStatus() {
		return politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
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

	public String getLastWork() {
		return lastWork;
	}

	public void setLastWork(String lastWork) {
		this.lastWork = lastWork;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getWorkPositionId() {
		return workPositionId;
	}

	public void setWorkPositionId(Integer workPositionId) {
		this.workPositionId = workPositionId;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getWorkBackground() {
		return workBackground;
	}

	public void setWorkBackground(String workBackground) {
		this.workBackground = workBackground;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResumeForManager{" +
				"id=" + id +
				", advertiseId=" + advertiseId +
				", visitorName='" + visitorName + '\'' +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				", politicalStatus='" + politicalStatus + '\'' +
				", tel='" + tel + '\'' +
				", email='" + email + '\'' +
				", lastWork='" + lastWork + '\'' +
				", salary='" + salary + '\'' +
				", departmentId=" + departmentId +
				", workPositionId=" + workPositionId +
				", master='" + master + '\'' +
				", workBackground='" + workBackground + '\'' +
				", hobbies='" + hobbies + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
