package com.example.demo.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;

import org.apache.logging.log4j.message.Message;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 50)
	private Integer employeeid;
	@NonNull
	@NotBlank(message = "Employee name should not be balank")
	private String name;

	@NonNull
	@Min(value = 18, message = "employee age should be above 18")
	@Max(value = 65, message = "employee age should be below 65")
	private Integer employeeage;

	@NonNull
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "please enter valid email address")
	private String employeeemail;

	@NonNull
	@NotBlank(message = "employee date of birth should not be blank")
	@NotEmpty(message = "not empty")
	//@Pattern(regexp = "MM/dd/yyyy", message = "Invalid date format. The expected format is yyyy-MM-dd")
	@Past(message = "employee birth date should be present date or past dates")
	private Date employeDob;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId", referencedColumnName = "departmentid")
	Department dept;

	public void employeeAssignDepartment(Department dept2) {
		// TODO Auto-generated method stub
		this.dept = dept2;
	}

}
