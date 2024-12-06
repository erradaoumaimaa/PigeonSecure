package com.oumaima.pigeonSecure.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oumaima.pigeonSecure.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "pigeons")
public class Pigeon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numberBague;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    private int age;

    private String color;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    public void setUser(User user) {
        this.user = user;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
