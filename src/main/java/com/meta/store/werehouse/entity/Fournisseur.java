package com.meta.store.werehouse.entity;

import com.meta.store.base.Entity.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fournisseur_werehouse")
public class Fournisseur extends BaseEntity<Long> {

	private String name;
	
	private String code;
	
	private String nature;
	
	private Double credit;
	
	private Double mvt;
	
	private String phone;
	
	private String address;
	
	@Email
	private String email;
}