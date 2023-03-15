package bitirme.odevi.ikys.core.adapters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bitirme.odevi.ikys.core.services.CloudStorageService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.ErrorDataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


@Service
@AllArgsConstructor
public class CloudStorageServiceAdapter implements CloudStorageService {

    private Cloudinary cloudinary;

    @Override
    public DataResult<?> upload(MultipartFile multipartFile) {

        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<>(uploadResult);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>();
        }
    }

    @Override
    public DataResult<?> delete(String publicIdOfImage) {

        List<String> publicIdsOfImages = new ArrayList<String>();
        publicIdsOfImages.add(publicIdOfImage);

        try {
            Map<?, ?> deleteResult = cloudinary.api().deleteResources(publicIdsOfImages, ObjectUtils.emptyMap());
            return new SuccessDataResult<>(deleteResult);
        } catch (Throwable e) {
            e.printStackTrace();
            return new ErrorDataResult<>();
        }
    }

}