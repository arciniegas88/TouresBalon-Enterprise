/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.touresbalon.foundation.creditcard.bussines;

import co.com.touresbalon.foundation.creditcard.dto.Card;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author nrodriguez
 */
public class RegistryCreditCardBundary implements Serializable{
    
  final static  String FILE_NAME = "CreditCard.txt";
  final static String FILE_PATH = "N:";
  final static Charset ENCODING = StandardCharsets.UTF_8; 
  private String nameFileCreditCard; 
  
  /**
   * Adicionar tarjeta de credito
   * @param card
   * @return
   * @throws IOException 
   */
  public  boolean addTarjetaCredito(Card card) throws IOException{
   RegistryCreditCardBundary text = new RegistryCreditCardBundary();
   nameFileCreditCard = getFileName();
   try{
       File file = new File(nameFileCreditCard);
       if(!file.exists()){
           FileWriter fw=new FileWriter(nameFileCreditCard);
           fw.flush();
       }
       
    List<String> lines = text.readTextFile(nameFileCreditCard);
    log(lines);
    lines.add(setFileCard(card));
    text.writeTextFile(lines, nameFileCreditCard);
    
   }catch(IOException e){
       e.printStackTrace();
       return false;
   }
    return true;
  }

  /**
   * Metodo para setear la estructura del archivo en una linea
   * @param card
   * @return 
   */
  public String setFileCard(Card card) {
        StringBuffer sb = new StringBuffer();
        if (card != null) {
            sb.append(card.getNumberCard());
            sb.append(",");
            sb.append(card.getName());
            sb.append(",");
            sb.append(card.getExpirationDate());
            sb.append(",");
            sb.append(card.getCcv());
            sb.append(",");
            sb.append(card.getFranquicia());
        }
        return sb.toString();
  }
  
  public String getFileName(){
      return FILE_PATH + File.separator+FILE_NAME;
  }
  
  
  
  
  /**
   * lectura del archivo plano
   * @param aFileName
   * @return
   * @throws IOException 
   */  
  public List<String> readTextFile(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    return Files.readAllLines(path, ENCODING);
  }
  
  
  /**
   * escritura del archivo plano
   * @param aLines
   * @param aFileName
   * @throws IOException 
   */
  public void writeTextFile(List<String> aLines, String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    Files.write(path, aLines, ENCODING);
  }

  /**
   * Genera log 
   * @param aMsg 
   */
  private  void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
} 
    
