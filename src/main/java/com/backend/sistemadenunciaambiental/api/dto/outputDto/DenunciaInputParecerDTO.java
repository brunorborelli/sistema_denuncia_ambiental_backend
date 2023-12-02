package com.backend.sistemadenunciaambiental.api.dto.outputDto;

import com.backend.sistemadenunciaambiental.domain.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaInputParecerDTO {

    private String parecerTecnico;

    private StatusEnum status;

}
