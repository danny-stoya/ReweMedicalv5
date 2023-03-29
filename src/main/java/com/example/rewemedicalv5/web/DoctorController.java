package com.example.rewemedicalv5.web;

import com.example.rewemedicalv5.data.dtos.doctor.NewDoctorDto;
import com.example.rewemedicalv5.data.dtos.doctor.EditDoctorDto;
import com.example.rewemedicalv5.data.dtos.doctor.ViewDoctorDto;
import com.example.rewemedicalv5.exceptions.validations.DoctorExist;
import com.example.rewemedicalv5.services.DoctorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.INVALID_UID;

@RestController
@RequestMapping("/api/doctors")
@AllArgsConstructor
@Validated
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping("/all")
    public ResponseEntity<List<ViewDoctorDto>> getAll() {
        var doctors = doctorService.getAll();

        if (doctors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(doctors);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<ViewDoctorDto> findViewByUid(
            @PathVariable
            @Size(min = 3, max = 3, message = INVALID_UID)
            @DoctorExist String uid
    ) {
        return ResponseEntity.ok(doctorService.findViewByUid(uid));
    }

    @PostMapping("/add")
    public ResponseEntity<ViewDoctorDto> create(
            @RequestBody
            @Valid NewDoctorDto dto,

            UriComponentsBuilder uriComponentsBuilder
    ) {

        doctorService.create(dto);

        return ResponseEntity
                .created(uriComponentsBuilder
                        .path("/api/doctors")
                        .path("/{uid}")
                        .build(dto.uid())
                )
                .build();
    }

    @PutMapping("/{uid}/edit")
    public ResponseEntity<ViewDoctorDto> update(
            @PathVariable
            @NotBlank(message = INVALID_UID)
            @DoctorExist String uid,

            @RequestBody
            @Valid
            EditDoctorDto dto
    ) {
        return ResponseEntity.ok(doctorService.update(uid, dto));
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<ViewDoctorDto> deleteByName(
            @PathVariable

            @DoctorExist String uid
    ) {
        doctorService.delete(uid);
        return ResponseEntity.noContent().build();
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ViewDoctorDto> deleteById(
//            @PathVariable
//            Positive
//            Long id
//    ) {
//        doctorService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
}
