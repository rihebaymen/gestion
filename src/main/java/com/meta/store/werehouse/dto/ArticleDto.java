package com.meta.store.werehouse.dto;

import java.io.Serializable;

import com.meta.store.base.Entity.BaseDto;
import com.meta.store.werehouse.entity.Category;
import com.meta.store.werehouse.entity.Company;
import com.meta.store.werehouse.entity.SousCategory;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto extends BaseDto<Long>  implements Serializable{
	
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

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "sousCategoryId")
	private SousCategory sousCategory;
	
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;


	
	
	
}
