package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.entitites.concretes.SosyalMedya;

public interface SosyalMedyaService {

//    Result addSocialMedia(SocialMediaAddDto socialMedia);
//
//    Result updateSocialMedia(SocialMediaUpdateDto socialMedia);

    DataResult<SosyalMedya> getSocialMediaByCurriculaVitaeId(int id);

}
