package digital.InnovationOne.personapi.dto.mapper;

import digital.InnovationOne.personapi.dto.request.PersonDTO;
import digital.InnovationOne.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {


    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);

}
