package com.tg.cmd.patient.mapper;

import com.tg.cmd.patient.dto.patient.AddressDTO;
import com.tg.cmd.patient.dto.patient.FamilyMemberDTO;
import com.tg.cmd.patient.dto.patient.PatientDTO;
import com.tg.cmd.patient.model.Address;
import com.tg.cmd.patient.model.FamilyMember;
import com.tg.cmd.patient.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    // Map Patient to PatientDTO
    @Mapping(source = "address", target = "addressDTO")  // Map the embedded Address to AddressDTO
    @Mapping(source = "familyMember", target = "familyMemberDTO")  // Map the embedded FamilyMember to FamilyMemberDTO
    PatientDTO toPatientDTO(Patient patient);

    // Map PatientDTO to Patient
    @Mapping(source = "addressDTO", target = "address")  // Map AddressDTO to Address
    @Mapping(source = "familyMemberDTO", target = "familyMember")  // Map FamilyMemberDTO to FamilyMember
    Patient toPatient(PatientDTO patientDTO);

    // Map FamilyMember to FamilyMemberDTO
    FamilyMemberDTO toFamilyMemberDTO(FamilyMember familyMember);

    // Map FamilyMemberDTO to FamilyMember
    FamilyMember toFamilyMember(FamilyMemberDTO familyMemberDTO);

    // Map Address to AddressDTO
    AddressDTO toAddressDTO(Address address);

    // Map AddressDTO to Address
    Address toAddress(AddressDTO addressDTO);

    // Map List<Address> to List<AddressDTO>
    List<AddressDTO> toAddressDTOList(List<Address> addresses);

    // Map List<AddressDTO> to List<Address>
    List<Address> toAddressList(List<AddressDTO> addressDTOs);

    // Map List<FamilyMember> to List<FamilyMemberDTO>
    List<FamilyMemberDTO> toFamilyMemberDTOList(List<FamilyMember> familyMembers);

    // Map List<FamilyMemberDTO> to List<FamilyMember>
    List<FamilyMember> toFamilyMemberList(List<FamilyMemberDTO> familyMemberDTOs);
}
