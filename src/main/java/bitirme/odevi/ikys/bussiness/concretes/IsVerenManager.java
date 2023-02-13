package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsVerenService;
import bitirme.odevi.ikys.dataAccess.abstracts.IsVerenDao;
import bitirme.odevi.ikys.entitites.concretes.IsVeren;
import bitirme.odevi.ikys.entitites.dto.IsverenWithIsIlanıDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsVerenManager implements IsVerenService {

    private IsVerenDao isVerenDao;

    @Autowired
    public IsVerenManager(IsVerenDao isVerenDao) {
        this.isVerenDao = isVerenDao;
    }

    @Override
    public List<IsVeren> isVeren() {
        return this.isVerenDao.findAll();
    }

    @Override
    public void save(IsVeren isVeren) {

        this.isVerenDao.save(isVeren);

    }

    @Override
    public List<IsverenWithIsIlanıDto> getIsverenWithIsIlanıDetails() {
        return this.isVerenDao.getIsverenWithIsIlanıDetails();
    }


//    @Override
//    public DataResult addPicture(MultipartFile multipartFile) throws IOException {
//        Map options = new HashMap<>();
//        var allowedFormats = Arrays.asList("png", "jpg", "jpeg");
//        options.put("allowed_formats", allowedFormats);
//        File file = convertToFile(multipartFile);
//        Map uploader = null;
//        try {
//            uploader = cloudinary.uploader().upload(file, options);
//        } catch (Exception e) {
//            return new ErrorDataResult<>(e.getMessage());
//        }
//        return new SuccessDataResult<>(uploader);
//    }
}
