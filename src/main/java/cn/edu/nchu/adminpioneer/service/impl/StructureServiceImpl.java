package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Structure;
import cn.edu.nchu.adminpioneer.mapper.StructureMapper;
import cn.edu.nchu.adminpioneer.service.StructureService;
import cn.edu.nchu.adminpioneer.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StructureServiceImpl implements StructureService {

    @Autowired
    private StructureMapper structureMapper;

    @Override
    public Structure getStructure() {
        return structureMapper.getStructure();
    }

    @Override
    public int updateStructure(Structure structure) {
        structure.setTime(new TimeUtils().getNowTime());
        return structureMapper.updateStructure(structure);
    }

    @Override
    public int addStructure(Structure structure) {
        structure.setTime(new TimeUtils().getNowTime());
        return structureMapper.addStructure(structure);
    }
}
