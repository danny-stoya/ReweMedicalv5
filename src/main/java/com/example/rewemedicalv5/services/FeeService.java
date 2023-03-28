package com.example.rewemedicalv5.services;

import com.example.rewemedicalv5.data.entities.Fee;
import com.example.rewemedicalv5.data.repositories.FeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class FeeService {
    private static final BigDecimal DEFAULT_FEE_2023 = BigDecimal.valueOf(80.00);
    private static final BigDecimal INSURANCE_COVER = BigDecimal.valueOf(0);
    private final FeeRepository feeRepository;

    @PostConstruct
    private void init() {
        if (feeRepository.count() > 0) {
            return;
        }

        feeRepository.save(new Fee(INSURANCE_COVER));
        feeRepository.save(new Fee(DEFAULT_FEE_2023));
    }

    public void addFee(BigDecimal newValue) {
        var fee = feeRepository.findById(2L).get();
        fee.setValue(newValue);
        feeRepository.save(fee);
    }

    public Fee getDefaultFee() {
        return feeRepository
                .findById(2L)
                .orElse(new Fee(DEFAULT_FEE_2023));
    }

    public Fee geInsuranceCover() {
        return feeRepository
                .findById(1L)
                .orElse(new Fee(INSURANCE_COVER));
    }

    private BigDecimal format(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_EVEN);
    }

}
