package by.example.team_board.service;

import by.example.team_board.entity.ExtraInfo;

public interface ExtraInfoService {

    void deleteExtraInfoById(long id);

    boolean saveExtraInfo(ExtraInfo extraInfo);

    ExtraInfo getExtraInfo(int id);


}
