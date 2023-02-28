/**
	Dados tres inventarios de tiendas que venden ciertos productos, un estudiante de IPC1
	quiere encontrar la tienda que tiene todos los productos que busca, o en su lugar la tienda
	que tiene la mayor cantidad de productos. Además quiere saber cuanto le saldría 
	comprarlos. Sabiendo que todas las frutas están a 7, todas las bebidas a 10
	y todo lo demas a 5 y que las tiendas están abastecidas de la siguiente manera:
	Tienda 1: Manzana, Vino, Naranja, Jugo -- ARREGLO
	Tienda 2: Uva, Manzana, Gaseosa, Sal de ajo, Jugo, Chocolate
	Tienda 3: Sal, Azucar, Pimienta, Manzana, Sal de ajo, Jugo, Uva

	INICIO Tiendas
		VAR tienda1
		VAR tienda2
		VAR tienda3
		tienda1 = {Manzana, Vino, Naranja, Jugo}
		tienda2 = {Uva, Manzana, Gaseosa, Sal de ajo, Jugo, Chocolate}
		tienda3 = {Sal, Azucar, Pimienta, Manzana, Sal de ajo, Jugo, Uva}
		VAR productosEncontrados[3]
		VAR numeroProductos
		productosEncontrados = {0,0,0}
		numeroProductos = 0
		ESCRIBIR "¿Cuantos productos deseas?"
		LEER numeroProductos
		VAR listadoProductos[numeroProductos]
		DESDE i=0; HASTA numeroProductos; 1
			ESCRIBIR "Ingresa el producto #"
			ESCRIBIR i
			LEER listadoProductos[i] --- Manzana, Sal, Azucar
		FINDESDE
		productosEncontrados[0] = LLAMAR encontradosTienda(tienda1,listadoProductos)
		productosEncontrados[1] = LLAMAR encontradosTienda(tienda2,listadoProductos)
		productosEncontrados[2] = LLAMAR encontradosTienda(tienda3,listadoProductos)
		
		SI (productosEncontrados[0] > productosEncontrados[1]) ENTONCES
			SI (productosEncontrados[0] > productosEncontrados[2]) ENTONCES
				LLAMAR totalTienda(1,tienda1,listadoProductos)
			SINO
				LLAMAR totalTienda(3,tienda3,listadoProductos)
			FINSI
		SINO
			SI (productosEncontrados[1] > productosEncontrados[2]) ENTONCES
				LLAMAR totalTienda(2,tienda2,listadoProductos)
			SINO
				LLAMAR totalTienda(3,tienda3,listadoProductos)
			FINSI
		FINSI
	FIN

	INICIO PROCESO encontradosTienda(tienda, listadoProductos)
		VAR numeroEncontrados
		numeroEncontrados = 0
		DESDE i = 0; HASTA listadoProductos.longitud(); 1
			VAR productoEncontrado
			productoEncontrado = 0
			VAR contador = 0
			HACER
				SI (listadoProductos[i] == tienda[contador]) ENTONCES
					productoEncontrado = 1
					numeroEncontrados = numeroEncontrados + 1
				FINSI
				contador = contador + 1
			MIENTRAS (producto == 0 && contado < tienda.longitud())
		FINDESDE
		RETORNAR numeroEncontrados
	FIN

	INICIO PROCESO totalTienda(numeroTienda,tienda,listadoProductos)
		ESCRIBIR "Tienda #"
		ESCRIBIR numeroTienda
		ESCRIBIR "es la que tiene más productos, dando un costo total de"
		VAR sumaCostos
		sumaCostos = 0
		CONST FRUTA = 7
		CONST BEBIDA = 10
		CONST RESTO = 5
		DESDE i = 0; HASTA listadoProductos.longitud(); 1
			DESDE j = 0; HASTA tienda.longitud(); 1
				SI (tienda[j] == listadoProductos[i]) ENTONCES
					SI (listadoProductos[i]=="MANZANA" || 
						listadoProductos[i]=="UVA" ||
						listadoProductos[i]=="NARANJA") ENTONCES
						sumaCostos = sumaCostos + FRUTA
					SINO SI (listadoProductos[i]=="VINO" || 
						listadoProductos[i]=="JUGO" ||
						listadoProductos[i]=="GASEOSA") ENTONCES
						sumaCostos = sumaCostos + BEBIDA
					SINO 
						sumaCostos = sumaCostos + RESTO
					FINSI
				FINSI
			FINDESDE
		FINDESDE
		ESCRIBIR sumaCostos
	FIN
**/	

import java.util.Scanner;
public class ProblemaTiendas {
	public static void main(String[] args) {
		Scanner escaner = new Scanner(System.in);
		String[] tienda1 = 
			{"MANZANA", "VINO", "NARANJA", "JUGO"};
		String[] tienda2 = 
			{"UVA", "MANZANA", "GASEOSA", "SAL DE AJO", "JUGO", "CHOCOLATE"};
		String[] tienda3 = 
			{"SAL", "AZUCAR", "PIMIENTA", "MANZANA", "SAL DE AJO", "JUGO", "UVA"};
		int[] productosEncontrados = {0,0,0};
		System.out.println("Cuantos productos deseas?");
		int numeroProductos = escaner.nextInt();
		String[] listadoProductos = new String[numeroProductos];
		for (int i = 0; i < numeroProductos; i++) {
			escaner = new Scanner(System.in);
			System.out.println("Ingresa el producto #"+(i+1));
			listadoProductos[i] = escaner.nextLine();
		}
		productosEncontrados[0] = encontradosTienda(tienda1, listadoProductos);
		productosEncontrados[1] = encontradosTienda(tienda2, listadoProductos);
		productosEncontrados[2] = encontradosTienda(tienda3, listadoProductos);
		if (productosEncontrados[0] > productosEncontrados[1]){
			if (productosEncontrados[0] > productosEncontrados[2]){
				totalTienda(1, tienda1, listadoProductos);
			} else {
				totalTienda(3, tienda3, listadoProductos);
			}
		} else {
			if (productosEncontrados[1] > productosEncontrados[2]){
				totalTienda(2, tienda2, listadoProductos);
			} else {
				totalTienda(3, tienda3, listadoProductos);
			}
		}
		escaner.close();
	}

	public static int encontradosTienda(String[] tienda, String[] listadoProductos){
		int numeroEncontrados = 0;
		for (int i = 0; i < listadoProductos.length; i++) {
			boolean productoEncontrado = false;
			int contador = 0;
			do {
				if (listadoProductos[i].equalsIgnoreCase(tienda[contador])){
					numeroEncontrados++;
					productoEncontrado = true;
				}
				contador++;
			} while (productoEncontrado==false && contador < listadoProductos.length);
		}
		return numeroEncontrados;
	}

	public static void totalTienda(int numeroTienda, String[] tienda, String[] listadoProductos){
		System.out.print("Tienda "+numeroTienda+" es la que tiene más productos, dando un costo total de ");
		int sumaCostos = 0;
		final int FRUTA = 7;
		final int BEBIDA = 10;
		final int RESTO = 5;
		for (int i = 0; i < listadoProductos.length; i++) {
			for (int j = 0; j < tienda.length; j++) {
				if (tienda[j].equalsIgnoreCase(listadoProductos[i])){
					if (listadoProductos[i].equalsIgnoreCase("MANZANA") ||
						listadoProductos[i].equalsIgnoreCase("UVA") ||
						listadoProductos[i].equalsIgnoreCase("NARANJA")){
						sumaCostos += FRUTA;
					} else if (listadoProductos[i].equalsIgnoreCase("JUGO") ||
					listadoProductos[i].equalsIgnoreCase("VINO") ||
					listadoProductos[i].equalsIgnoreCase("GASEOSA")){
						sumaCostos += BEBIDA;
					} else {
						sumaCostos += RESTO;
					}
				}
			}
		}
		System.out.println(sumaCostos);
	}
}
