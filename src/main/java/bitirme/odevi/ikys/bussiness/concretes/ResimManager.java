package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.UserService;
import bitirme.odevi.ikys.bussiness.abstracts.ResimService;
import bitirme.odevi.ikys.core.services.CloudStorageService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.ResimDao;
import bitirme.odevi.ikys.entitites.concretes.Resim;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ResimManager implements ResimService {

    private CloudStorageService cloudStorageService;
    private ResimDao resimDao;
    private UserService userService;

    @Override
    public Result add(Resim resim) {
        resimDao.save(resim);
        return new SuccessResult("Resim eklendi.");
    }

    @Override
    public DataResult<List<Resim>> getAll() {
        return new SuccessDataResult<>(resimDao.findAll(), "Resimler listelendi.");
    }


    @Override
    public DataResult<Resim> getById(int id) {
        return new SuccessDataResult<Resim>(resimDao.getById(id), "Resim getirildi.");
    }

    @Override
    public DataResult<Resim> getByUserId(int userId) {
        return new SuccessDataResult<Resim>(resimDao.getByUserId(userId));
    }

    @Override
    public Result update(Resim resim) {
        resimDao.save(resim);
        return new SuccessResult("Resim güncellendi.");
    }

    @Override
    public Result delete(int id) {

        Resim resim = getById(id).getData();

        String[] splitImageUrlArray = resim.getUrl().split("/");
        int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf(".");
        String publicIdOfImage = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension);

        cloudStorageService.delete(publicIdOfImage);
        resimDao.deleteById(id);
        return new SuccessResult("Resim silindi.");
    }


    @Override
    public Result upload(int userId, MultipartFile file) {

        Map<?, ?> uploadImage = (Map<?, ?>) cloudStorageService.upload(file).getData();

        Resim image = new Resim();
        image.setUser(userService.getById(userId).getData());
        image.setUrl(uploadImage.get("url").toString());

        return add(image);
    }


}
