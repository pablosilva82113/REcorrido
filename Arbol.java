
public class Arbol {
	private Nodo raiz;
	private String Recorrido;
	public Arbol() {
		raiz=null;
		Recorrido="";
	}
	//////metodo a envolver
	private void insertarDesde(Nodo noda,Nodo Desde) {
		//esto pasa cuando la raiz es null
		//es el primer elemento
	if(Desde.obtenerData()==noda.obtenerData()) {
					return;
			}
	if(noda.obtenerData()>Desde.obtenerData()) {
	//colocar ala derecha
	if(Desde.Der==null) {
			Desde.Der=noda;
			return;
	}else {
		insertarDesde(noda,Desde.Der);
		return;
	}
	}else {
		//colocar en la izquierda
		if(Desde.Izq==null) {
				Desde.Izq=noda;
				return;
				}else {
					insertarDesde(noda,Desde.Izq);
					return;
				}
			}
	}
	//metodo que envuelve wrapper
	public void insertar(Nodo noda) {
		if(raiz==null) {
			raiz=noda;
			return; 
		}
		///////////////////////////////////
		//cuando la raiz no es nula
		insertarDesde(noda,raiz);
	}
	public boolean buscar(Nodo noba) {
		return buscarDesde(noba,raiz);
	}
	private boolean buscarDesde(Nodo noba,Nodo Desde) {
		if(Desde==null) {
			return false;
		}
		//cuando el nodo es el encontrado
		if(Desde.obtenerData()==noba.obtenerData()) {
			return true;
	}
		if(noba.obtenerData()>Desde.obtenerData()) {
			//derecha
			return buscarDesde(noba,Desde.Der);
		}else {
			//izquierda
			return buscarDesde(noba,Desde.Izq);
		}
	}
	public String toStringPreorder() {
		Recorrido="";
		//////////////////////////////
		preOrder(raiz);
		/////////////////////////////
		return Recorrido;
	}
	//VID
	private void preOrder(Nodo Desde) {
		if(Desde==null) {
			return ;
		}
		Recorrido=Recorrido + " " + Desde;
		//Izq
		preOrder(Desde.Izq);
		//Der
		preOrder(Desde.Der);
	}
	//IVD
	public String toStringInOrder() {
		Recorrido="";
		//////////////////////////////
		inOrder(raiz);
		/////////////////////////////
		return Recorrido;
	}
	///////////////////////////////
	private void inOrder(Nodo Desde) {
		if(Desde==null) {
			return ;
		}
		//Izq
		inOrder(Desde.Izq);
		////
		Recorrido=Recorrido + " " + Desde;
		//Der
		inOrder(Desde.Der);
	}
	//IDV
	public String toStringPostOrder() {
	Recorrido="";
	//////////////////////////////
	postOrder(raiz);
	/////////////////////////////
	return Recorrido;
	}
	///////////////////////////////
	private void postOrder(Nodo Desde) {
		if(Desde==null) {
			return ;
		}
		//Izq
		postOrder(Desde.Izq);
		//Der
		postOrder(Desde.Der);
		////
		Recorrido=Recorrido + " " + Desde;
	}
}
