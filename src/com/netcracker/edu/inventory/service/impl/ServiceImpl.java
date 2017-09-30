package com.netcracker.edu.inventory.service.impl;


import com.netcracker.edu.inventory.model.Device;
import com.netcracker.edu.inventory.service.Service;

public class ServiceImpl implements Service {
    @Override
    public void sortByIN(Device[] devices) {
        for (int i = devices.length-1; i >= 0 ; i--){
            for (int j = 0; j < i ; j++){
                if(devices[j] == null){     // sort devices that are null
                    Device temp = devices[j];
                    devices[j] = devices[j+1];
                    devices[j+1] = temp;
                }
            }
        }
        // sort devices that have in(0), at place in front of null devices
        for (int i = devices.length-1; i >= 0 ; i--){
            for (int j = 0; j < i ; j++){
                if(devices[j] != null && devices[j].getIn() == 0 && devices[j+1] == null){
                    Device temp = devices[j];
                    devices[j] = devices[j+1];
                    devices[j+1] = temp;
                }
            }
        }
        for (int i = devices.length-1; i >= 0 ; i--){
            for (int j = 0; j < i ; j++){
                if (devices[j] != null && devices[j+1] != null && devices[j].getIn() != 0 &&
                        devices[j+1].getIn() != 0 && devices[j].getIn() > devices[j+1].getIn()) {
                    Device temp = devices[j];
                    devices[j] = devices[j+1];
                    devices[j+1] = temp;
                }
            }
        }

    }

    @Override
    public void filtrateByType(Device[] devices, String type) {
        for (Device device : devices){
            if(device != null) {
                if (!device.getType().equals(type)){
                    device = null;
                }
            }
        }
    }
}
