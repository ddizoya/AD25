package hiberconection;




// Generated Dec 7, 2015 1:52:52 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * Produtos generated by hbm2java
 */
public class Produtos  implements java.io.Serializable {


     private String cod;
     private String descricion;
     private BigDecimal prezo;

    public Produtos() {
    }

	
    public Produtos(String cod) {
        this.cod = cod;
    }
    public Produtos(String cod, String descricion, BigDecimal prezo) {
       this.cod = cod;
       this.descricion = descricion;
       this.prezo = prezo;
    }
   
    public String getCod() {
        return this.cod;
    }
    
    public void setCod(String cod) {
        this.cod = cod;
    }
    public String getDescricion() {
        return this.descricion;
    }
    
    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }
    public BigDecimal getPrezo() {
        return this.prezo;
    }
    
    public void setPrezo(BigDecimal prezo) {
        this.prezo = prezo;
    }




}


