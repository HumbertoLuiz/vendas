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
//@Table(name = "tab_user")
//public class User {
//	
//	@EqualsAndHashCode.Include
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//	
//    @Column(length = 50, nullable = false)
//    private String name;
//    
//    @Column(length = 20, nullable = false)
//    private String username;
//    
//    @Column(length = 100, nullable = false)
//    private String password;
//    
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "tb_user_roles", joinColumns = { @JoinColumn(name = "user_id") })
//    private List<String> roles = new ArrayList<>();
//
//    
//    @Builder
//	public User(String name, String username, String password) {
//		super();
//		this.name = name;
//		this.username = username;
//		this.password = password;
//	}
//
//
//    
//}
