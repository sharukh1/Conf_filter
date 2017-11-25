
public class StringFunction {

	static String output = new String();
    public static final String reverseWithStringConcat(String string) {
        
        for (int i = (string.length() - 1); i >= 0; i--) {
            output += (string.charAt(i));
            //System.out.println(output);
        }
        return output;
    }


	public static void main(String[] args) {
		String name="mada";
		System.out.println(StringFunction.reverseWithStringConcat(name));
		if(name.equalsIgnoreCase(output)) {
			System.out.println("pali");
		}else {
			System.out.println("non pali");
		}

	}

}
