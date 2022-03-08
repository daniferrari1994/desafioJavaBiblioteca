package com.biblioteca;

import com.biblioteca.entidades.Autor;
import com.biblioteca.entidades.Categoria;
import com.biblioteca.entidades.Editorial;
import com.biblioteca.entidades.Libro;
import com.biblioteca.servicios.AutorService;
import com.biblioteca.servicios.CategoriaService;
import com.biblioteca.servicios.EditorialService;
import com.biblioteca.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner {

	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private EditorialService editorialService;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		long millis=System.currentTimeMillis();
		Date date=new Date(millis);

		Categoria categoria1 = new Categoria("Juvenil");
		Categoria categoria2 = new Categoria("Mitologico");
		Categoria categoria3 = new Categoria("Fantasia");
		categoriaService.guardarCategoria(categoria1);
		categoriaService.guardarCategoria(categoria2);
		categoriaService.guardarCategoria(categoria3);

		Autor autor1 = new Autor("Stephen Chbosky",date, "Estadounidense");
		Autor autor2 = new Autor("Michael Scott",date, "irlandes");
		Autor autor3 = new Autor("J.K. Rowling",date, "Britanica");
		Autor autor4 = new Autor("Jenn Bennett",date, "Estadounidense");
		autorService.guardarAutor(autor1);
		autorService.guardarAutor(autor2);
		autorService.guardarAutor(autor3);
		autorService.guardarAutor(autor4);

		Editorial editorial1 = new Editorial("Pocket Books");
		Editorial editorial2 = new Editorial("Random House");
		Editorial editorial3 = new Editorial("Bloomsbury Publishing");
		Editorial editorial4 = new Editorial("V&R");
		editorialService.guardarEditorial(editorial1);
		editorialService.guardarEditorial(editorial2);
		editorialService.guardarEditorial(editorial3);
		editorialService.guardarEditorial(editorial4);

		Libro libro1 = new Libro("The Perks of Being a Wallflower",date,autor1,editorial1,categoria1);
		Libro libro2 = new Libro("The Alchemyst: The Secrets of the Immortal Nicholas Flamel",date,autor2,editorial2,categoria2);
		Libro libro3 = new Libro("Harry Potter",date,autor3,editorial3,categoria3);
		Libro libro4 = new Libro("Night Owls",date,autor4,editorial4,categoria1);

		libroService.guardarLibro(libro1);
		libroService.guardarLibro(libro2);
		libroService.guardarLibro(libro3);
		libroService.guardarLibro(libro4);

		autorService.getAutores().forEach(autor -> System.out.println(autor));
		editorialService.getEditoriales().forEach(editorial -> System.out.println(editorial));
		categoriaService.getCategorias().forEach(categoria -> System.out.println(categoria));
		libroService.getLibros().forEach(libro-> System.out.println(libro));

	}
}
