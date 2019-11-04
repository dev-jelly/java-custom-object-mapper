package kr.jellyms.custommapper.model;

import lombok.Data;

@Data
public class Todo {

    private Long id;

    private String title;
    private String description;

    private Boolean done;
}
