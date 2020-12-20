package by.example.myteam.dao;

import by.example.myteam.entity.ExtraInfo;

public interface ExtraInfoDAO {

    void deleteExtraInfoById(long id);

    void saveExtraInfo(ExtraInfo extraInfo);

    ExtraInfo getExtraInfo(int id);
}
