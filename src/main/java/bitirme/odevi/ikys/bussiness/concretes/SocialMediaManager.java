package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.SocialMediaService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.SuccessDataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.SocialMediaDao;
import bitirme.odevi.ikys.entitites.concretes.SocialMedia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SocialMediaManager implements SocialMediaService {


    private SocialMediaDao socialMediaDao;

    @Override
    public DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(int id) {
        return null;
    }

    @Override
    public SocialMedia addSocialMedia(SocialMedia socialMedia) {
        return this.socialMediaDao.save(socialMedia);
    }

    @Override
    public DataResult<List<SocialMedia>> getAll() {
        this.socialMediaDao.findAll();
        return  new SuccessDataResult<List<SocialMedia>>(this.socialMediaDao.findAll(),"Sosyal medya hesapları listelendi");
    }
}
