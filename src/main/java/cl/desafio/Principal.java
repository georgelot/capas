package cl.desafio;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Principal {

	private final static Logger logger = LoggerFactory.getLogger(Principal.class);
	
	@RequestMapping("/")
	public String Main(Model modelo) {
		String nombre = "src/main/resources/static/noticias.txt";
		ArrayList<String> news = new ArrayList<String>();
		
		try(
			FileReader fr = new FileReader(nombre);
			BufferedReader br = new BufferedReader(fr);	
			){
			String texto = br.readLine();
			while(texto != null) {
				news.add(texto);
				logger.info("Noticia añadida correctamente");
				texto = br.readLine();
			}
			}catch (Exception e) {
				logger.error("Error al leer txt " + nombre + "; " + e);
			}
		String[] noticia1 = news.get(0).split("@@");
		String[] noticia2 = news.get(1).split("@@");
		String[] noticia3 = news.get(2).split("@@");
		String[] noticia4 = news.get(3).split("@@");
		String[] noticia5 = news.get(4).split("@@");
		
		modelo.addAttribute("noticia1", noticia1);
		modelo.addAttribute("noticia2", noticia2);
		modelo.addAttribute("noticia3", noticia3);
		modelo.addAttribute("noticia4", noticia4);
		modelo.addAttribute("noticia5", noticia5);
		
		return "main";
		
	}
}
