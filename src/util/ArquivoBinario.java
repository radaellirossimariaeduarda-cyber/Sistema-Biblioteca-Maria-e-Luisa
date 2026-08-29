package util;

import java.io.*;
import java.util.Map;

public class ArquivoBinario {
    public static void salvar(String nomeArquivo, Object objeto){
        try{
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream gravar = new ObjectOutputStream(arquivo);
            gravar.writeObject(objeto);
            gravar.close();
        }catch(Exception e){
            System.out.println("Erro ao salvar arquivo.");
        }
    }
    public static Object carregar(String nomeArquivo){
        try{
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream ler = new ObjectInputStream(arquivo);
            Object objeto = ler.readObject();
            ler.close();
            return objeto;
        }
        catch(Exception e){
            return null;
        }
    }
}