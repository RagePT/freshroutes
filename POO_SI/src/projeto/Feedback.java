package projeto;

public class Feedback {

	/*Atenção depois digam o que acham mas no método toString por mim ficava só
	 * pontualidade,conforto,acessibilidade,limpeza, pois são de (1 a 5)
	 * e dava print desse quadro .
	 *  e no  gestor guardavamos numa arrayList os comentarios
	 * noutras list as sugestôesRotas e noutra list o livroReclamçoes pois nromalmente são coisas 
	 * bem grandes e como tbm alguns deles são uteis pó administrador faz sentido ficar em outro sitio
	**/
      private byte pontualidade;
      private byte conforto;
      private byte acessibilidade;
      private byte limpeza;
      private String comentarios;
      private String sugestoesRotas;
      private String livroReclamacoes;
      
      Feedback( byte pontualidade, byte conforto, byte acessibilidade, byte limpeza, String comentarios, String sugestoesRotas, String livroReclamacoes){
    	
    	  this.pontualidade = pontualidade;
          this.conforto = conforto;
          this.acessibilidade = acessibilidade;
          this.limpeza = limpeza;
          this.comentarios = comentarios;
          this.sugestoesRotas = sugestoesRotas;
          this.livroReclamacoes = livroReclamacoes;
      }
      
      public byte getPontualiade() {
    	  return pontualidade;
      }
      public void setPontualidade(byte pontualidade) {
    	  this.pontualidade = pontualidade;
      }
      

      public byte getConforto() {
    	  return conforto;
      }
      public void setConforto(byte conforto) {
    	  this.conforto = conforto;
      }
      

      public byte getAcessibilidade() {
    	  return acessibilidade;
      }
      public void setAcessibilidade(byte acessibilidade) {
    	  this.acessibilidade = acessibilidade;
      }
      

      public byte getLimpeza() {
    	  return limpeza;
      }
      public void setLimpeza(byte limpeza) {
    	  this.limpeza = limpeza;
      }
      

      public String getComentarios() {
    	  return comentarios;
      }
      public void setComentarios(String comentarios) {
    	  this.comentarios = comentarios;
      }
      

      public String getSusgestoesRotas() {
    	  return sugestoesRotas;
      }
      public void setSugestoesRotas(String sugestoesRotas) {
    	  this.sugestoesRotas = sugestoesRotas;
      }
      
      
      public String toString() {   
    	  
    	  return ("**************Feedback**************\n "
    	  		+ "Pontualidade: "+pontualidade+"\r\n"
    	  		+ "Conforto: "+conforto+"\r\n"
    	  		+ "Acessibilidade: "+acessibilidade+"\r\n"
    	  		+ "Limpeza: "+limpeza+"\r\n"
    	  		+ "Comentarios: "+comentarios+"\r\n"
    	  		+ "SugestoesRotas: "+sugestoesRotas+"\r\n"
    	  		+ "LivroReclamacoes: "+livroReclamacoes);
    	  
      }
      
}
