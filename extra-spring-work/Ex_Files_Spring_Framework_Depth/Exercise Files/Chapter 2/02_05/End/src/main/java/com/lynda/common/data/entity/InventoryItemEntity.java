package com.lynda.common.data.entity;

import java.math.BigDecimal;

public class InventoryItemEntity {
    private String itemId;
    private String name;
    private BigDecimal cost;
    private BigDecimal price;
    private String sku;
    private long qoh;
    private long trigger;
    private int caseSize;
    private String supplier;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public long getQoh() {
        return qoh;
    }

    public void setQoh(long qoh) {
        this.qoh = qoh;
    }

    public long getTrigger() {
        return trigger;
    }

    public void setTrigger(long trigger) {
        this.trigger = trigger;
    }

    public int getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(int caseSize) {
        this.caseSize = caseSize;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
