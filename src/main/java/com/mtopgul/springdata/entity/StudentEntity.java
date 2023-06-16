package com.mtopgul.springdata.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.security.SecureRandom;
import java.time.Year;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author muhammed-topgul
 * @since 16/06/2023 07:49
 */
@Entity
@Table(name = "t_student")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentEntity implements Serializable {
    @Transient
    private static AtomicInteger counter = new AtomicInteger(100);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "enrollment_id", nullable = false, unique = true)
    private String enrollmentId;

    public StudentEntity(String name) {
        this.name = name;
        this.enrollmentId = newEnrollmentId();
    }

    private String newEnrollmentId() {
        SecureRandom secureRandom = new SecureRandom();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder generatedString = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomSequence = secureRandom.nextInt(chars.length());
            generatedString.append(chars.charAt(randomSequence));
        }
        return Year.now().getValue() + generatedString.toString() + counter.incrementAndGet();
    }
}
