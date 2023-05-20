package bitirme.odevi.ikys.entitites.concretes;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_vitaes")
public class CurriculumVitae {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "cover_letter")
    private String coverLetter;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    @OneToOne(mappedBy = "curriculumVitae", cascade = CascadeType.DETACH)
    private SocialMedia socialMedia;

    @OneToMany(mappedBy = "curriculumVitae", cascade = CascadeType.DETACH)
    private List<Education> educations;

    @OneToMany(mappedBy = "curriculumVitae", cascade = CascadeType.DETACH)
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "curriculumVitae", cascade = CascadeType.DETACH)
    private List<JobseekerLanguages> jobseekerLanguages;

    @OneToMany(mappedBy = "curriculumVitae", cascade = CascadeType.DETACH)
    private List<Technology> technologies;
}
