package com.example.StudentDatabase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Registration")
@Inheritance(strategy = InheritanceType.JOINED)
//@MappedSuperclass
public class User {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private int  userid;
	private String username;
	private String password;
	}
