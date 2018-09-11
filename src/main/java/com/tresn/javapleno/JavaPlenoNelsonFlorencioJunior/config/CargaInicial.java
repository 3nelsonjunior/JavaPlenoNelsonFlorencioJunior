package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CargaInicial  implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/*
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    PerfilService perfilService;
    
    @Autowired
    EnderecoService enderecoService;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        
    	List<Perfil> perfis = perfilService.findAll();
        List<Usuario> usuarios = usuarioService.findAll();

        if(perfis.isEmpty()){
        	criarPerfis();
        }
        
        perfis = perfilService.findAll();
        
        if(!perfis.isEmpty() && usuarios.isEmpty()) {
        	criarUsuario();
        }
        
    }
        
    public void criarUsuario() {
        Usuario usuario1 = new Usuario();
        usuario1.setNome("admin");
        usuario1.setApelido("admin");
        usuario1.setDtNasc(LocalDate.parse("1989-04-30"));
        usuario1.setEmail("bbp.rp@gmail.com");
        usuario1.setSenha("adminbbp");
        usuario1.setTelefone1("(32)9XXXX-XXXX");
        usuario1.setAtivo(true);
        usuario1.setUrlFoto("avatar-default");
        usuario1.setPerfis(perfilService.createListPerfilAdminToUsuario());
        usuarioService.saveInitialCharge(usuario1);
        
        Usuario usuario2 = new Usuario();
        usuario2.setNome("Nelson Florêncio Júnior");
        usuario2.setApelido("3nelsonjunior");
        usuario2.setDtNasc(LocalDate.parse("1989-04-30"));
        usuario2.setEmail("3nelsonjunior@gmail.com");
        usuario2.setSenha("nelson");
        usuario2.setTelefone1("(32)98416-3554");
        usuario2.setAtivo(true);
        usuario2.setUrlFoto("avatar-default");
        usuario2.setPerfis(perfilService.createListPerfilDevToUsuario());
        usuarioService.saveInitialCharge(usuario2);
        
        Usuario usuario3 = new Usuario();
        usuario3.setNome("Ronie Ferreira");
        usuario3.setApelido("roninho");
        usuario3.setDtNasc(LocalDate.parse("1991-02-01"));
        usuario3.setEmail("roninho@gmail.com");
        usuario3.setSenha("roninho");
        usuario3.setTelefone1("(32)9XXXX-XXXX");
        usuario3.setAtivo(true);
        usuario3.setUrlFoto("avatar-default");
        usuario3.setPerfis(perfilService.createListPerfilAdminToUsuario());
        usuarioService.saveInitialCharge(usuario3);
        
        Usuario usuario4 = new Usuario();
        usuario4.setNome("Robson Ferreira");
        usuario4.setApelido("robinho");
        usuario4.setDtNasc(LocalDate.parse("1990-02-01"));
        usuario4.setEmail("robinho@gmail.com");
        usuario4.setSenha("robinho");
        usuario4.setTelefone1("(32)9XXXX-XXXX");
        usuario4.setAtivo(true);
        usuario4.setUrlFoto("avatar-default");
        usuario4.setPerfis(perfilService.createListPerfilAdminToUsuario());
        usuarioService.saveInitialCharge(usuario4);
        
        Usuario usuario5 = new Usuario();
        usuario5.setNome("Barbeiro 1 - Teste");
        usuario5.setApelido("barbeiro1");
        usuario5.setDtNasc(LocalDate.parse("1990-01-01"));
        usuario5.setEmail("barbeiro1@gmail.com");
        usuario5.setSenha("barbeiro1");
        usuario5.setTelefone1("(32)9XXXX-XXXX");
        usuario5.setAtivo(true);
        usuario5.setUrlFoto("avatar-default");
        usuario5.setPerfis(perfilService.createListPerfilDevToUsuario());
        usuarioService.saveInitialCharge(usuario5);
        
        Usuario usuario6 = new Usuario();
        usuario6.setNome("Cliente 1 - Teste");
        usuario6.setApelido("cliente1");
        usuario6.setDtNasc(LocalDate.parse("2000-01-01"));
        usuario6.setEmail("cliente1@gmail.com");
        usuario6.setSenha("cliente1");
        usuario6.setTelefone1("(32)9XXXX-XXXX");
        usuario6.setAtivo(true);
        usuario6.setUrlFoto("avatar-default");
        usuario6.setPerfis(perfilService.createListPerfilClienteToUsuario());
        usuarioService.saveInitialCharge(usuario6);
    }
    
    public void criarPerfis() {
    	Perfil perfil1 = new Perfil();
    	perfil1.setNome("ROLE_ADMIN");
    	perfilService.save(perfil1);
    	
    	Perfil perfil2 = new Perfil();
    	perfil2.setNome("ROLE_CLIENTE");
    	perfilService.save(perfil2);
    	
    	Perfil perfil3 = new Perfil();
    	perfil3.setNome("ROLE_DEV");
    	perfilService.save(perfil3);
    	
    	Perfil perfil4 = new Perfil();
    	perfil4.setNome("ROLE_BARBEIRO");
    	perfilService.save(perfil4);
    }
    */
}
