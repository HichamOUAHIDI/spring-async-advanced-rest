package com.hou.spring.mapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "Class representing a Employee tracked by the application.")
public class EmployeeDTO {
	/**
	 * @NotNull and @Positive annotations to specify the minimum length and
	 *  also a message when a validation error occurs
	 * */
	@ApiModelProperty(notes = "Unique identifier of the employee. No two employee can have the same id.", example = "1", required = true, position = 0)
	private Long id;
	@ApiModelProperty(notes = "First name of the Employee.", example = "Hicham", required = true, position = 1)
	@NotNull(message = "First name must not be empty")
	private String firstName;
	@ApiModelProperty(notes = "Last name of the Employee.", example = "Ouahidi", required = true, position = 2)
	@NotNull(message = "Last name must not be empty")
	private String lastName;
	@ApiModelProperty(notes = "salry of the employee. Non-negative integer", example = "3000", position = 3)
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
