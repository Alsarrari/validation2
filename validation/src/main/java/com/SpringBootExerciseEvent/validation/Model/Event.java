package com.SpringBootExerciseEvent.validation.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Event {
    @NotNull
    @Size(min = 3)
    private String id;
    @NotNull
    @Size(min = 15)
    private String description;
    @NotNull
    @Size(min = 25)
    private int capcity;
    @NotNull
    @JsonFormat(pattern = "2025-02-22")
    private LocalDate startDate;
    @NotNull
    @JsonFormat(pattern = "2026-05-10")
    private LocalDate endDate;
}
