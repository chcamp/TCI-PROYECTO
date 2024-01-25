package com.tci.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.tci.entities.Usuario;
import com.tci.services.UsuarioService;

@Component
public class InfoAdicionalToken implements TokenEnhancer{
	
	
	@Autowired
	UsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		//obtenemos el objeto Usuario para tener toda su intormacion.
			//	Usuario usuario = usuarioService.findByUse
				
				//vamos a aguardra cualquier dato con el objeto HashMap()
				Map<String, Object> info = new HashMap<>();
				//guardamos un dato de tipo String con un string + nombre de la autenticacion objeto.
				info.put("info_adicional", "Hola que tal: ".concat(authentication.getName()));
				
				//con el objeto usuario instanciado, podemos obtener toda su informacion adicional:
		
				
				//info.put("nombre: ", usuario.getUsername() );
				
				//info.put("roles: ", usuario.getRoles());
				
				
				
				//pasamos al accessToken la info que creamos de tipo HashMap
				((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);		
				
				return accessToken;
	}
	
	

}
