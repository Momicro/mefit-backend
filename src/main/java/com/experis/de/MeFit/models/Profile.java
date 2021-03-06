package com.experis.de.MeFit.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Profile")
@Schema(description = "Profile Model")
public @Data class Profile {

    //autogenerated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Here the static components of the model
    private Integer age;
    private Integer weight;
    private Integer height;
    private Integer fitnessLevel;
    private Integer trainingFrequency;
    private Boolean contributorRequest;

    @Lob
    private byte[] picture;

    @OneToOne(mappedBy = "profile")
    private User user;

    @OneToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    @JsonGetter("user")
    public String userGetter() {
        if (user != null)
            return "/api/v1/users/" + user.getId();
        else
            return null;
    }

    /*
    @JsonGetter("goal")
    public String goalGetter() {
        if (goal != null)
            return "/api/v1/goals/" + goal.getId();
        else
            return null;
    }
    */
}
