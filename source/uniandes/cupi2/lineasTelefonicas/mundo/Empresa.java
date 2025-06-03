/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_lineasTelefonicas
 * Autor: Equipo Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.lineasTelefonicas.mundo;

/**
 * Clase que representa la empresa.
 */
public class Empresa
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Líneas telefónicas.
     */
    private LineaTelefonica[] lineas; // Array que contendra las 3 lineas telefonicas

    // --------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Inicializa las líneas telefónicas de la empresa. <br>
     * <b>post: </b> Se inicializaron las 3 líneas telefónicas.
     */
    public Empresa( ) // Constructor de la clase
    {
    	// Inicialize la 3 instancias de la clase empresa
        lineas = new LineaTelefonica[3];
        
        lineas[0] = new LineaTelefonica( );
        
        lineas[1] = new LineaTelefonica( );
        
        lineas[2] = new LineaTelefonica( );

    }

    /**
     * Retorna la línea 1.
     * @return Línea 1.
     */
    public LineaTelefonica darLinea1( )
    {
    	return lineas[0]; // Metodo getter para enviar información al usuario
 
    }

    /**
     * Retorna la línea 2.
     * @return Línea 2.
     */
    public LineaTelefonica darLinea2( )
    {
        return lineas[1]; // Metodo getter para enviar información al usuario
 
    }

    /**
     * Retorna la línea 3.
     * @return Línea 3.
     */
    public LineaTelefonica darLinea3( )
    {
    	return lineas[2]; // Metodo getter para enviar información al usuario
  
    }

    /**
	 * Retorna el número total de llamadas realizadas.
	 * @return Total de llamadas de las tres líneas.
	 */
	public int darTotalNumeroLlamadas( )
	{
		int totalLlamadas = 0; // Inicializamos una variable donde acumulamos las llamadas
		
		for (LineaTelefonica linea : lineas) { // Bucle for-each para recorrer los elementos del array
			totalLlamadas += linea.darNumeroLlamadas(); // En cada iteración obtenemos el número de llamada de cada linea y se suma a la variable totalLlamadas
		}
		return totalLlamadas; // Retornamos el total de llamadas 
	}

	/**
	 * Retorna el total de minutos consumidos.
	 * @return Total de minutos de las tres líneas.
	 */
	public int darTotalMinutos( )
	{
		int totalMinutos = 0; // Inicializamos una variable donde acumulamos los minutos
		
		for (LineaTelefonica linea : lineas) { // Bucle for-each para recorrer los elementos del array
			totalMinutos += linea.darNumeroMinutos(); // Mismo proceso del metodo anterior
		}
		return totalMinutos; // Retornamos el total de minutos
	}

	/**
	 * Retorna el costo total de las llamadas realizadas.
	 * @return Costo total de las tres líneas.
	 */
	public double darTotalCostoLlamadas( )
	{      
		double costoTotal = 0.0; // Inicializamos una variable donde acumulamos el costo
		
		for (LineaTelefonica linea : lineas) { // Bucle for-each para recorrer los elementos del array
			costoTotal += linea.darCostoLlamadas(); // Mismo proceso del metodo anterior
		}
		return costoTotal; // Retornamos el costo total
	}

	/**
	 * Retorna el costo promedio de un minuto, según los minutos consumidos. <br>
	 * @return Costo promedio por minuto.
	 */
	public double darCostoPromedioMinuto( )
	{
		
		int totalMinutos = darTotalMinutos();
		double costoTotal = darTotalCostoLlamadas();
		
		if (totalMinutos == 0) // Condicional para evitar dividir por 0
		{
			return 0.0;
		}
		
		return costoTotal / totalMinutos; // Retornamos el promedio  
      
	}

	/**
     * Agrega una llamada local a la línea telefónica 1 <br>
     * <b>post: </b> Se agregó la llamada a la línea 1.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
	private void agregarLlamada(int indiceLinea, int pMinutos, String tipo ) {
		if (indiceLinea >= 0 && indiceLinea < lineas.length) {
			switch (tipo) {
			   case "local":
				   lineas[indiceLinea].agregarLlamadaLocal(pMinutos);
				   break;
			   case "larga distancia": 
				   lineas[indiceLinea].agregarLlamadaLargaDistancia(pMinutos);
				   break;
			   case "celular":
				   lineas[indiceLinea].agregarLlamadaCelular(pMinutos);
				   break;	   
			} 
		} 
	}
    public void agregarLlamadaLocal( int indiceLinea, int pMinutos )
    {
    	agregarLlamada(indiceLinea, pMinutos, "local");
        
    }

  
    /**
     * Agrega una llamada de larga distancia a una línea telefónica específica. <br>
     * @param pMinutos Número de minutos de la llamada. `pMinutos` > 0.
     */
    public void agregarLlamadaLargaDistancia( int indiceLinea, int pMinutos )
    {
    	agregarLlamada(indiceLinea, pMinutos, "larga distancia");

    }

    /**
     * Agrega una llamada a celular a la línea telefónica 1. <br>
     * <b>post: </b> Se agrega la llamada a la línea 1.
     * @param pMinutos Número de minutos de la llamada. pMinutos > 0.
     */
    public void agregarLlamadaCelular( int indiceLinea, int pMinutos )
    {
    	agregarLlamada(indiceLinea, pMinutos, "celular");
    }

    /**
     * Reinicia todas las líneas telefónicas.
     * <b>post: </b> Se reinició la llamada a la línea 1, 2 y 3.
     */
    public void reiniciar( )
    {
        lineas[0].reiniciar( );
        
        lineas[1].reiniciar();
        
        lineas[2].reiniciar();
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
