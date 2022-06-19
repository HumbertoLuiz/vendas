package io.github.humbertoluiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredenciaisDTO {	
	
    private String username;
    
    private String password;
    
}