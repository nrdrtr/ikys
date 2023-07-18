package bitirme.odevi.ikys.entitites.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_vitaes")
@JsonIgnoreType
public class CurriculumVitae {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "cover_letter")

    private String coverLetter;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;


//    @OneToMany(mappedBy = "curriculumVitae", fetch = FetchType.LAZY)
//    private List<CoverLetter> coverLetters;


    @OneToMany(mappedBy = "curriculumVitae", fetch = FetchType.EAGER)
    private List<JobSeekerSocialMedia> jobSeekerSocialMedia;


    @OneToMany(mappedBy = "curriculumVitae", fetch = FetchType.EAGER)
    private List<Education> educations;


    @OneToMany(mappedBy = "curriculumVitae", fetch = FetchType.EAGER)
    private List<JobExperience> jobExperiences;


    @OneToMany(mappedBy = "curriculumVitae", fetch = FetchType.EAGER)
    private List<JobseekerLanguages> jobseekerLanguages;


    @OneToMany(mappedBy = "curriculumVitae", fetch = FetchType.EAGER)
    private List<Skill> skills;
}
