//package pl.dietician.service.implementation;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//import pl.dietician.error.PatientNotFoundException;
//import pl.dietician.model.Patient;
//import pl.dietician.repository.PatientRepository;
//import pl.dietician.repository.RoleRepository;
//import pl.dietician.service.PatientService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//public class PatientServiceImplTest {
//
//    @TestConfiguration
//    static class PatientServiceImplTestConfig{
//        @Bean
//        public PatientService patientService(){
//            return new PatientServiceImpl();
//        }
//    }
//
//    @Autowired
//    PatientService patientService;
//
//    @MockBean
//    PatientRepository patientRepository;
//
//    @MockBean
//    RoleRepository roleRepository;
//
//
//    @Before
//    public void setUp(){
//        Patient p1=new Patient();
//        p1.setPesel("72040855632");
//        p1.setName("Tom");
//        p1.setLastName("Jones");
//
//        Patient p2=new Patient();
//        p2.setPesel("77081345113");
//        p2.setName("Will");
//        p2.setLastName("Smith");
//
//        List<Patient> withP1=new ArrayList<>();
//        withP1.add(p1);
//
//        List<Patient> withP2=new ArrayList<>();
//        withP1.add(p2);
//
//        List<Patient> all=new ArrayList<>();
//        all.add(p1);
//        all.add(p2);
//
//        Mockito.when(patientRepository.findByPesel("72040855632")).thenReturn(p1);
//        Mockito.when(patientRepository.findByPesel("77081345113")).thenReturn(p2);
//        Mockito.when(patientRepository.findAllByPeselContaining("7")).thenReturn(all);
//        Mockito.when(patientRepository.findAllByPeselContaining("77")).thenReturn(withP2);
//        Mockito.when(patientRepository.findByPesel("72040855632")).thenReturn(null);
//
//    }
//
//    @Test
//    public void when_searching_by_pesel_should_return_patient(){
//
//        //when
//        Patient patient=patientService.findByPesel("72040855632");
//
//        //then
//        assertEquals("72040855632", patient.getPesel());
//        assertEquals("Tom", patient.getName());
//        assertEquals("Jones", patient.getLastName());
//    }
//
//    @Test (expected = PatientNotFoundException.class)
//    public void shouldReturnPatientNotFoundExceptionWhenSearchByPesel() {
//        //when
//        Patient patient=patientService.findByPesel("72040855000");
//
//    }
//
//    @Test
//    public void findAllByPeselContaining() {
//
//        //when
//        List<Patient> list1=patientService.findAllByPeselContaining("7");
//        List<Patient> list2=patientService.findAllByPeselContaining("77");
//
//        //then
//        assertEquals (2, list1.size());
//        assertEquals(1, list2.size());
//    }
//
//    @Test
//    public void findAllByLastName() {
//    }
//
//    @Test
//    public void findById() {
//    }
//}