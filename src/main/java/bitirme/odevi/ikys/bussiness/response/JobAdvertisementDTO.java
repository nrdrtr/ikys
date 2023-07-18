package bitirme.odevi.ikys.bussiness.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDTO {//isarayanın basvurduğu ilanlar response
    private int applicationId;
    private int advertisementId;
    private String explanation;
    private int salary;
    private int numberOfOpenPositions;
    private LocalDate endDate;
    private String status;
    private String workTime;
    private String workType;
    private boolean active;
    private String employerName;
    private String jobPositionTitle;
    private String cityName;
}
