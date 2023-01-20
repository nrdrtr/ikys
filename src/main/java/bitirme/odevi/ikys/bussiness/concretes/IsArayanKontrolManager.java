package bitirme.odevi.ikys.bussiness.concretes;

import bitirme.odevi.ikys.bussiness.abstracts.IsArayanKontrol;
import bitirme.odevi.ikys.core.utilities.results.ErrorResult;
import bitirme.odevi.ikys.core.utilities.results.Result;
import bitirme.odevi.ikys.core.utilities.results.SuccessResult;
import bitirme.odevi.ikys.entitites.concretes.IsArayan;
import org.springframework.stereotype.Service;

@Service
public class IsArayanKontrolManager implements IsArayanKontrol {

    @Override
    public boolean isItEmpty(IsArayan isArayan) {

        
            return true;
        }


    }
 
