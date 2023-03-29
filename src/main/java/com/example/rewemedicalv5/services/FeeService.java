package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.dtos.fee.NewFeeDto;
import com.example.rewemedicalv5.data.dtos.fee.UpdateFeeDto;
import com.example.rewemedicalv5.data.entities.Fee;
import com.example.rewemedicalv5.data.repositories.FeeRepository;
import com.example.rewemedicalv5.exceptions.FeeNotFound;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class FeeService {
    private final FeeRepository feeRepository;

    public Fee getFeeByDate(LocalDate forDate) {
        return feeRepository.findByDateBetween(forDate);
    }

    public Fee getInsuranceCover() {
        return feeRepository.getInsuranceCover();
    }

    public void addFee(NewFeeDto dto) {
        feeRepository.save(
                new Fee(dto.value(),
                        dto.startDate(),
                        dto.endDate(),
                        false)
        );
    }


    public BigDecimal format(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_EVEN);
    }

    public List<Fee> getAll() {
        return feeRepository.findAll();
    }

    public void editFee(Long id, @Valid UpdateFeeDto dto) {
        var fee = feeRepository.findById(id)
                .orElseThrow(() -> new FeeNotFound(id));

        fee.setValue(dto.value());
        feeRepository.save(fee);
    }
}
