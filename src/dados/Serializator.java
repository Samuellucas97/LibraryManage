package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author José Welliton Nunes Júnior
 */
public class Serializator {

    public static void serialize(Object object, String key) throws ServicoException {
        try {
            String filename = key.concat(".lm");
            FileOutputStream fos = new FileOutputStream(FileUtils.getFile(filename));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            throw new ServicoException(e.getMessage());
        }
    }

    public static Object unserialize(Object object, String key) throws ServicoException{
        String filename = key.concat(".lm");
        File file;
        FileInputStream fis;
        
        
        try {           
            file = FileUtils.getFile(filename);

            if( !file.exists()) 
                serialize(object, key);

            fis = new FileInputStream(file);
            
            if(fis.read() == -1)
                serialize(object, key);
            
            fis.close();
            fis = new FileInputStream(file);
            
            ObjectInputStream ois = new ObjectInputStream(fis);  
                        
            Object obj = ois.readObject();
            ois.close();
            //fis.close();
            return obj;            
        } catch (IOException | ClassNotFoundException e) {
            serialize(object, key);      
            throw new ServicoException("Arquivo estava corrompido e foi recriado com informações vazias!");
        }
    }
}