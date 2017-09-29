package com.netcracker.edu.inventory.model.impl;


import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.model.Rack;

public class RackArrayImpl implements Rack {
    protected Device[] devices;

    public RackArrayImpl(int size){
        if(size > 0){
            devices = new Device[size];
        }else {
            System.err.println("Value of size isn't ");
        }
    }

    @Override
    public int getSize() {
        return devices.length;
    }

    @Override
    public int getFreeSize() {
        int count = 0;
        for (Device device : devices)
            if(device == null)
                count++;

        return count;
    }

    @Override
    public Device getDevAtSlot(int index) {
        if(devices[index] != null && index >= 0 && index < devices.length){
            return devices[index];
        }
        return null;
    }

    @Override
    public boolean insertDevToSlot(Device device, int index) {
        if( index >= 0 && index < devices.length && devices[index] == null && device.getIn() > 0 ){
            devices[index] = device;
            return true;

        }
        return false;
    }

    @Override
    public Device removeDevFromSlot(int index) {
        if(devices[index] != null && index >= 0 && index < devices.length){
            Device buff = devices[index];
            devices[index] = null;
            return buff;
        }
        return null;
    }

    @Override
    public Device getDevByIN(int in) {
        for (Device device : devices)
            if (device.getIn() == in && device != null)
                return device;

        return null;
    }
}