package com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Colaborador;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.model.Setor;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.service.ColaboradorService;
import com.tresn.javapleno.JavaPlenoNelsonFlorencioJunior.service.SetorService;

@Component
public class CargaInicial  implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private SetorService setorService;
	
	@Autowired
	private ColaboradorService colaboradorService;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        
    	List<Setor> listaSetores = setorService.findAll();
    	List<Colaborador> listaColaboradores = colaboradorService.findAll();

        if(listaSetores.isEmpty()){
        	criarSetores();
        }
        
        listaSetores = setorService.findAll();
        
        if(!listaSetores.isEmpty() && listaColaboradores.isEmpty()) {
        	criarColaboradorADMIN();
        }
        
    }
        
    public void criarColaboradorADMIN() {
    	Colaborador colaborador = new Colaborador();
    	colaborador.setNome("admin");
    	colaborador.setCpf("11111111111");
    	colaborador.setEmail("adminp@mobicare.com");
    	colaborador.setSetor(setSetorADM());
    	colaboradorService.save(colaborador);
    }
    
    public Setor setSetorADM() {
    	Setor setor = new Setor();
    	setor = setorService.findByOne("descricao", "ADM-TOTAL");
    	return setor;
    }
    
    public void criarSetores() {
    	Setor setor1 = new Setor();
    	setor1.setDescricao("Administrativo");
    	setorService.save(setor1);
    	
    	Setor setor2 = new Setor();
    	setor2.setDescricao("RH");
    	setorService.save(setor2);
    	
    	Setor setor3 = new Setor();
    	setor3.setDescricao("TI");
    	setorService.save(setor3);
    	
    	Setor setor4 = new Setor();
    	setor4.setDescricao("Serviços Gerais");
    	setorService.save(setor4);
    	
    	Setor setor5 = new Setor();
    	setor5.setDescricao("Segurança do Trabalho");
    	setorService.save(setor5);
    	
    	Setor setor6 = new Setor();
    	setor6.setDescricao("ADM-TOTAL");
    	setorService.save(setor6);
    	
    }
    
}
