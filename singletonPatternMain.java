class function
{
	public function()
	{
		
	}
	void result()
	{
		System.out.println("이게 싱글톤 패턴입니다.");
	}
}

class Singleton
{
	private static Singleton instance;
	private Singleton(){}
	static Singleton createInstance()
	{
		if(instance == null)
		{
			instance = new Singleton();
		}
		else 
		{
			return instance;
		}
		return instance;
	}
	function create()
	{
		return new function();
	}
}
public class singletonPatternMain {

	public static void main(String[] args) {
		
		Singleton s1 = Singleton.createInstance(); //new를 쓸 필요가 없다.
		Singleton s2 = Singleton.createInstance(); //new를 쓸 필요가 없다.
		System.out.println(s1); //싱글톤 패턴의 특성상 주소값이 같게 나오는 것을 확인할 수 있다.
		System.out.println(s2);
		
		function f1 =  s1.create(); //여기도  new를 쓸 필요가 없다.
		function f2 =  s1.create();
		
		f1.result();
		f2.result();
		
	}
}
