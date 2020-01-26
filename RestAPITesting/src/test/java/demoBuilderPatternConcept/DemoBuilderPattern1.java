package demoBuilderPatternConcept;

public class DemoBuilderPattern1 {
	
		
	public void S1()
	{
		System.out.println("From S1()");
	}

	
	public void S2()
	{
		System.out.println("From S2()");
	}
	
	public void S3(String param)
	{
		System.out.println("From S3(String param)");
	}
	
	public static void main(String[] args) {
		
		DemoBuilderPattern1 dbp=new DemoBuilderPattern1();
		dbp.S1();
		dbp.S2();
		dbp.S3("Builder pattern");
		
	}
	

}
