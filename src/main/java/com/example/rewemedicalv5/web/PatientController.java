package com.example.rewemedicalv5.web;

import com.example.rewemedicalv5.data.dtos.patient.AddPatientInsuranceDto;
import com.example.rewemedicalv5.data.dtos.patient.NewPatientDto;
import com.example.rewemedicalv5.data.dtos.patient.UpdatePatientDto;
import com.example.rewemedicalv5.data.dtos.patient.ViewPatientDto;
import com.example.rewemedicalv5.services.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static com.example.rewemedicalv5.exceptions.InvalidValidationMessage.INVALID_UID;

@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
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

//    @GetMapping("/{id}")
//    public ResponseEntity<ViewPatientDto> findById(
//            @PathVariable
//            @Positive(message = "Invalid ID")
//            Long id
//    ) {
//        return ResponseEntity.ok(patientService.findById(id));
//    }

    @GetMapping("/{uid}")
    public ResponseEntity<ViewPatientDto> findViewByUid(
            @PathVariable
            @NotBlank(message = INVALID_UID)
            String uid
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

    @PostMapping("/{uid}/add-insurance")
    public ResponseEntity<ViewPatientDto> addInsurance(
            @PathVariable
            @NotBlank(message = INVALID_UID)
            String uid,

            @RequestBody
            @Valid
            AddPatientInsuranceDto dto
    ) {
        return ResponseEntity.ok(patientService.addInsurance(uid, dto));
    }

    @PutMapping("/{uid}/edit")
    public ResponseEntity<ViewPatientDto> update(
            @PathVariable
            @NotBlank(message = INVALID_UID)
            String uid,

            @RequestBody
            @Valid
            UpdatePatientDto dto
    ) {
        return ResponseEntity.ok(patientService.update(uid, dto));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ViewPatientDto> delete(
//            @PathVariable
//            @Positive
//            Long id
//    ) {
//        patientService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<ViewPatientDto> deleteByName(
            @PathVariable
            @NotBlank(message = INVALID_UID)
            String uid
    ) {
        patientService.delete(uid);
        return ResponseEntity.noContent().build();
    }
}
