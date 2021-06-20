package digital.InnovationOne.personapi.mapper;

import digital.InnovationOne.personapi.dto.mapper.PersonMapper;
import digital.InnovationOne.personapi.dto.request.PersonDTO;
import digital.InnovationOne.personapi.dto.request.PhoneDTO;
import digital.InnovationOne.personapi.entity.Person;
import digital.InnovationOne.personapi.entity.Phone;
import digital.InnovationOne.personapi.enums.PhoneType;
import digital.InnovationOne.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

public class PersonMapperTest {
    @Autowired
    private PersonMapper personMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = personMapper.toModel(personDTO);

        assertEquals(personDTO.getFirstname(), person.getFirstName());
        assertEquals(personDTO.getLastName(), person.getLastName());
        assertEquals(personDTO.getCpf(), person.getCpf());

        Phone phone = person.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    private void assertEquals(String firstname, String firstName) {
    }


    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Person person = PersonUtils.createFakeEntity();
        PersonDTO personDTO = personMapper.toDTO(person);

        assertEquals(person.getFirstName(), personDTO.getFirstname());
        assertEquals(person.getLastName(), personDTO.getLastName());
        assertEquals(person.getCpf(), personDTO.getCpf());

        Phone phone = person.getPhones().get(0);
        PhoneDTO phoneDTO = personDTO.getPhones().get(0);

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }

    private void assertEquals(PhoneType type, PhoneType type1) {
    }
}
