package bitirme.odevi.ikys.bussiness.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerJobAdvertisementsRequest {


    @NotNull
    private int employerId;


    @NotNull(message = "Pozisyon alanı boş bırakılmamalı!")
    private int jobPositionId;

    @NotNull
    private int cityId;

    @NotNull
    private int salary;

    @NotNull
    private int numberOfOpenPositions;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Yayın tarihini boş bırakamazsınız")
    private LocalDate releaseDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Deadline tarihini boş bırakamazsınız")
    private LocalDate endDate;


    @Size(min = 10)
    private String explanation;


    private boolean active;

    private String workTime;
    @NotNull
    private String workType;


}
