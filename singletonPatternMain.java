package singletonPatternPkg;

class function
{
	public function()
	{
		
	}
	void result()
	{
		System.out.println("�̰� �̱��� �����Դϴ�.");
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
		
		Singleton s1 = Singleton.createInstance(); //new�� �� �ʿ䰡 ����.
		Singleton s2 = Singleton.createInstance(); //new�� �� �ʿ䰡 ����.
		System.out.println(s1); //�̱��� ������ Ư���� �ּҰ��� ���� ������ ���� Ȯ���� �� �ִ�.
		System.out.println(s2);
		
		function f1 =  s1.create(); //���⵵  new�� �� �ʿ䰡 ����.
		function f2 =  s1.create();
		
		f1.result();
		f2.result();
		
	}
}
