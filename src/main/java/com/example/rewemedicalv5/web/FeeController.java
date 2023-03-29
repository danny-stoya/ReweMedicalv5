package com.example.rewemedicalv5.web;

import com.example.rewemedicalv5.data.dtos.fee.NewFeeDto;
import com.example.rewemedicalv5.data.dtos.fee.UpdateFeeDto;
import com.example.rewemedicalv5.data.entities.Fee;
import com.example.rewemedicalv5.services.FeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fees")
@Validated
public class FeeController {
    private final FeeService feeService;

    @GetMapping("/all")
    public ResponseEntity<List<Fee>> getAll() {
        return ResponseEntity.ok(feeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Fee> addFee(
           @Valid NewFeeDto dto
    ) {
        feeService.addFee(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Fee> edit(
            @PathVariable Long id,
            @Valid UpdateFeeDto dto
    ) {
        feeService.editFee(id, dto);
        return ResponseEntity.ok().build();
    }
}
