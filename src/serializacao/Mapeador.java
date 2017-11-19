package serializacao;

import gerencia.model.Estabelecimento;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Mapeador {
    
    //Atributos
    
    private Estabelecimento cache;
    private final String FILE_NAME;
    private final String EXTENSAO = ".est";
    
    //Construtor
    
    public Mapeador(String nomeDoArquivo){
        FILE_NAME = nomeDoArquivo + EXTENSAO;
        load();
    }
    
    //Getters e Setters
    
    public Estabelecimento getCache(){
        return this.cache;
    }
    
    public void setCache(Estabelecimento cache){
        this.cache = cache;
    }
    
    //Métodos
    
    public void persist() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cache);
            
            objectOutputStream.flush();
            fileOutputStream.flush();
            
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex){
            System.out.println(ex);
        }    
    }
    
    public void load(){
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            this.cache = (Estabelecimento) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException ex){
            System.out.println(ex);
            System.out.println("Se voce esta criando o arquivo pela primeira vez, é normal aparecer este erro");
            this.cache = Estabelecimento.getInstance();
            this.persist();
        } catch (IOException ex){
            System.out.println(ex);
        } catch (ClassNotFoundException ex){
            System.out.println(ex);
        }
    }
}
