package com.millenium.etl.common.service;

import static java.util.Optional.ofNullable;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;

import com.millenium.etl.common.dto.CommandLinePredictiveCampaignArgumentsDTO;

public class CommandPredictiveCampaignArgumentsLineServiceImpl implements EtlPropertiesFactoryService<CommandLinePredictiveCampaignArgumentsDTO>{
	
	@Value("${etl.default.target.table:audiomensaje}")
    protected String targetTableByProperties;

	/**
	 * Retorna un dto con los argumentos parseados de la línea de comandos del CRM Legacy
	 * @param args
	 * @return
	 */
	@Override
	public CommandLinePredictiveCampaignArgumentsDTO getFromArguments(String[] args) {
		
    	// Obtiene un mapa de los argumentos del programa
    	Map<String, String> mapArgumentos = Arrays.stream( Arrays.stream( args ).collect( Collectors.joining( " " ) ).split( "\\s*--context_param \\s*" ) )
    		.filter( s->!s.trim().isEmpty() )
    		.map( s->s.split("=") )
    		.collect( Collectors.toMap( arg->arg[0] , arg->arg[1], (arg1,arg2)->arg1 ) );
    	
    	if( mapArgumentos.isEmpty() ) {
    		return null;
    	}
    	
    	// Crea el DTO del mapa
    	CommandLinePredictiveCampaignArgumentsDTO commandLineArgumentsDTO = new CommandLinePredictiveCampaignArgumentsDTO();
    	commandLineArgumentsDTO.setFilePath( mapArgumentos.get( "archivo" ) );
    	commandLineArgumentsDTO.setUserId( Long.parseLong( mapArgumentos.get( "usuario" ) ) );
    	commandLineArgumentsDTO.setListId( Long.parseLong( mapArgumentos.get( "lista" ) ) );
    	commandLineArgumentsDTO.setTargetTable( ofNullable(mapArgumentos.get( "tabla" )).orElse( targetTableByProperties ) );
		
		return commandLineArgumentsDTO;
	}
	

}