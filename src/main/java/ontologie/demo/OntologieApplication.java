package ontologie.demo;


import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileReader;

@SpringBootApplication
public class OntologieApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OntologieApplication.class, args);
	}


	@Override
	public void run(String... strings) throws Exception {
		String fileName = "movie_ontology.owl";
		try {
			File file = new File(fileName);
			System.out.println("Attempting to read from file in: "+file.getCanonicalPath());
			FileReader reader = new FileReader(file);

			OntModel model = ModelFactory
					.createOntologyModel(OntModelSpec.OWL_DL_MEM);
			model.read(reader,null);
			model.write(System.out,"RDF/XML-ABBREV");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
