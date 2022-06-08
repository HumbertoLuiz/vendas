<<<<<<< HEAD
//package io.github.humbertoluiz.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.validation.constraints.Max;
//import javax.validation.constraints.NotNull;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class QuantityDTO {
//
//    @NotNull
//    @Max(100)
//    private Integer quantity;
//}
=======
package io.github.humbertoluiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDTO {

    @NotNull
    @Max(100)
    private Integer quantity;
}
>>>>>>> 5ae35af1d740607db2bc7c21cc0d6a506a6f2920
