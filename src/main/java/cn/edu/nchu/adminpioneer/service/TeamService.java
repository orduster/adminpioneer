package cn.edu.nchu.adminpioneer.service;

import cn.edu.nchu.adminpioneer.entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> showTeam(int pageSize, int pageNumber);

    int countArticle();

    int deleteById(int id);

    int deleteByIds(String ids);

    int addTeam(Team team);

    Team getTeamById(int id);

    int updateTeam(Team team);

}
