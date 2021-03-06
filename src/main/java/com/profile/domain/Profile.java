package com.profile.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Profile.
 */
@Entity
@Table(name = "profile")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "profile")
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @NotNull
    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "active")
    private Boolean active;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_content_type")
    private String imageContentType;

    @Lob
    @Column(name = "video_1")
    private byte[] video1;

    @Column(name = "video_1_content_type")
    private String video1ContentType;

    @Lob
    @Column(name = "video_2")
    private byte[] video2;

    @Column(name = "video_2_content_type")
    private String video2ContentType;

    @Column(name = "background_checked")
    private Boolean backgroundChecked;

    @NotNull
    @Column(name = "created", nullable = false)
    private Instant created;

    @NotNull
    @Column(name = "updated", nullable = false)
    private Instant updated;

    @OneToOne
    @JoinColumn(unique = true)
    private Location location;

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Education> educations = new HashSet<>();

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Experience> experiences = new HashSet<>();

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Review> reviews = new HashSet<>();

    @OneToMany(mappedBy = "profile")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Award> awards = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "profile_subject",
               joinColumns = @JoinColumn(name="profiles_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="subjects_id", referencedColumnName="id"))
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "profile_language",
               joinColumns = @JoinColumn(name="profiles_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="languages_id", referencedColumnName="id"))
    private Set<Language> languages = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "profile_level",
               joinColumns = @JoinColumn(name="profiles_id", referencedColumnName="id"),
               inverseJoinColumns = @JoinColumn(name="levels_id", referencedColumnName="id"))
    private Set<Level> levels = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public Profile userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public Profile description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isActive() {
        return active;
    }

    public Profile active(Boolean active) {
        this.active = active;
        return this;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public byte[] getImage() {
        return image;
    }

    public Profile image(byte[] image) {
        this.image = image;
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public Profile imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public byte[] getVideo1() {
        return video1;
    }

    public Profile video1(byte[] video1) {
        this.video1 = video1;
        return this;
    }

    public void setVideo1(byte[] video1) {
        this.video1 = video1;
    }

    public String getVideo1ContentType() {
        return video1ContentType;
    }

    public Profile video1ContentType(String video1ContentType) {
        this.video1ContentType = video1ContentType;
        return this;
    }

    public void setVideo1ContentType(String video1ContentType) {
        this.video1ContentType = video1ContentType;
    }

    public byte[] getVideo2() {
        return video2;
    }

    public Profile video2(byte[] video2) {
        this.video2 = video2;
        return this;
    }

    public void setVideo2(byte[] video2) {
        this.video2 = video2;
    }

    public String getVideo2ContentType() {
        return video2ContentType;
    }

    public Profile video2ContentType(String video2ContentType) {
        this.video2ContentType = video2ContentType;
        return this;
    }

    public void setVideo2ContentType(String video2ContentType) {
        this.video2ContentType = video2ContentType;
    }

    public Boolean isBackgroundChecked() {
        return backgroundChecked;
    }

    public Profile backgroundChecked(Boolean backgroundChecked) {
        this.backgroundChecked = backgroundChecked;
        return this;
    }

    public void setBackgroundChecked(Boolean backgroundChecked) {
        this.backgroundChecked = backgroundChecked;
    }

    public Instant getCreated() {
        return created;
    }

    public Profile created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getUpdated() {
        return updated;
    }

    public Profile updated(Instant updated) {
        this.updated = updated;
        return this;
    }

    public void setUpdated(Instant updated) {
        this.updated = updated;
    }

    public Location getLocation() {
        return location;
    }

    public Profile location(Location location) {
        this.location = location;
        return this;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Education> getEducations() {
        return educations;
    }

    public Profile educations(Set<Education> educations) {
        this.educations = educations;
        return this;
    }

    public Profile addEducation(Education education) {
        this.educations.add(education);
        education.setProfile(this);
        return this;
    }

    public Profile removeEducation(Education education) {
        this.educations.remove(education);
        education.setProfile(null);
        return this;
    }

    public void setEducations(Set<Education> educations) {
        this.educations = educations;
    }

    public Set<Experience> getExperiences() {
        return experiences;
    }

    public Profile experiences(Set<Experience> experiences) {
        this.experiences = experiences;
        return this;
    }

    public Profile addExperience(Experience experience) {
        this.experiences.add(experience);
        experience.setProfile(this);
        return this;
    }

    public Profile removeExperience(Experience experience) {
        this.experiences.remove(experience);
        experience.setProfile(null);
        return this;
    }

    public void setExperiences(Set<Experience> experiences) {
        this.experiences = experiences;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public Profile reviews(Set<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Profile addReview(Review review) {
        this.reviews.add(review);
        review.setProfile(this);
        return this;
    }

    public Profile removeReview(Review review) {
        this.reviews.remove(review);
        review.setProfile(null);
        return this;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Award> getAwards() {
        return awards;
    }

    public Profile awards(Set<Award> awards) {
        this.awards = awards;
        return this;
    }

    public Profile addAward(Award award) {
        this.awards.add(award);
        award.setProfile(this);
        return this;
    }

    public Profile removeAward(Award award) {
        this.awards.remove(award);
        award.setProfile(null);
        return this;
    }

    public void setAwards(Set<Award> awards) {
        this.awards = awards;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public Profile subjects(Set<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }

    public Profile addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getProfiles().add(this);
        return this;
    }

    public Profile removeSubject(Subject subject) {
        this.subjects.remove(subject);
        subject.getProfiles().remove(this);
        return this;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public Profile languages(Set<Language> languages) {
        this.languages = languages;
        return this;
    }

    public Profile addLanguage(Language language) {
        this.languages.add(language);
        language.getProfiles().add(this);
        return this;
    }

    public Profile removeLanguage(Language language) {
        this.languages.remove(language);
        language.getProfiles().remove(this);
        return this;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<Level> getLevels() {
        return levels;
    }

    public Profile levels(Set<Level> levels) {
        this.levels = levels;
        return this;
    }

    public Profile addLevel(Level level) {
        this.levels.add(level);
        level.getProfiles().add(this);
        return this;
    }

    public Profile removeLevel(Level level) {
        this.levels.remove(level);
        level.getProfiles().remove(this);
        return this;
    }

    public void setLevels(Set<Level> levels) {
        this.levels = levels;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        if (profile.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), profile.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Profile{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", description='" + getDescription() + "'" +
            ", active='" + isActive() + "'" +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + imageContentType + "'" +
            ", video1='" + getVideo1() + "'" +
            ", video1ContentType='" + video1ContentType + "'" +
            ", video2='" + getVideo2() + "'" +
            ", video2ContentType='" + video2ContentType + "'" +
            ", backgroundChecked='" + isBackgroundChecked() + "'" +
            ", created='" + getCreated() + "'" +
            ", updated='" + getUpdated() + "'" +
            "}";
    }
}
