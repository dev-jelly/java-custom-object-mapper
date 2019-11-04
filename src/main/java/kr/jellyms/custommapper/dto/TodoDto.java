package kr.jellyms.custommapper.dto;

import lombok.Data;

public class TodoDto {


    @Data
    public static class Create {
        private String title;
        private String description;

        private boolean done;
    }

}