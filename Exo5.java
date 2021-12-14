package td8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exo5 <E>{
	
	//Question 1 :
	public static <E> void echange(List<? super E> list, int a, int b) { //Question 2 (wildcard)
		Collections.swap(list, a, b); /*utilisée pour échanger les éléments aux positions spécifiées dans la liste spécifiée. 
										Si les positions spécifiées sont égales, l'invocation de cette méthode laisse la liste inchangée.*/
		E temp = (E) list.get(a);  		/*utilisé pour récupérer l’élément d’une position spécifiée dans la liste.*/
		list.set(a, (E) list.get(b));
		list.set(b, temp);
	}
	//Question 3:
	public static void melange(List<?> liste) {
		Collections.shuffle(liste);
		
		for(int i=0; i<liste.size(); i++) {
			Collections.swap(liste, (int) (Math.random() * (liste.size())), (int) (Math.random() * (liste.size())));
		}
	}
	
	//Question 4 : On convertit en tableau
	public static <E> List<E> melange2(List<E> l) {
		E[] array = (E[]) l.toArray();
		E[] e = array;
		Random hasard = new Random();
		for(int o = l.size()-1; o>0; o--) {
			int j = hasard.nextInt(o);
			echange2(e, o, j);
		}
		return l = Arrays.asList(e);
	}
	
	public static <E> void echange2(E[] l, int i, int j) {
		E temp = l[i];
		l[i] = l[j];
		l[j] = temp;
	}
	
	public static void main(String[] args) {
		List<String> liste1 = Arrays.asList("table", "cle", "chaise");
		List<Integer> liste2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,9);
		List<Integer> liste3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,9,10);
		echange(liste1, 0, 2);
		echange(liste2, 2, 7);
		System.out.println(liste1);
		System.out.println(liste2);
		melange(liste1);
		melange(liste2);
		System.out.println(liste1);
		System.out.println(liste2);
	
		Object[] l4 = liste1.toArray();
		List<Integer> l5 = melange2(liste3);
		System.out.println(l5);
		echange2(l4, 0, 1);
		System.out.println(l4[0]);
	}
}
