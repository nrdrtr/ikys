package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsVerenService;
import bitirme.odevi.ikys.bussiness.rules.UserBussinessRules;
import bitirme.odevi.ikys.core.services.CloudinaryService;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.IsVerenDao;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class IsVerenManager implements IsVerenService {

    private IsVerenDao isVerenDao;
    private CloudinaryService cloudinaryService;

    private UserBussinessRules userBussinessRules;


    @Override
    public List<IsVeren> isVeren() {
        return this.isVerenDao.findAll();
    }

    @Override
    public void save(IsVeren isVeren) {
        this.userBussinessRules.employerRegistrationCheck(isVeren);
        this.userBussinessRules.isEmailExist(isVeren.getEPosta());
        this.isVerenDao.save(isVeren);

    }

    @Override
    public List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails() {
        return this.isVerenDao.getIsverenWithIsIlanıDetails();
    }

    @Override
    public Result uploadPicture(int isverenId, MultipartFile file) throws IOException {
        var result = this.cloudinaryService.addPicture(file);
        var url = result.getData().get("url");

        IsVeren ref = this.isVerenDao.getOne(isverenId);
        ref.setResimUrl(url.toString());
        this.isVerenDao.save(ref);

        return new SuccessResult("Success: Resim ekleme işlemi başarılı!");
    }


}
