package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.SchoolService;
import bitirme.odevi.ikys.bussiness.response.School.GetAllResponseSchools;
import bitirme.odevi.ikys.core.utilities.mapper.ModelMapperService;
import bitirme.odevi.ikys.dataAccess.abstracts.SchoolDao;
import bitirme.odevi.ikys.entitites.concretes.School;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;
    private ModelMapperService modelMapperService;

    @Override
    public  List<GetAllResponseSchools> getAll() {

        List<School> schools = schoolDao.findAll();

        return schools.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetAllResponseSchools.class))
                .collect(Collectors.toList());

     }
}