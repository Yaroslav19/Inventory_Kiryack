package com.netcracker.edu.inventory.model.impl;

import com.netcracker.edu.inventory.model.Device;

import java.util.Date;

public abstract class AbstractDevice implements Device {
    protected int in;
    protected String type;
    protected String manufacturer;
    protected String model;
    protected Date productionDate;

    @Override
    public int getIn() {
        return this.in;
    }

    @Override
    public void setIn(int in) {
        if(this.in == 0 && in > 0){
            this.in = in;
        }else {
            System.err.println("Current value of IN isn't zero!");
        }
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getProductionDate() {
        return this.productionDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
