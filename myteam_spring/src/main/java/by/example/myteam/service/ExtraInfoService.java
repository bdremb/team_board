package by.example.myteam.service;

import by.example.myteam.entity.ExtraInfo;
import by.example.myteam.entity.Person;

public interface ExtraInfoService {

    void deleteExtraInfoById(long id);

    boolean saveExtraInfo(ExtraInfo extraInfo);

    ExtraInfo getExtraInfo(int id);


}
