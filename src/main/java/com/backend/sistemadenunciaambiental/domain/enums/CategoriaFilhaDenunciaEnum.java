package com.backend.sistemadenunciaambiental.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CategoriaFilhaDenunciaEnum {

    FAUNA_1 (0,"Do transporte e comercialização de animais abatidos de forma ilegal."),
    FAUNA_2 (1,"Pesca ilegal, predatória ou por meio de explosivos, ou substâncias que em contato com " +
                "a água produzem efeito semelhante. Assim como, transportar ou comercializar espécies " +
                "provenientes de tais atos."),
    FAUNA_3 (2, "Caça ilegal ou predatória, de animais em extinção ou fora de época, bem como entrar " +
                "em locais de conservação portando instrumentos próprios para a atividade."),
    FAUNA_4 (3, "Ferir, praticar maus-tratos, abuso ou mutilação de qualquer animal silvestre."),
    FAUNA_5 (4, "Experiências que possam causar dor e sofrimento aos animais."),
    FAUNA_6 (5, "Emissão de efluentes, substâncias tóxicas ou outro meio proibido que possa provocar a " +
                "morte ou extinção de espécies aquáticas."),
    FLORA_1(6, "Destruir ou danificar florestas de preservação permanente, independentemente do " +
            "estágio de formação."),
    FLORA_2(7, "Destruir ou danificar qualquer vegetação do Bioma Mata Atlântica."),
    FLORA_3(8, "Cortar árvores em florestas de preservação permanente, sem a devida permissão."),
    FLORA_4(9, "Fabricar, vender, transportar ou soltar balões que podem provocar incêndios."),
    FLORA_5(10, "Destruir, danificar, lesar ou maltratar, por qualquer meio ou modo, plantas de ordenação " +
            "de espaços públicos ou em propriedades privadas alheias."),
    POLUICAO_1(11,"Causar poluição atmosférica ou híbrida."),
    POLUICAO_2(12,"Dificultar ou impedir o uso público das praias."),
    POLUICAO_3(13,"Realizar pesquisa, lavra ou extração de recursos minerais sem autorização legal."),
    POLUICAO_4(14,"Produzir, processar, embalar, importar, exportar, comercializar, fornecer, transportar, " +
                "armazenar, guardar, ter em depósito ou usar substância tóxica perigosa, ou nociva à " +
                "saúde humana ou ao meio ambiente, em desacordo com as exigências estabelecidas."),
    POLUICAO_5(15,"Construir, reformar, ampliar, instalar ou fazer funcionar, estabelecimentos, obras ou " +
                "serviços potencialmente poluidores, sem licença."),
    POLUICAO_6(16,"Disseminar doença ou praga que cause dano à agricultura, pecuária, fauna, flora e aos " +
                "ecossistemas."),
    ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL_1(17,"Pixação em áreas urbanas."),
    ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL_2(18,"Alterar o aspecto ou estrutura bem como promover a " +
            "construção em solo de locais " +
            "protegidos em razão do seu valor paisagístico, ecológico, turístico, artístico, histórico, " +
            "cultural, religioso, arqueológico, etnográfico ou monumental, sem autorização prévia " +
            "da autoridade competente."),
    ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL_3(19,"Mineração, Ruído e Vibração Industrial."),
    ADMINISTRACAO_AMBIENTAL_1(20, "Práticas como afirmações falsas ou enganosas."),
    ADMINISTRACAO_AMBIENTAL_2(21, "Concessões de licenças, autorizações ou permissões emitidas " +
            "pelos funcionários, porém em desacordo com as normas ambientais."),
    OUTROS(22, "Outros");


    private Integer id;
    private String descricao;
}
