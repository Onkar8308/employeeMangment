package com.example.demo.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

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
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentid;

	@NonNull
	@NotBlank(message = "please enter department name")
	@Column(length = 50)
	private String departmentname;
	@NonNull
	@NotEmpty(message = " department location can not be empty")
	@NotBlank(message = " department location can not be blank")
	@Column(length = 50)
	private String departmentlocation;

	@NonNull
	@OneToMany(mappedBy = "dept")
	Set<Employee> employee = new HashSet<Employee>();
	
	
}
