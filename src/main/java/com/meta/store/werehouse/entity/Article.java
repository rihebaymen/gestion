package com.meta.store.werehouse.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meta.store.base.Entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="article_werehouse")
public class Article extends BaseEntity<Long> {

	
	@NotBlank(message = "Libelle Field Must Not Be Empty")
	private String libelle;
	
	@NotBlank(message = "Code Field Must Not Be Empty")
	private String code;

	private String unit;
	
	private String discription;
	
	@Positive(message = "Cost Field Must Be A Positive Number")
	private Double cost;

	@Positive(message = "Quantity Field Must Be A Positive Number")
	private Double quantity;
	
	private Double minQuantity;
	
	private Double maxQuantity;
	
	@Positive(message = "Selling_Price Field Must Be A Positive Number")
	private Double sellingPrice;
	
	private String barcode;
	
//	@NotNull(message = "يهديك مش فارغ")it's accept "" but @NotEmpty can't accept it and @NotBlank dosn't accept "" or null
//	private String name;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "sousCategoryId")
	private SousCategory sousCategory;
	
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;

	public Article(@NotBlank(message = "Libelle field must not be empty") String libelle,
			@NotBlank(message = "Code Field Must not Be Empty") String code, String ref, String discription) {
		super();
		this.libelle = libelle;
		this.code = code;
		this.unit = ref;
		this.discription = discription;
	}
	
	
	

}
 






