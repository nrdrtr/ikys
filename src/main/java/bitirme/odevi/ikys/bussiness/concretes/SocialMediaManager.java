package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.SocialMediaService;
import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.dataAccess.abstracts.SocialMediaDao;
import bitirme.odevi.ikys.entitites.concretes.SocialMedia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SocialMediaManager implements SocialMediaService {

    private SocialMediaDao socialMediaDao;
    @Override
    public DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(int id) {
        return null;
    }
}
