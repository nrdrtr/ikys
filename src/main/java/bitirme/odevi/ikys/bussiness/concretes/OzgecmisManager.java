package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.OzgecmisService;
import bitirme.odevi.ikys.core.utilities.results.*;
import bitirme.odevi.ikys.dataAccess.abstracts.OzgecmisDao;
import bitirme.odevi.ikys.entitites.concretes.Ozgecmis;
import bitirme.odevi.ikys.entitites.dto.OzgecmisAddDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@AllArgsConstructor
public class OzgecmisManager implements OzgecmisService {


    private final OzgecmisDao ozgecmisDao;

    @Override
    public Result addOzgecmis(OzgecmisAddDto ozgecmis) {
//        if (ozgecmis.getResimUrl().equals("")) {
//            ozgecmis.setResimUrl().equals("https://res.cloudinary.com/torukobyte/image/upload/v1623515256/customer_rca6tq.png");
//            this.ozgecmisDao.save((Ozgecmis) this.dtoConverterService.dtoClassConverter(
//                    ozgecmis,
//                    Ozgecmis.class));
//            return new SuccessResult("Success: Cv başarıyla eklendi!");
//        } else {
//            this.ozgecmisDao.save((Ozgecmis) this.dtoConverterService.dtoClassConverter(
//                    ozgecmis,
//                    Ozgecmis.class));
//            return new SuccessResult("Success: Cv başarıyla eklendi!");
//        }
        return null;
    }

    @Override
    public Result updateOzgecmis(OzgecmisAddDto ozgecmis) {
//        if (ozgecmis.getResimUrl().equals("")) {
//            ozgecmis.setResimUrl(
//                    "https://res.cloudinary.com/torukobyte/image/upload/v1623515256/customer_rca6tq.png");
//            this.ozgecmisDao.save((Ozgecmis) this.dtoConverterService.dtoClassConverter(
//                    curriculaVitae,
//                    CurriculaVitae.class));
//            return new SuccessResult("Success: Cv başarıyla güncellendi!");
//        } else {
//            this.ozgecmisDao.save((Ozgecmis) this.dtoConverterService.dtoClassConverter(
//                    ozgecmis,
//                    Ozgecmis.class));
//            return new SuccessResult("Success: Cv başarıyla güncellendi!");
//        }
        return null;
    }

    @Override
    public DataResult<Ozgecmis> findByJobSeekerId(int jobseekerId) {
        if (this.ozgecmisDao.findByIsArayanId(jobseekerId) == null) {
            return new ErrorDataResult<>("Warning: Kayıtlı Cv bulunamadı!");
        } else {
            return new SuccessDataResult<>(
                    this.ozgecmisDao.findByIsArayanId(jobseekerId),
                    "Success: Cv'ler başarıyla listelendi!");
        }
    }

    @Override
    public Result uploadPicture(int cvId, MultipartFile file) throws IOException {
//        var result = this.cloudinaryService.addPicture(file);
//        var url = result.getData().get("url");
//
//        Ozgecmis ref = this.ozgecmisDao.getOne(cvId);
//        ref.setResimUrl(url.toString());
//        this.ozgecmisDao.save(ref);
//
        return new SuccessResult("Success: Resim ekleme işlemi başarılı!");
    }


}
