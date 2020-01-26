package demoBuilderPatternConcept;

public class DemoBuilderPattern2 {
	
	
	public DemoBuilderPattern2 S1()
	{
		System.out.println("From S1()");
		return this;
	}

	
	public DemoBuilderPattern2 S2()
	{
		System.out.println("From S2()");
		return this;
	}
	
	public DemoBuilderPattern2 S3(String param)
	{
		System.out.println("From S3(String param)");
		return this;
	}

	public static void main(String[] args) {
		DemoBuilderPattern2 dbp2=new DemoBuilderPattern2();
		dbp2.S1().S2().S3("Hello this is the builder pattern concept");
	}

}
