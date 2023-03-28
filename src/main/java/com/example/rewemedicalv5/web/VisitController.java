package com.example.rewemedicalv5.web;

import com.example.rewemedicalv5.data.dtos.doctor.ViewDoctorDto;
import com.example.rewemedicalv5.data.dtos.visit.NewVisitDto;
import com.example.rewemedicalv5.data.dtos.visit.VisitViewDto;
import com.example.rewemedicalv5.services.VisitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
@AllArgsConstructor
public class VisitController {
    private final VisitService visitService;

    @GetMapping("/all")
    public ResponseEntity<List<VisitViewDto>> getAll() {
        var visits = visitService.getAll();

        if (visits.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(visits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitViewDto> findById(
            @PathVariable
            @Positive(message = "Invalid ID")
            Long id
    ) {
        return ResponseEntity.ok(visitService.findById(id));
    }

//    @GetMapping()
//    public ResponseEntity<VisitViewDto> findByDate(
//            @RequestParam
//            @NotBlank(message = "Invalid UPIN")
//            LocalDate date
//    ) {
//        return ResponseEntity.ok(doctorService.findByUpin(udin));
//    }

    @PostMapping("/add")
    public ResponseEntity<VisitViewDto> create(
            @RequestBody
            @Valid NewVisitDto dto,

            UriComponentsBuilder uriComponentsBuilder
    ) {

        Long id = visitService.create(dto);

        return ResponseEntity
                .created(uriComponentsBuilder
                        .path("/api/visits")
                        .path("/{id}")
                        .build(id)
                )
                .build();
    }

//    @PutMapping("/{id}/update")
//    public ResponseEntity<ViewDoctorDto> update(
//            @PathVariable
//            @Positive(message = "Invalid ID")
//            Long id,
//
//            @RequestBody
//            @Valid
//            UpdateDoctorDto dto
//    ) {
//        return ResponseEntity.ok(visitService.update(udin, dto));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ViewDoctorDto> delete(
            @PathVariable
            @Positive
            Long id
    ) {
        visitService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @DeleteMapping
//    public ResponseEntity<ViewDoctorDto> deleteByName(
//            @RequestParam
//            @NotBlank
//            String udin
//    ) {
//        doctorService.delete(udin);
//        return ResponseEntity.noContent().build();
//    }
}
