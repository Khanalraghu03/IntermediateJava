package practice.Ch10;

public class StringWords {
	public static void main(String[] args) {
		String[] words = {"funk", "chunk", "furry", "baconator"};
		
		//Starts with
		for (String w: words) {
			if(w.startsWith("fu")) {
				System.out.println(w + " starts with fu");
			}
		}
		//ends with
		for(String w: words) {
			if(w.endsWith("unk")) {
				System.out.println(w + " ends with unk");
			}
		}
		
		
/////////////////////////////////////////////////////////////////////////////
		String r = "raghukhanalraghukhanalraghukhanalraghukhanal";
		System.out.println(r.indexOf('g')); //Search for the first index of g and ignore the rest
		System.out.println(r.indexOf('g', 3));	//3 is the starting point for it to search from
		
		//////////////////////////////////////////
		
		String a = "Raghu ";
		String b = "Khanal";
		System.out.println(a + b);
		System.out.println(a.concat(b));
		System.out.println(a.replace('a', 'k'));
		System.out.println(b.toUpperCase());
		
		String c = "          rag";
		System.out.println(c);
		System.out.println(c.trim());
		
		/////////////////////////////////////////////
	}

}
