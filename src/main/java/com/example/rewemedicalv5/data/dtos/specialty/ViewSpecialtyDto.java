package com.example.rewemedicalv5.data.dtos.specialty;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NonNull;

public record ViewSpecialtyDto(
        @NonNull
        String name
) {

}
