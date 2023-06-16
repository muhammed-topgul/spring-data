package com.mtopgul.springdata.bootstrap;

import com.mtopgul.springdata.entity.StudentEntity;
import com.mtopgul.springdata.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author muhammed-topgul
 * @since 16/06/2023 08:36
 */
@Component
@RequiredArgsConstructor
public class BootstrapData implements ApplicationRunner {
    private final StudentRepository studentRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            StudentEntity studentEntity = new StudentEntity("User-" + i);
            studentRepository.save(studentEntity);
        }
    }
}
