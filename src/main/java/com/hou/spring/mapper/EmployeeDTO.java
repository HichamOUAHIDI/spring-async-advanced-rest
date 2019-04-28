package com.hou.spring.mapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class EmployeeDTO {
	/**
	 * @NotNull and @Positive annotations to specify the minimum length and
	 *  also a message when a validation error occurs
	 * */
	private Long id;
	
	@NotNull(message = "First name must not be empty")
	private String firstName;

	@NotNull(message = "Last name must not be empty")
	private String lastName;
	
	@Positive(message = "Salary must be positive")
	private Long salary;

	@Email(message="email must be valid")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}