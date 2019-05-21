package edu.sjsu.ieptracker.mapper;

import edu.sjsu.ieptracker.dto.GuardianDto;
import edu.sjsu.ieptracker.entity.Guardian;
import edu.sjsu.ieptracker.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuardianMapper {
    @Autowired
    StudentMapper studentMapper;
    public GuardianDto mapToDto(Guardian guardian) {

        GuardianDto guardianDto = new GuardianDto();
        guardianDto.setAddress(guardian.getAddress());
        guardianDto.setGuardianName(guardian.getGuardianName());
        guardianDto.setContactNo(guardian.getContactNo());
        guardianDto.setRelation(guardian.getRelation());
        guardianDto.setPrimaryContact(guardian.getPrimaryContact());
        guardianDto.setStudentID(guardian.getStudent().getStudentID());
        return guardianDto;

    }

    public Guardian mapToGuardian(GuardianDto guardiandto) {
        Guardian guardian = new Guardian();
        guardian.setAddress(guardiandto.getAddress());
        guardian.setGuardianName(guardiandto.getGuardianName());
        guardian.setContactNo(guardiandto.getContactNo());
        guardian.setRelation(guardiandto.getRelation());
        guardian.setPrimaryContact(guardiandto.getPrimaryContact());

        return guardian;


    }
}
