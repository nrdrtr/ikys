package bitirme.odevi.ikys.entitites.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employers", uniqueConstraints = {@UniqueConstraint(columnNames = {"company_name"})})
@AllArgsConstructor
@NoArgsConstructor(force = true)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User {

    @Column(name = "company_name")
    @NotNull
    private String  companyName;

    @Column(name = "website")
    @NotNull
    private String website;

    @Column(name = "phone_number")
    @NotNull
    private String  phoneNumber;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "is_current")
    private boolean isCurrent = false;



    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisement;



}