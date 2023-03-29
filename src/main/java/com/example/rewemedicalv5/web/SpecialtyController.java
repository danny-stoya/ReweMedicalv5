package com.example.rewemedicalv5.web;

import com.example.rewemedicalv5.data.dtos.diagnosis.ViewDiagnosisDto;
import com.example.rewemedicalv5.data.dtos.specialty.EditSpecialtyDto;
import com.example.rewemedicalv5.data.dtos.specialty.NewSpecialtyDto;
import com.example.rewemedicalv5.data.dtos.specialty.ViewSpecialtyDto;
import com.example.rewemedicalv5.exceptions.validations.SpecialtyExists;
import com.example.rewemedicalv5.services.SpecialtyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.INVALID_SPECIALTY_NAME;
import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.INVALID_SPECIALTY_NAME_LENGTH;

@RestController
@RequestMapping("/api/specialties")
@AllArgsConstructor
@Validated
public class SpecialtyController {
    private final SpecialtyService specialtyService;

    @GetMapping("/all")
    public ResponseEntity<List<ViewSpecialtyDto>> getAll() {
        var specialties = specialtyService.getAll();

        if (specialties.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(specialties);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ViewSpecialtyDto> findById(
//            @PathVariable
//            @Positive(message = "Invalid ID")
//            Long id
//    ) {
//        return ResponseEntity.ok(specialtyService.findById(id));
//    }

    @GetMapping("/{name}")
    public ResponseEntity<ViewSpecialtyDto> getSpecialtyViewByName(
            @PathVariable
            @Size(min = 3, message = INVALID_SPECIALTY_NAME_LENGTH)
            @SpecialtyExists
            String name
    ) {
        return ResponseEntity.ok(
                specialtyService.getViewByName(name)
        );
    }

    @PostMapping("/add")
    public ResponseEntity<ViewSpecialtyDto> create(
            @RequestBody
            @Valid NewSpecialtyDto dto,

            UriComponentsBuilder uriComponentsBuilder
    ) {

        specialtyService.create(dto);

        return ResponseEntity
                .created(uriComponentsBuilder
                        .path("/api/specialties")
                        .path("/{name}")
                        .build(dto.name())
                )
                .build();
    }

    @PutMapping("/{name}/edit")
    public ResponseEntity<ViewSpecialtyDto> update(
            @PathVariable
            @Size(min = 3, message = INVALID_SPECIALTY_NAME)
            @SpecialtyExists
            String name,

            @RequestBody
            @Valid
            EditSpecialtyDto dto
    ) {
        return ResponseEntity.ok(
                specialtyService.update(name, dto)
        );
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ViewDiagnosisDto> delete(
//            @PathVariable
//            @Positive
//            Long id
//    ) {
//        specialtyService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{name}")
    public ResponseEntity<ViewDiagnosisDto> deleteByName(
            @PathVariable
            @NotBlank(message = INVALID_SPECIALTY_NAME)
            String name
    ) {
        specialtyService.delete(name);
        return ResponseEntity.noContent().build();
    }
}
