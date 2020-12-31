package by.example.team_board.dao;

import by.example.team_board.entity.ExtraInfo;

public interface ExtraInfoDAO {

    void deleteExtraInfoById(long id);

    void saveExtraInfo(ExtraInfo extraInfo);

    ExtraInfo getExtraInfo(int id);
}
