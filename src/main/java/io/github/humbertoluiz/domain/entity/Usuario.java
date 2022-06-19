//package io.github.humbertoluiz.domain.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CollectionTable;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//
//import lombok.Builder;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//
//@Builder
//@NoArgsConstructor
//@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@Entity
//public class Usuario {
//	
//	@EqualsAndHashCode.Include
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//	@NotBlank(message = "{campo.username.obrigatorio}")
//    @Column(length = 20, nullable = false)
//    private String username;
//    
//	@NotBlank(message = "{campo.password.obrigatorio}")
//    @Column(length = 100, nullable = false)
//    private String password;
//    
//    @Column
//    private boolean admin;
//    
//    @Builder
//	public Usuario(String username, String password) {
//		this.username = username;
//		this.password = password;
//	}
//
//
//    
//}
