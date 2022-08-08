package designPatternPkg;

class type
{
	//바디만 존재.
}
class typeA extends type //상속
{
	public typeA()
	{
		System.out.println("A의 객체가 생성됨");
	}
}

class typeB extends type
{
	public typeB()
	{
		System.out.println("B의 객체가 생성됨");
	}
}

class typeC extends type
{
	public typeC()
	{
		System.out.println("C의 객체가 생성됨");
	}
}

class factory
{
	public type factoryMethod(String type)
	{
		type typeReturn = null;
		switch(type)
		{
		case"A":
			typeReturn = new typeA();
			break;
		case"B":
			typeReturn = new typeB();
			break;
		case"C":
			typeReturn = new typeC();
			break;
			
		default:
		    System.out.println("입력한 이름의 클래스가 존재하지 않습니다.");
            break;		
		}
		return typeReturn;
	}
}
public class factoryMethod {
	public static void main(String[] args) {
		//펙토리 메소드 패턴(factory method pattern)
		//어떤 상황에서 조건에 따라 객체를 다르게 생성해야 할 때가 있습니다.
		//예를 들어, 사용자의 입력값에 따라 하는 일이 달라질 경우
		
		//펙토리 메소드는 펙토리라는 클래스에 객체생성을 위임하여 펙토리 클래스가 객체를 생성하도록 하는 방식이다.
		//말그대로 공장!
		
		factory C1 = new factory();
		C1.factoryMethod("A"); //이런식으로 외부에서 각각의 객체를 불러오지 않아도 펙토리 메소드를 사용하면 간단하게 불러올 수 있다.
		C1.factoryMethod("B");
		C1.factoryMethod("C");
		C1.factoryMethod("D");

	}
}
