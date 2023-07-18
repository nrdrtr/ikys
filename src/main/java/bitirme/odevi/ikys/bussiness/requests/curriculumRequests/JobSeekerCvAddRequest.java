package bitirme.odevi.ikys.bussiness.requests.curriculumRequests;


import bitirme.odevi.ikys.entitites.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCvAddRequest {


    private int id;

    private String coverLetter;

    private String imageUrl;

    private int jobSeekerId;

    private SocialMedia socialMedia;

    private List<Education> educations;

    private List<JobExperience> jobExperiences;

    private List<JobseekerLanguages> jobseekerLanguages;

    private List<Technology> technologies;
}
