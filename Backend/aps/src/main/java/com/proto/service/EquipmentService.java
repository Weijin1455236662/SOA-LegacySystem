package com.proto.service;

import com.proto.pojo.Equipment;

import java.util.List;

public interface EquipmentService {
    public boolean save(Equipment equipment);

    public boolean deleteById(Integer id);

    public boolean update(Equipment equipment);

    public Equipment findById(Integer oid);

    public List<Equipment> findAll();

    public boolean importEquipmentData();

}
