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
        // sort devices descendingly by in
        for (int i = devices.length-1; i >= 0 ; i--){
            for (int j = 0; j < i ; j++){
                if ( devices[j+1] != null && devices[j].getIn() < devices[j+1].getIn()) {
                    Device temp = devices[j];
                    devices[j] = devices[j+1];
                    devices[j+1] = temp;
                }
            }
        }
        //sort devices ascending without devices with in(0)
        for (int i = devices.length-1; i >= 0 ; i--){
            for (int j = 0; j < i ; j++){
                if ( devices[j+1] != null && devices[j+1].getIn() != 0
                        && devices[j].getIn() > devices[j+1].getIn()) {
                    Device temp = devices[j];
                    devices[j] = devices[j+1];
                    devices[j+1] = temp;
                }
            }
        }

    }

    @Override
    public void filtrateByType(Device[] devices, String type) {
        for (int i = 0; i < devices.length; i++){
            if(devices[i] != null){
                if(!devices[i].getType().equals(type))
                    devices[i] = null;
            }
        }
    }
}
