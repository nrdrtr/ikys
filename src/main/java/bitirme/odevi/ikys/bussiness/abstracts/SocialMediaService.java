package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.SocialMedia;

import java.util.List;

public interface SocialMediaService {

//    Result addSocialMedia(SocialMediaAddDto socialMedia);
//
//    Result updateSocialMedia(SocialMediaUpdateDto socialMedia);

    DataResult<SocialMedia> getSocialMediaByCurriculaVitaeId(int id);
    SocialMedia addSocialMedia(SocialMedia socialMedia);
    DataResult<List<SocialMedia>> getAll();
}
