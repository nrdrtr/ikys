package bitirme.odevi.ikys.bussiness.abstracts;

import bitirme.odevi.ikys.core.utilities.results.DataResult;
import bitirme.odevi.ikys.entitites.concretes.Language;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getDiller();
    DataResult<List<Language>> add(List<Language> diller);
}
