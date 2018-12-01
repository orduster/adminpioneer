package cn.edu.nchu.adminpioneer.service.impl;

import cn.edu.nchu.adminpioneer.entity.Team;
import cn.edu.nchu.adminpioneer.mapper.TeamMapper;
import cn.edu.nchu.adminpioneer.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Team> showTeam(int pageSize, int pageNumber) {
        return teamMapper.showTeam(pageSize, pageNumber);
    }

    @Override
    public int countArticle() {
        return teamMapper.countTeam();
    }

    @Override
    public int deleteById(int id) {
        return teamMapper.deleteById(id);
    }

    @Override
    public int deleteByIds(String ids) {
        return teamMapper.deleteByIds(ids);
    }

    @Override
    public int addTeam(Team team) {
        return teamMapper.addTeam(team);
    }

    @Override
    public Team getTeamById(int id) {
        return teamMapper.getTeamById(id);
    }

    @Override
    public int updateTeam(Team team) {
        return teamMapper.updateTeam(team);
    }

}
