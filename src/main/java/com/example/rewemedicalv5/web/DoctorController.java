package com.example.rewemedicalv5.web;

import com.example.rewemedicalv5.data.dtos.doctor.NewDoctorDto;
import com.example.rewemedicalv5.data.dtos.doctor.EditDoctorDto;
import com.example.rewemedicalv5.data.dtos.doctor.ViewDoctorDto;
import com.example.rewemedicalv5.services.DoctorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static com.example.rewemedicalv5.exceptions.InvalidValidationMessage.INVALID_UID;

@RestController
@RequestMapping("/api/doctors")
@AllArgsConstructor
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

//    @GetMapping("/{id}")
//    public ResponseEntity<ViewDoctorDto> findById(
//            @PathVariable
//            @Positive(message = "Invalid ID")
//            Long id
//    ) {
//        return ResponseEntity.ok(doctorService.findById(id));
//    }

    @GetMapping("/{uid}")
    public ResponseEntity<ViewDoctorDto> findViewByUid(
            @PathVariable
            @NotBlank(message = INVALID_UID)
            String uid
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
            String uid,

            @RequestBody
            @Valid
            EditDoctorDto dto
    ) {
        return ResponseEntity.ok(doctorService.update(uid, dto));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ViewDoctorDto> delete(
//            @PathVariable
//            @Positive
//            Long id
//    ) {
//        doctorService.delete(id);
//        return ResponseEntity.noContent().build();
//    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<ViewDoctorDto> deleteByName(
            @PathVariable
            @NotBlank
            String uid
    ) {
        doctorService.delete(uid);
        return ResponseEntity.noContent().build();
    }
}
