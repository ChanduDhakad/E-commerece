package com.shop.model;

import javax.validation.constraints.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FeedbackDTO {

    @NotNull(message = "Product rating is required")
    @Min(value = 1, message = "Product rating must be at least 1")
    @Max(value = 5, message = "Product rating must not exceed 5")
    private Integer productRating;

    @NotNull(message = "Service rating is required")
    @Min(value = 1, message = "Service rating must be at least 1")
    @Max(value = 5, message = "Service rating must not exceed 5")
    private Integer serviceRating;

    @NotNull(message = "Overall rating is required")
    @Min(value = 1, message = "Overall rating must be at least 1")
    @Max(value = 5, message = "Overall rating must not exceed 5")
    private Integer overallRating;

    @NotBlank(message = "Message is required")
    private String message;
}
