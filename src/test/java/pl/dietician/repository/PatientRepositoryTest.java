package pl.dietician.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dietician.model.Patient;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    PatientRepository patientRepository;


    @Before
    public void setUp(){
        //given
        Patient p1=new Patient();
        p1.setPesel("72040855632");
        p1.setName("Tom");
        p1.setLastName("Jones");
        entityManager.persist(p1);

        Patient p2=new Patient();
        p2.setPesel("77081345113");
        p2.setName("Will");
        p2.setLastName("Smith");
        entityManager.persist(p2);

    }

    @Test
    public void findByPesel() {

        //given
        String expectedLastName="Jones";

        //when
        Patient result=patientRepository.findByPesel("72040855632");

        //then
        assertEquals(expectedLastName, result.getLastName());
        assertEquals("72040855632", result.getPesel());


    }

    @Test
    public void findAllByPeselContaining() {
        //given
        String peselFragment1="7";
        String peselFragment2="77";
        String peselFragment3="720408";
        String peselFragment4="880101";

        //when
        List<Patient> result1=patientRepository.findAllByPeselContaining(peselFragment1);
        List<Patient> result2=patientRepository.findAllByPeselContaining(peselFragment2);
        List<Patient> result3=patientRepository.findAllByPeselContaining(peselFragment3);
        List<Patient> result4=patientRepository.findAllByPeselContaining(peselFragment4);

        //then
        assertEquals(2, result1.size());
        assertEquals(1, result2.size());
        assertEquals(1, result3.size());
        assert (result4.isEmpty() || result4==null);
    }

    @Test
    public void findAllByLastName() {
        //given
        String lastName="Smith";

        //then
        List<Patient> result=patientRepository.findAllByLastName(lastName);

        //then
        assert(result.size()==1);
        assertEquals("Will",result.get(0).getName());
    }
}