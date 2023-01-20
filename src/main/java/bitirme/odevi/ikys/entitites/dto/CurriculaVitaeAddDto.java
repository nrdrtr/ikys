package bitirme.odevi.ikys.entitites.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculaVitaeAddDto {

    private int id;
    private int isArayanId;
    private String resimUrl;
    private String ozgecmis = "";
}

