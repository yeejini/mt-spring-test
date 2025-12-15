package com.mungtrainer.mtserver.trainer.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TrainerResponse {
    private Long trainerId;
    private String careerInfo;
    private String introduce;
    private String description;
    private String style;
    private String tag;
    private String certificationImageUrl;
}