package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.bussiness.response.School.GetAllResponseSchools;

import java.util.List;

public interface SchoolService {
    List<GetAllResponseSchools> getAll();
}
