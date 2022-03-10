package com.frexdel.api;

import com.frexdel.api.dao.AppointmentRepository;
import com.frexdel.api.dao.PatientRepository;
import com.frexdel.api.entities.Appointment;
import com.frexdel.api.entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PatientRepository patientRepository, AppointmentRepository appointmentRepository){
        return args -> {

            for (int i = 0; i < 5; i++) {
                patientRepository.save(new Patient(null,"youness",new Date(),false,new ArrayList<Appointment>()));
            }
            for (int i = 0; i < 5; i++) {
                Patient p = patientRepository.getById(i+1l);
            }
        };
    }

}
