package com.example.rewemedicalv5.web;

import com.example.rewemedicalv5.data.dtos.visit.NewVisitDto;
import com.example.rewemedicalv5.data.dtos.visit.ViewVisitDto;
import com.example.rewemedicalv5.services.VisitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import static com.example.rewemedicalv5.exceptions.FailedValidationMessage.INVALID_ID;


@RestController
@RequestMapping("/api/visits")
@AllArgsConstructor
@Validated
public class VisitController {
    private final VisitService visitService;

    @GetMapping("/all")
    public ResponseEntity<List<ViewVisitDto>> getAll() {
        var visits = visitService.getAll();

        if (visits.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(visits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViewVisitDto> findById(
            @PathVariable
            @NotNull
            @Positive(message = INVALID_ID)
            Long id
    ) {
        return ResponseEntity.ok(visitService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ViewVisitDto> create(
            @RequestBody
            @Valid NewVisitDto dto,
            UriComponentsBuilder uriComponentsBuilder

    ) throws URISyntaxException {

        var id = visitService.create(dto);

        return ResponseEntity
                .created(uriComponentsBuilder
                        .path("/api/visits")
                        .path("/{id}")
                        .build(id)
                )
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ViewVisitDto> delete(
            @PathVariable
            @NotNull
            @Positive(message = INVALID_ID)
            Long id
    ) {
        visitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
