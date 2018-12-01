package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Structure;

public interface StructureService {
    Structure getStructure();

    int updateStructure(Structure structure);

    int addStructure(Structure structure);
}
