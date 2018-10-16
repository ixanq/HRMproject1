package com.ixanq.entity;
//������
public class Resume {
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private String politicalStatus;//������ò
	private String tel;//�ֻ�
	private String email;
	private String lastWork;//��һ�ݹ���
	private String salary;//��������	private Integer age;
	private Integer departmentId;
	private Integer workPositionId;
	private String master;//ѧ��
	private String workBackground;//��������
	private String hobbies;//��Ȥ����

	public Resume() {
	}

	public Resume(String name, String gender, Integer age, String politicalStatus, String tel, String email, String lastWork, String salary, Integer departmentId, Integer workPositionId, String master, String workBackground, String hobbies) {

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
	}

	public Resume(Integer id, String name, String gender, Integer age, String politicalStatus, String tel, String email, String lastWork, String salary, Integer departmentId, Integer workPositionId, String master, String workBackground, String hobbies) {

		this.id = id;
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

	@Override
	public String toString() {
		return "Resume{" +
				"id=" + id +
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
				'}';
	}
}
