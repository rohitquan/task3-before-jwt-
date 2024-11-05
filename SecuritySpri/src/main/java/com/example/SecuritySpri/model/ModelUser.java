package com.example.SecuritySpri.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ModelUser {
    private Long id;
    private String username;
    private String password;
}
