package Logica;
import TDAMapeo.*;
import TDAArbolBinario.*;
import TDALista.*;
import TDAPila.*;

/**
 * Clase Programa
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 */
public class Programa {

	private HashAbiertoMap<String,Double> Variables;
	private ArbolBinarioEnlazado<String> Expresion;
	
	/**
	 * Inicializa un instancia de la clase programa
	 */
	public Programa() {
		Variables=new HashAbiertoMap<String,Double>();
		Expresion=new ArbolBinarioEnlazado<String>();
	}
	
	/**
	 * Agrega una nueva variable al programa con nombre y valor paramtrizados, si la varaible ya existe sobrescribe su valor con el parametrizado
	 * @param s nombre de la variable
	 * @param i valor de la variable
	 * @throws VariableException si el nombre de la varaible es invalido
	 */
	public void nuevaVariable(String s,Double i)throws VariableException {
		char[] var=s.toCharArray();
		for(int h=0;h<var.length;h++)
			if(var[h]=='+' || var[h]=='-' || var[h]=='*' || var[h]=='/' || var[h]=='^' || var[h]=='(' || var[h]==')')
				throw new VariableException("Variable con Operandos");
		try {
		Variables.put(s,i);
		}catch(InvalidKeyException e) {};
	}
	
	/**
	 * Devuelve las variables con su nombre y valor
	 * @return  String con la clave y valor de todas las variables
	 */
	public String mostrarVariables() {
		String vars=new String();
		for(Entry<String,Double> e:Variables.entries())
			vars+=e.getKey()+"=="+e.getValue()+"\n";
		return vars;	
	}
	
	/**Devuevle si una expresion pasada por parametro es infija 
	 * @param String expresion a evaluar
	 * @return Verdadero si es Infija Falso en caso contrario
	 */
	public boolean esInfija(String c){
		  char [] S = c.toCharArray();
		  int i = 0;
		  int j = 0;
		  int cant = 0;
		  int cant2 = 0;
		  boolean es = true, sigo = true;
		  
		  if(S[0] == '(' && S[S.length-1] == ')') 
			  while (es && i < S.length){
				  j = i +1;
				  	if(S[i] == '('){
				  		cant++;
				  		if(j < S.length) {
				  			if (S[j] == '+' || S[j] == '-' || S[j] == '*' || S[j] == '/' || S[j] == '^' || S[j] == ')')
				  				es = false;}
				  		else
				  			es = false;
				  	} 
				  	else
				  		if(S[i] == ')'){
				  			cant--;
				  			cant2--;
				  			if(j < S.length)
				  				if (S[j] == '(')
				  					es = false;
				  		}
				  		else
				  			if(S[i] == '+' || S[i] == '-' || S[i] == '*' || S[i] == '/' || S[i] == '^') {
				  				cant2++;
				  				while(es == true && sigo == true && j < S.length)
				  					if(j<S.length)
				  						if(S[j] == '+' || S[j] == '-' || S[j] == '*' || S[j] == '/' || S[j] == '^' || S[j] == ')')
				  							es = false;
				  						else
				  							if (S[j] == '(') {
				  								cant++;
				  								j++;
				  							}
				  							else
				  								sigo = false;
				  					else
				  						es = false;
				  			}
				  	if (cant < 0)
				  		es = false; 
				  	sigo = true;
				  	i = j; 
			  }
		  else
			  es = false;
		  if(cant != 0 && es)
			  es = false;
		  if(cant2 != 0)
			  es = false;
		  return es;
		}
	
	/**
	 * Crea un Arbol Binario con una expresion infija pasada por parametro, excluyendo los parentesis y respetado el orden de procedencia de las operaciones
	 * @param String una expresion infija totalmente parentizada
	 * @throws InvalidKeyException si S(la expresion) ultiza alguna variable que no esta definida en el programa
	 */
	public void crearArbol(String S) throws InvalidKeyException{
		char[] C=S.toCharArray();
		String[] W=crearArreglo(C);
		Stack<ArbolBinarioEnlazado<String>> P=new PilaEnlazada<ArbolBinarioEnlazado<String>>();
		try {
		for(int i=0;i<W.length;i++)
			{if(!W[i].equals("("))
				{if(!W[i].equals(")"))
					{	if(!W[i].equals("+") && !W[i].equals("-") && !W[i].equals("*") && !W[i].equals("/") && !W[i].equals("^"))
							if(Variables.get(W[i])==null)
								throw new InvalidKeyException("Clave Invalida");
						ArbolBinarioEnlazado<String> T=new ArbolBinarioEnlazado<String>();
						T.createRoot(W[i]);
						P.push(T);
						}
				else
					{ArbolBinarioEnlazado<String> T1=P.pop();
					ArbolBinarioEnlazado<String> T2=P.pop();
					ArbolBinarioEnlazado<String> T3=P.pop();
					T2.Attach(T2.root(), T3, T1);
					P.push(T2);
					}
				}
						
					
			}
		Expresion=P.pop();
		}catch(EmptyTreeException | InvalidPositionException | InvalidOperationException | EmptyStackException e) {}
	}	
	
	private String[] crearArreglo(char[] T) {
		String[] N=new String[T.length];
		int j=0;
		int i=0;
		while(i<T.length)
			{if(T[i]=='(' || T[i]==')' || T[i]=='+' || T[i]=='*' || T[i]=='-' || T[i]=='^' || T[i]=='/')
				N[j++]=(""+T[i++]+"");
			else
				{String var=new String();	
				while(T[i]!=')' && T[i]!=')' && T[i]!='+' && T[i]!='*' && T[i]!='/' && T[i]!='-' && T[i]!='^')
				{var+=T[i++];}
				N[j++]=var;}
			}
		String[] S=new String[j];
		for(int h=0;h<S.length;h++)
			S[h]=N[h];
	return S;
	}
	
	/**
	 * Retorna la expresion en notacion Prefija
	 * @return String expresion prefija
	 */
	public String prefija() {
		String pre=new String();
		ListaSimplementeEnlazada<Position<String>> S=new ListaSimplementeEnlazada<Position<String>>();
		try {
			preorder(Expresion.root(),S);
		for(Position<String> e:S)
			pre+=e.element();
		}catch(InvalidPositionException | EmptyTreeException e) {}
		return pre;
	}
	
	private void preorder(Position<String> n, PositionList<Position<String>> l) throws InvalidPositionException{
		try {
			l.addLast(n);
		if (Expresion.hasLeft(n))
			preorder(Expresion.left(n), l);
		if (Expresion.hasRight(n))
			preorder(Expresion.right(n), l);
		}catch(BoundaryViolationException | InvalidPositionException e) {}
}
	
	/**
	 * * Retorna la expresion en notacion Posfija
	 * @return String expresion posfija
	 */
	public String postfija() {
		String pos=new String();
		ListaSimplementeEnlazada<Position<String>> S= new ListaSimplementeEnlazada<Position<String>>();
		try {
		ordenar(Expresion.root(),S);
		for(Position<String> e:S)
			pos+=e.element();
		}catch(InvalidPositionException | EmptyTreeException e) {}
		return pos;
	}
	
	private void ordenar(Position<String> n, PositionList<Position<String>> l) throws InvalidPositionException{
		try {
		if (Expresion.hasLeft(n))
			ordenar(Expresion.left(n), l);
		if (Expresion.hasRight(n))
			ordenar(Expresion.right(n), l);
		l.addLast(n);
		}catch(BoundaryViolationException | InvalidPositionException e) {}
}
	
	/**
	 * Retorna una expresion infija del ArbolBinario
	 * @return String igual a la expresion del arbol en forma infija
	 */
	public String infija() {
		String inf=new String();
		try {
			inf=infijaRec(Expresion.root());
		}catch(EmptyTreeException e) {}
		return inf;
		}
	
	private String infijaRec(Position<String> e) {
		String exp=new String();
		try {
		if(Expresion.isInternal(e)) {
			exp+="(";
			exp+=infijaRec(Expresion.left(e));
			exp+=e.element();
			exp+=infijaRec(Expresion.right(e));
			exp+=")";
			return exp;}
		else
			return exp+=e.element();
		}catch(InvalidPositionException | BoundaryViolationException w) {}
		return exp;
		}
		
		/**
		 * Retorna el resultado de resolver la expresion del arbol utilizando una pila
		 * @param String la expresion a resolver en forma infija
		 * @return String con el resultado de resolver la expresion con las variables y valores
		 * @throws InvalidKeyException si S(la expresion) ultiza alguna variable que no esta en el Mapeo
		 */
		public String resolver(String S) throws InvalidKeyException,CeroException{
			char[] C=S.toCharArray();
			String[] W=crearArreglo(C);
			Stack<String> P=new PilaEnlazada<String>();
			try {
			for(int i=0;i<W.length;i++)
				{if(!W[i].equals("("))
					{if(!W[i].equals(")"))
						{if(!W[i].equals("+") && !W[i].equals("-") && !W[i].equals("*") && !W[i].equals("/") && !W[i].equals("^"))
							P.push(""+Variables.get(W[i]));
							else
								P.push(W[i]);}
					else
						{Double V1=Double.parseDouble(P.pop());
						String T2=P.pop();
						Double V2=Double.parseDouble(P.pop());
						if(T2.equals("+"))
							T2=""+(V1+V2);
						else
							if(T2.equals("-"))
								T2=""+(V2-V1);
							else			
								if(T2.equals("*"))
									T2=""+(V1*V2);
								else
									if(T2.equals("/"))
									{if(V1==0)
										throw new CeroException("Division por Cero");
										T2=""+(V2/V1);}
									else
										if(T2.equals("^"))
											T2=""+Math.pow(V2,V1);
						P.push(T2);
						}
					}
							
						
				}
			return P.pop();
			}catch(EmptyStackException e) {}
		return "Error";
		}
		
		/**
		 * Resuelve la expresion del ArbolBinario utilizando recursividad
		 * @return Double es igual al valor de resolver la expresion con las variables y valores
		 */
		public Double resolverRec()throws CeroException {
			try {
			return rec(Expresion.root(),Expresion);
			}catch(EmptyTreeException | CeroException e) {
				throw new CeroException("Division por cero");
			}
		}
		
		private Double rec(Position<String> n,BinaryTree<String> T)throws CeroException {
			Double V1=0.0;Double V2=0.0;
			try {
			if(T.isInternal(n)){
					V1=rec(T.left(n),T);
					V2=rec(T.right(n),T);
				if(n.element().equals("+"))
					return (V1+V2);
				else
					if(n.element().equals("-"))
						return (V1-V2);
					else			
						if(n.element().equals("*"))
							return (V1*V2);
						else
							if(n.element().equals("/"))
							{if(V2==0)
								throw new CeroException("Division por Cero");
								return (V1/V2);}
							else
								if(n.element().equals("^"))
									return Math.pow(V1,V2);
			}
			return Variables.get(n.element());
			}catch(BoundaryViolationException | InvalidPositionException | InvalidKeyException e) {}
		return 0.0;	
		}
		
		/**
		 * Devuele la altura del ArbolBinario
		 * @return int que es la altura del ArbolBinario
		 */
		public int altura() {
			int h = 0;
			for(Position<String> p : Expresion.positions())
			try{
				if(Expresion.isExternal(p))
					h = Math.max(h, profundidad(p));
			}
			catch (InvalidPositionException e) {}
			return h;
			}
		private int profundidad(Position<String> p) {
			try {
			if(Expresion.isRoot(p))
				return 0;
			else
				return 1 + profundidad(Expresion.parent(p));
			}
			catch (InvalidPositionException | BoundaryViolationException e) {}
			return 0;
			}
		
		/**
		 * Devuelve una PilaEnlazada<Position<String>> con las Posiciones que tienen hijos externos y que tienen como elemento operandos de subexpresiones
		 * @return PilaEnlazada<Position<String>> de Poiciones  con hijos externos
		 */
		public PilaEnlazada<Position<String>> simplificar() {
			PilaEnlazada<Position<String>> P=new PilaEnlazada<Position<String>>();
			try {
			if(Expresion.size()!=0 && Expresion.size()!=1)
				if(Expresion.isInternal(Expresion.left(Expresion.root())) || Expresion.isInternal(Expresion.right(Expresion.root())))
					{simplificarRec(Expresion.left(Expresion.root()),P);
						simplificarRec(Expresion.right(Expresion.root()),P);}
			}catch(BoundaryViolationException | InvalidPositionException | EmptyTreeException e) {}
			return P;		
			}
		
		private void simplificarRec(Position<String> n,PilaEnlazada<Position<String>> P) {
			try {
			if(Expresion.isInternal(n))
			{
				if(Expresion.isExternal(Expresion.left(n)) && Expresion.isExternal(Expresion.right(n)))
					P.push(n);
				else
					{if(Expresion.isInternal(Expresion.left(n)))
						simplificarRec(Expresion.left(n),P);
					if(Expresion.isInternal(Expresion.right(n)))
								simplificarRec(Expresion.right(n),P);}
			}
			}catch(BoundaryViolationException | InvalidPositionException e) {}
		}
		
		/**
		 * Recibe la nueva variable de la subexpresion y la posicion donde se remplazara la variable,removinedo del ArbolBinario los hijos de la posicion y agregando a mi Mapeo la varaible con el valor de la subexpresion
		 * @param n Position<String> la posicion donde se guardara la nueva variable de la subexpresion, remplazando la anterior
		 * @param nuevo String nombre de la nueva variable de la subexpresion 
		 */
		public void subexpresion(Position<String> n,String nuevo) {
			
			try {
			Double new2=0.0;
			Double V1=Variables.get(Expresion.remove(Expresion.left(n)));
			Double V2=Variables.get(Expresion.remove(Expresion.right(n)));
			if(n.element().equals("+"))
				new2=(V1+V2);
			else
				if(n.element().equals("-"))
					new2=(V1+V2);
				else			
					if(n.element().equals("*"))
						new2=(V1*V2);
					else
						if(n.element().equals("/"))
							new2=(V1/V2);
						else
							if(n.element().equals("^"))
								new2=Math.pow(V1,V2);
			Expresion.replace(n,nuevo);
			Variables.put(nuevo, new2);
			}catch(InvalidKeyException | InvalidPositionException | BoundaryViolationException | InvalidOperationException  e) {}
		}
					
	/**
	 * Devuelve la cantidad de hijos externos que tiene el ArbolBinario	
	 * @return int con la cantidad de hijos externos del ArbolBinario
	 */
	public int hojas() {
		int cant=0;
		try {
		for(Position<String> e:Expresion.positions())
			if(Expresion.isExternal(e))
				cant++;
		}catch(InvalidPositionException w) {}
		return cant;
	}
	
	/**
	 * Devuelve la cantidad de nodos internos que tiene el ArbolBinario
	 * @return int con la cantidad de nodos internos del ArbolBinario
	 */
	public int nodosInt() {
		int cant=0;
		try {
		for(Position<String> e:Expresion.positions())
			if(Expresion.isInternal(e))
				cant++;
		}catch(InvalidPositionException w) {}
		return cant;
	}
	
	/**
	 * Devuelve la cantidad de nodos del ArbolBinario
	 * @return int con la cantidad de nodos del ArbolBinario
	 */
	public int nodos() {
		return Expresion.size();
	}
	
	/**
	 * Devuelve el elemento de la Position pasada por parametro
	 * @param n Position<String> la posicion donde esta el elemento
	 * @return String con el nombre de la variable en la posicion
	 */
	public String variable(Position<String> n) {
		return n.element();
	}
	
	/**
	 * Devuelve el elemento de la Position a la izquierda de la Position pasada por parametro
	 * @param n Position<String> la posicion del padre de la posicion del elemento
	 * @return  String con el nombre de la variable en la Position a la izquierda de posicion
	 */
	public String variableIzq(Position<String> n) {
		String ret=new String();
		try {
			ret=Expresion.left(n).element();
		}catch(InvalidPositionException | BoundaryViolationException e) {}
		return ret;
	}
	
	/**
	 * Devuelve el elemento de la Position a la derecha de la Position pasada por parametro
	 * @param n Position<String> la posicion del padre de la posicion del elemento
	 * @return String con el nombre de la variable en la Position a la derecha de posicion
	 */
	public String variableDer(Position<String> n) {
		String ret=new String();
		try {
			ret=Expresion.right(n).element();
		}catch(InvalidPositionException | BoundaryViolationException e) {}
		return ret;
	}
}
		


		
		