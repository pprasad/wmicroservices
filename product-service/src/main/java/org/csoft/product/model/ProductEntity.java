package org.csoft.product.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {
   @SequenceGenerator(sequenceName = "PROD_SEQ", name = "PROD_SEQ", initialValue = 1, allocationSize = 1)
   @GeneratedValue(generator = "PROD_SEQ", strategy = GenerationType.SEQUENCE)
   @Id
   @Column( name = "PROD_ID")
   private int id;
   
   @Column(name = "PROD_NAME")
   private String name;
   
   @Column(name = "PRICE")
   private float price;
   
   @Column(name = "COUPEN_CODE")
   private String coupenCode;
   
   @Embedded
   private LocationEntity location;

}
