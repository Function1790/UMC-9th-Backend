package com.plane.umc9th.domain.member.entity;

import com.plane.umc9th.domain.catergory.entity.FoodCatergory;
import com.plane.umc9th.domain.member.enums.Gender;
import com.plane.umc9th.domain.member.enums.Provider;
import com.plane.umc9th.domain.member.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@Getter
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign Keys
    @OneToOne
    @JoinColumn(name = "settingId")
    private MemberSetting setting;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FoodCatergoryLikes> foodCatergoryLikes;

    // Term

    // Columns
    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Provider provider;

    @Column
    private int point;

    @Column
    private String phoneNumber;

    @Column
    private boolean is_verified;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime inactive_date;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
}
