package com.example.rewemedicalv5.web;

import com.example.rewemedicalv5.data.dtos.insurance.NewInsuranceDto;
import com.example.rewemedicalv5.data.dtos.patient.NewPatientDto;
import com.example.rewemedicalv5.data.dtos.patient.EditPatientDto;
import com.example.rewemedicalv5.data.dtos.patient.ViewPatientDto;
import com.example.rewemedicalv5.exceptions.validations.PatientExist;
import com.example.rewemedicalv5.services.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.INVALID_UID_LENGTH;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
@Validated
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<ViewPatientDto>> getAll() {
        var patients = patientService.getAll();

        if (patients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{uid}")
    public ResponseEntity<ViewPatientDto> findViewByUid(
            @PathVariable
            @Size(min = 3, max = 3, message = INVALID_UID_LENGTH)
            @PatientExist String uid
    ) {
        return ResponseEntity.ok(patientService.findViewByUid(uid));
    }

    @PostMapping("/add")
    public ResponseEntity<ViewPatientDto> create(
            @RequestBody
            @Valid NewPatientDto dto,

            UriComponentsBuilder uriComponentsBuilder
    ) {

        patientService.create(dto);

        return ResponseEntity
                .created(uriComponentsBuilder
                        .path("/api/patients")
                        .path("/{uid}")
                        .build(dto.uid())
                )
                .build();
    }

    @PutMapping("/{uid}/insurance")
    public ResponseEntity<ViewPatientDto> addInsurance(
            @PathVariable
            @Size(min = 3, max = 3, message = INVALID_UID_LENGTH)
            @PatientExist String uid,

            @RequestBody
            @Valid
            NewInsuranceDto dto
    ) {
        return ResponseEntity.ok(patientService.addInsurance(uid, dto));
    }

    @DeleteMapping("/{uid}/insurance/{id}")
    public ResponseEntity<ViewPatientDto> deleteInsurance(
            @PathVariable
            @Size(min = 3, message = INVALID_UID_LENGTH)
            @PatientExist String uid,

            @PathVariable
            @NotNull
            @Positive
            Long id
    ) {
        patientService.deleteInsurance(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{uid}/edit")
    public ResponseEntity<ViewPatientDto> update(
            @PathVariable
            @Size(min = 3, message = INVALID_UID_LENGTH)
            @PatientExist String uid,

            @RequestBody
            @Valid
            EditPatientDto dto
    ) {
        return ResponseEntity.ok(patientService.update(uid, dto));
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<ViewPatientDto> deleteByName(
            @PathVariable
            @Size(min = 3, message = INVALID_UID_LENGTH)
            @PatientExist String uid
    ) {
        patientService.delete(uid);
        return ResponseEntity.noContent().build();
    }
}
