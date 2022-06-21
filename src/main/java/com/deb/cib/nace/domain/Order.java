package com.deb.cib.nace.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="NACE_ORDER")
public class Order {
    @Id
    @Column(name="ORDER_ID")
    private Integer orderId;

    @Column(name="ORDER_LEVEL")
    private int level;

    private String code;
    private String parent;
    private String description;
    @Column(name="ITEM_INCLUDES")
    private String itemIncludes;
    @Column(name="ADD_ITEM_INCLUDES")
    private String addItemIncludes;
    @Column(name="ITEM_EXCLUDES")
    private String itemExcludes;
    @Column(name="REFERENCE_ISIC")
    private String reference;

}
