package com.myproject.model;

public class Course {
	private Integer id;
	private String name;
	private double credits;
	private Integer departmentId;

	public Course(Integer id, String name, double credits, Integer departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.credits = credits;
		this.departmentId = departmentId;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
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

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credits=" + credits + ", departmentId=" + departmentId + "]";
	}

}
