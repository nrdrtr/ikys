package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.ImageService;
import bitirme.odevi.ikys.bussiness.abstracts.UserService;
import bitirme.odevi.ikys.core.services.CloudStorageService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.dataAccess.abstracts.ResimDao;
import bitirme.odevi.ikys.entitites.concretes.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ImageManager implements ImageService {

    private CloudStorageService cloudStorageService;
    private ResimDao resimDao;
    private UserService userService;

    @Override
    public Result add(Image image) {
        resimDao.save(image);
        return new SuccessResult("Resim eklendi.");
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<>(resimDao.findAll(), "Resimler listelendi.");
    }


    @Override
    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<Image>(resimDao.getById(id), "Resim getirildi.");
    }

    @Override
    public DataResult<Image> getByUserId(int userId) {
        return new SuccessDataResult<Image>(resimDao.getByUserId(userId));
    }

    @Override
    public Result update(Image image) {
        resimDao.save(image);
        return new SuccessResult("Resim güncellendi.");
    }

    @Override
    public Result delete(int id) {

//        Image image = getById(id).getData();
//        String[] splitImageUrlArray = image.getImageUrl().split("/");
//        int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf(".");
//        String publicIdOfImage = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension);
 //        cloudStorageService.delete(publicIdOfImage);
        this.resimDao.deleteById(id);
        return new SuccessResult("Resim silindi.");
    }


    @Override
    public Result upload(int userId, MultipartFile file) {

        Map<?, ?> uploadImage = (Map<?, ?>) cloudStorageService.upload(file).getData();

        Image image = new Image();
        image.setUser(userService.getById(userId).getData());
        image.setImageUrl(uploadImage.get("url").toString());

        return add(image);
    }


}
